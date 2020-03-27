# -*- coding: utf-8 -*-
# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: heating.proto

from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from google.protobuf import reflection as _reflection
from google.protobuf import symbol_database as _symbol_database
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()




DESCRIPTOR = _descriptor.FileDescriptor(
  name='heating.proto',
  package='',
  syntax='proto3',
  serialized_options=None,
  serialized_pb=b'\n\rheating.proto\"\x1e\n\x0eStringResponse\x12\x0c\n\x04text\x18\x01 \x01(\t\"\x1e\n\rFloatResponse\x12\r\n\x05value\x18\x01 \x01(\x02\"\x1d\n\x0c\x46loatRequest\x12\r\n\x05value\x18\x01 \x01(\x02\"\x07\n\x05\x45mpty2\xb2\x01\n\x0eHeatingService\x12.\n\x14getSystemTempSetting\x12\x06.Empty\x1a\x0e.FloatResponse\x12:\n\x18\x63hangeSystemTempSettings\x12\r.FloatRequest\x1a\x0f.StringResponse\x12\x34\n\x19toggleHeatingSystemStatus\x12\x06.Empty\x1a\x0f.StringResponseb\x06proto3'
)




_STRINGRESPONSE = _descriptor.Descriptor(
  name='StringResponse',
  full_name='StringResponse',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='text', full_name='StringResponse.text', index=0,
      number=1, type=9, cpp_type=9, label=1,
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
  serialized_start=17,
  serialized_end=47,
)


_FLOATRESPONSE = _descriptor.Descriptor(
  name='FloatResponse',
  full_name='FloatResponse',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='value', full_name='FloatResponse.value', index=0,
      number=1, type=2, cpp_type=6, label=1,
      has_default_value=False, default_value=float(0),
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
  serialized_start=49,
  serialized_end=79,
)


_FLOATREQUEST = _descriptor.Descriptor(
  name='FloatRequest',
  full_name='FloatRequest',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='value', full_name='FloatRequest.value', index=0,
      number=1, type=2, cpp_type=6, label=1,
      has_default_value=False, default_value=float(0),
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
  serialized_start=81,
  serialized_end=110,
)


_EMPTY = _descriptor.Descriptor(
  name='Empty',
  full_name='Empty',
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
  serialized_start=112,
  serialized_end=119,
)

DESCRIPTOR.message_types_by_name['StringResponse'] = _STRINGRESPONSE
DESCRIPTOR.message_types_by_name['FloatResponse'] = _FLOATRESPONSE
DESCRIPTOR.message_types_by_name['FloatRequest'] = _FLOATREQUEST
DESCRIPTOR.message_types_by_name['Empty'] = _EMPTY
_sym_db.RegisterFileDescriptor(DESCRIPTOR)

StringResponse = _reflection.GeneratedProtocolMessageType('StringResponse', (_message.Message,), {
  'DESCRIPTOR' : _STRINGRESPONSE,
  '__module__' : 'heating_pb2'
  # @@protoc_insertion_point(class_scope:StringResponse)
  })
_sym_db.RegisterMessage(StringResponse)

FloatResponse = _reflection.GeneratedProtocolMessageType('FloatResponse', (_message.Message,), {
  'DESCRIPTOR' : _FLOATRESPONSE,
  '__module__' : 'heating_pb2'
  # @@protoc_insertion_point(class_scope:FloatResponse)
  })
_sym_db.RegisterMessage(FloatResponse)

FloatRequest = _reflection.GeneratedProtocolMessageType('FloatRequest', (_message.Message,), {
  'DESCRIPTOR' : _FLOATREQUEST,
  '__module__' : 'heating_pb2'
  # @@protoc_insertion_point(class_scope:FloatRequest)
  })
_sym_db.RegisterMessage(FloatRequest)

Empty = _reflection.GeneratedProtocolMessageType('Empty', (_message.Message,), {
  'DESCRIPTOR' : _EMPTY,
  '__module__' : 'heating_pb2'
  # @@protoc_insertion_point(class_scope:Empty)
  })
_sym_db.RegisterMessage(Empty)



_HEATINGSERVICE = _descriptor.ServiceDescriptor(
  name='HeatingService',
  full_name='HeatingService',
  file=DESCRIPTOR,
  index=0,
  serialized_options=None,
  serialized_start=122,
  serialized_end=300,
  methods=[
  _descriptor.MethodDescriptor(
    name='getSystemTempSetting',
    full_name='HeatingService.getSystemTempSetting',
    index=0,
    containing_service=None,
    input_type=_EMPTY,
    output_type=_FLOATRESPONSE,
    serialized_options=None,
  ),
  _descriptor.MethodDescriptor(
    name='changeSystemTempSettings',
    full_name='HeatingService.changeSystemTempSettings',
    index=1,
    containing_service=None,
    input_type=_FLOATREQUEST,
    output_type=_STRINGRESPONSE,
    serialized_options=None,
  ),
  _descriptor.MethodDescriptor(
    name='toggleHeatingSystemStatus',
    full_name='HeatingService.toggleHeatingSystemStatus',
    index=2,
    containing_service=None,
    input_type=_EMPTY,
    output_type=_STRINGRESPONSE,
    serialized_options=None,
  ),
])
_sym_db.RegisterServiceDescriptor(_HEATINGSERVICE)

DESCRIPTOR.services_by_name['HeatingService'] = _HEATINGSERVICE

# @@protoc_insertion_point(module_scope)