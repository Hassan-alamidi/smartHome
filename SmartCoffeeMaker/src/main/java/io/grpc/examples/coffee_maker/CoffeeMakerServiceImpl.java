// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: coffeeMaker.proto

package io.grpc.examples.coffee_maker;

public final class CoffeeMakerServiceImpl {
  private CoffeeMakerServiceImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_coffeeMaker_BrewType_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_coffeeMaker_BrewType_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_coffeeMaker_Response_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_coffeeMaker_Response_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_coffeeMaker_Empty_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_coffeeMaker_Empty_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\021coffeeMaker.proto\022\013coffeeMaker\"m\n\010Brew" +
      "Type\022,\n\010BrewType\030\001 \001(\0162\032.coffeeMaker.Bre" +
      "wType.type\"3\n\004type\022\n\n\006CARAFE\020\000\022\017\n\013HALF_C" +
      "ARAFE\020\001\022\016\n\nSINGLE_CUP\020\002\"*\n\010Response\022\014\n\004t" +
      "ext\030\001 \001(\t\022\020\n\010progress\030\002 \001(\001\"\007\n\005Empty2\221\001\n" +
      "\022CoffeeMakerService\022>\n\016setBrewingType\022\025." +
      "coffeeMaker.BrewType\032\025.coffeeMaker.Respo" +
      "nse\022;\n\014beginBrewing\022\022.coffeeMaker.Empty\032" +
      "\025.coffeeMaker.Response0\001B9\n\035io.grpc.exam" +
      "ples.coffee_makerB\026CoffeeMakerServiceImp" +
      "lP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_coffeeMaker_BrewType_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_coffeeMaker_BrewType_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_coffeeMaker_BrewType_descriptor,
        new java.lang.String[] { "BrewType", });
    internal_static_coffeeMaker_Response_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_coffeeMaker_Response_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_coffeeMaker_Response_descriptor,
        new java.lang.String[] { "Text", "Progress", });
    internal_static_coffeeMaker_Empty_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_coffeeMaker_Empty_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_coffeeMaker_Empty_descriptor,
        new java.lang.String[] { });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
