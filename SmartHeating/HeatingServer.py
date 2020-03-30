from concurrent import futures
import logging

from grpc._channel import _InactiveRpcError

import heating_pb2
import heating_pb2_grpc
import jmDnsHandler_pb2
import jmDnsHandler_pb2_grpc

import grpc


class HeatingServer(heating_pb2_grpc.HeatingServiceServicer):

    systemTemp = 55
    systemTempMax = 100
    systemTempMin = 10
    systemOff = True

    def getSystemTempSetting(self, request, context):
        # return the current temperature setting to the client
        response = heating_pb2.IntResponse()
        response.value = self.systemTemp
        return response

    def changeSystemTempSettings(self, request, context):
        # change the current system temperature setting and respond to user
        response = heating_pb2.StringResponse()
        if self.systemTempMin < request.value < self.systemTempMax:
            self.systemTemp = request.value
            response.text = "Temp setting changed"
        else:
            response.text = "Temp is out of bounds"
        return response

    def toggleHeatingSystemStatus(self, request, context):
        # reverse the value of systems on/off status and return new value to client
        self.systemOff = not self.systemOff
        response = heating_pb2.StringResponse()
        if self.systemOff:
            message = "System has been turned off"
        else:
            message = "System is now turned on, house is now being heated"
        response.text = message
        return response


serverDetails = None
stub = None


def serve():
    # some global variables
    global serverDetails, stub
    try:
        # create a server with a thread pool of 4 (probably shouldn't use a thread pool at all
        # since this not only would run on a low end device with probably only one cpu core but even from
        # this theoretical project so many services are running at once that all cores will be fully utilized anyway
        server = grpc.server(futures.ThreadPoolExecutor(max_workers=4))
        heating_pb2_grpc.add_HeatingServiceServicer_to_server(HeatingServer(), server)
        server.add_insecure_port('127.0.1.1:4000')
        server.start()
        # create connection to the DNS server and register itself
        channel = grpc.insecure_channel('127.0.1.1:9090')
        stub = jmDnsHandler_pb2_grpc.DnsServiceStub(channel)
        serverDetails = jmDnsHandler_pb2.details(port=4000, type="_http._tcp.local.", name="Heating", path="path=index.html")
        stub.selfRegistration(serverDetails)

        print("Server is listening")
        server.wait_for_termination()
    except _InactiveRpcError as error:
        # if this exception is thrown then DNS server is not currently running
        print("Could not connect to DNS server make sure Dns server must be turned on first and all settings are correct")
    except:
        # if this exception is thrown then the server has run into an error or the server has been terminated
        # in which case unregister the service from the DNS server
        print("Shutting down")
        stub.selfUnregister(serverDetails)


serve()
