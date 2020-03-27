# Generated by the gRPC Python protocol compiler plugin. DO NOT EDIT!
import grpc

import jmDnsHandler_pb2 as jmDnsHandler__pb2


class DnsServiceStub(object):
  # missing associated documentation comment in .proto file
  pass

  def __init__(self, channel):
    """Constructor.

    Args:
      channel: A grpc.Channel.
    """
    self.selfRegistration = channel.unary_unary(
        '/DnsServer.DnsService/selfRegistration',
        request_serializer=jmDnsHandler__pb2.details.SerializeToString,
        response_deserializer=jmDnsHandler__pb2.Empty.FromString,
        )
    self.selfUnregister = channel.unary_unary(
        '/DnsServer.DnsService/selfUnregister',
        request_serializer=jmDnsHandler__pb2.details.SerializeToString,
        response_deserializer=jmDnsHandler__pb2.Empty.FromString,
        )


class DnsServiceServicer(object):
  # missing associated documentation comment in .proto file
  pass

  def selfRegistration(self, request, context):
    # missing associated documentation comment in .proto file
    pass
    context.set_code(grpc.StatusCode.UNIMPLEMENTED)
    context.set_details('Method not implemented!')
    raise NotImplementedError('Method not implemented!')

  def selfUnregister(self, request, context):
    # missing associated documentation comment in .proto file
    pass
    context.set_code(grpc.StatusCode.UNIMPLEMENTED)
    context.set_details('Method not implemented!')
    raise NotImplementedError('Method not implemented!')


def add_DnsServiceServicer_to_server(servicer, server):
  rpc_method_handlers = {
      'selfRegistration': grpc.unary_unary_rpc_method_handler(
          servicer.selfRegistration,
          request_deserializer=jmDnsHandler__pb2.details.FromString,
          response_serializer=jmDnsHandler__pb2.Empty.SerializeToString,
      ),
      'selfUnregister': grpc.unary_unary_rpc_method_handler(
          servicer.selfUnregister,
          request_deserializer=jmDnsHandler__pb2.details.FromString,
          response_serializer=jmDnsHandler__pb2.Empty.SerializeToString,
      ),
  }
  generic_handler = grpc.method_handlers_generic_handler(
      'DnsServer.DnsService', rpc_method_handlers)
  server.add_generic_rpc_handlers((generic_handler,))
