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
        response = heating_pb2.IntResponse()
        response.value = self.systemTemp
        return response

    def changeSystemTempSettings(self, request, context):
        response = heating_pb2.StringResponse()
        if self.systemTempMin < request.value < self.systemTempMax:
            self.systemTemp = request.value
            response.text = "Temp setting changed"
        else:
            response.text = "Temp is out of bounds"
        return response

    def toggleHeatingSystemStatus(self, request, context):
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
    global serverDetails, stub
    try:
        server = grpc.server(futures.ThreadPoolExecutor(max_workers=4))
        heating_pb2_grpc.add_HeatingServiceServicer_to_server(HeatingServer(), server)
        server.add_insecure_port('127.0.1.1:4000')
        server.start()

        channel = grpc.insecure_channel('127.0.1.1:9090')
        stub = jmDnsHandler_pb2_grpc.DnsServiceStub(channel)
        serverDetails = jmDnsHandler_pb2.details(port=4000, type="_http._tcp.local.", name="Heating", path="path=index.html")

        stub.selfRegistration(serverDetails)
        print("Server is listening")
        server.wait_for_termination()
    except _InactiveRpcError as error:
        print("Dns server must be turned on first")
    except:
        print("Shutting down")
        stub.selfUnregister(serverDetails)


serve()
