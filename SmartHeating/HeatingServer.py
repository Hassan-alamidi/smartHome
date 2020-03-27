from concurrent import futures
import logging
import heating_pb2
import heating_pb2_grpc

import grpc


class HeatingServer(heating_pb2_grpc.HeatingServiceServicer):

    systemTemp = 55
    systemOff = True

    def getSystemTempSetting(self, request, context):
        response = heating_pb2.FloatResponse()
        response.value = self.systemTemp
        return response

    def changeSystemTempSettings(self, request, context):
        self.systemTemp = request.value
        response = heating_pb2.StringResponse()
        response.text = "Temp setting changed"
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


def serve():
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=4))
    heating_pb2_grpc.add_HeatingServiceServicer_to_server(HeatingServer(), server)
    server.add_insecure_port('127.0.1.1:4000')
    server.start()
    print("Server is listening")
    server.wait_for_termination()


serve()
