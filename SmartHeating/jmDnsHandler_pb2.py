# -*- coding: utf-8 -*-
# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: jmDnsHandler.proto

from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from google.protobuf import reflection as _reflection
from google.protobuf import symbol_database as _symbol_database
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()




DESCRIPTOR = _descriptor.FileDescriptor(
  name='jmDnsHandler.proto',
  package='DnsServer',
  syntax='proto3',
  serialized_options=None,
  serialized_pb=b'\n\x12jmDnsHandler.proto\x12\tDnsServer\"R\n\x07\x64\x65tails\x12\x0c\n\x04name\x18\x01 \x01(\t\x12\x0c\n\x04port\x18\x02 \x01(\x05\x12\x0f\n\x07\x61\x64\x64ress\x18\x03 \x01(\t\x12\x0c\n\x04type\x18\x04 \x01(\t\x12\x0c\n\x04path\x18\x05 \x01(\t\"\x07\n\x05\x45mpty2~\n\nDnsService\x12\x38\n\x10selfRegistration\x12\x12.DnsServer.details\x1a\x10.DnsServer.Empty\x12\x36\n\x0eselfUnregister\x12\x12.DnsServer.details\x1a\x10.DnsServer.Emptyb\x06proto3'
)




_DETAILS = _descriptor.Descriptor(
  name='details',
  full_name='DnsServer.details',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='name', full_name='DnsServer.details.name', index=0,
      number=1, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=b"".decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='port', full_name='DnsServer.details.port', index=1,
      number=2, type=5, cpp_type=1, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='address', full_name='DnsServer.details.address', index=2,
      number=3, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=b"".decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='type', full_name='DnsServer.details.type', index=3,
      number=4, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=b"".decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='path', full_name='DnsServer.details.path', index=4,
      number=5, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=b"".decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=33,
  serialized_end=115,
)


_EMPTY = _descriptor.Descriptor(
  name='Empty',
  full_name='DnsServer.Empty',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=117,
  serialized_end=124,
)

DESCRIPTOR.message_types_by_name['details'] = _DETAILS
DESCRIPTOR.message_types_by_name['Empty'] = _EMPTY
_sym_db.RegisterFileDescriptor(DESCRIPTOR)

details = _reflection.GeneratedProtocolMessageType('details', (_message.Message,), {
  'DESCRIPTOR' : _DETAILS,
  '__module__' : 'jmDnsHandler_pb2'
  # @@protoc_insertion_point(class_scope:DnsServer.details)
  })
_sym_db.RegisterMessage(details)

Empty = _reflection.GeneratedProtocolMessageType('Empty', (_message.Message,), {
  'DESCRIPTOR' : _EMPTY,
  '__module__' : 'jmDnsHandler_pb2'
  # @@protoc_insertion_point(class_scope:DnsServer.Empty)
  })
_sym_db.RegisterMessage(Empty)



_DNSSERVICE = _descriptor.ServiceDescriptor(
  name='DnsService',
  full_name='DnsServer.DnsService',
  file=DESCRIPTOR,
  index=0,
  serialized_options=None,
  serialized_start=126,
  serialized_end=252,
  methods=[
  _descriptor.MethodDescriptor(
    name='selfRegistration',
    full_name='DnsServer.DnsService.selfRegistration',
    index=0,
    containing_service=None,
    input_type=_DETAILS,
    output_type=_EMPTY,
    serialized_options=None,
  ),
  _descriptor.MethodDescriptor(
    name='selfUnregister',
    full_name='DnsServer.DnsService.selfUnregister',
    index=1,
    containing_service=None,
    input_type=_DETAILS,
    output_type=_EMPTY,
    serialized_options=None,
  ),
])
_sym_db.RegisterServiceDescriptor(_DNSSERVICE)

DESCRIPTOR.services_by_name['DnsService'] = _DNSSERVICE

# @@protoc_insertion_point(module_scope)
