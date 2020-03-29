// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: oven.proto

package io.grpc.examples.oven;

/**
 * Protobuf type {@code oven.OvenStatus}
 */
public  final class OvenStatus extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:oven.OvenStatus)
    OvenStatusOrBuilder {
private static final long serialVersionUID = 0L;
  // Use OvenStatus.newBuilder() to construct.
  private OvenStatus(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private OvenStatus() {
    status_ = 0;
    currentTemp_ = 0F;
    remainingTime_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private OvenStatus(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {
            int rawValue = input.readEnum();

            status_ = rawValue;
            break;
          }
          case 21: {

            currentTemp_ = input.readFloat();
            break;
          }
          case 24: {

            remainingTime_ = input.readInt32();
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return io.grpc.examples.oven.OvenServiceImpl.internal_static_oven_OvenStatus_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.grpc.examples.oven.OvenServiceImpl.internal_static_oven_OvenStatus_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.grpc.examples.oven.OvenStatus.class, io.grpc.examples.oven.OvenStatus.Builder.class);
  }

  /**
   * Protobuf enum {@code oven.OvenStatus.Status}
   */
  public enum Status
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <code>OFF = 0;</code>
     */
    OFF(0),
    /**
     * <code>PRE_HEAT = 1;</code>
     */
    PRE_HEAT(1),
    /**
     * <code>READY = 2;</code>
     */
    READY(2),
    /**
     * <code>COOKING = 3;</code>
     */
    COOKING(3),
    UNRECOGNIZED(-1),
    ;

    /**
     * <code>OFF = 0;</code>
     */
    public static final int OFF_VALUE = 0;
    /**
     * <code>PRE_HEAT = 1;</code>
     */
    public static final int PRE_HEAT_VALUE = 1;
    /**
     * <code>READY = 2;</code>
     */
    public static final int READY_VALUE = 2;
    /**
     * <code>COOKING = 3;</code>
     */
    public static final int COOKING_VALUE = 3;


    public final int getNumber() {
      if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalArgumentException(
            "Can't get the number of an unknown enum value.");
      }
      return value;
    }

    /**
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static Status valueOf(int value) {
      return forNumber(value);
    }

    public static Status forNumber(int value) {
      switch (value) {
        case 0: return OFF;
        case 1: return PRE_HEAT;
        case 2: return READY;
        case 3: return COOKING;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<Status>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        Status> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<Status>() {
            public Status findValueByNumber(int number) {
              return Status.forNumber(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      return getDescriptor().getValues().get(ordinal());
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return io.grpc.examples.oven.OvenStatus.getDescriptor().getEnumTypes().get(0);
    }

    private static final Status[] VALUES = values();

    public static Status valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      if (desc.getIndex() == -1) {
        return UNRECOGNIZED;
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private Status(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:oven.OvenStatus.Status)
  }

  public static final int STATUS_FIELD_NUMBER = 1;
  private int status_;
  /**
   * <code>.oven.OvenStatus.Status status = 1;</code>
   */
  public int getStatusValue() {
    return status_;
  }
  /**
   * <code>.oven.OvenStatus.Status status = 1;</code>
   */
  public io.grpc.examples.oven.OvenStatus.Status getStatus() {
    @SuppressWarnings("deprecation")
    io.grpc.examples.oven.OvenStatus.Status result = io.grpc.examples.oven.OvenStatus.Status.valueOf(status_);
    return result == null ? io.grpc.examples.oven.OvenStatus.Status.UNRECOGNIZED : result;
  }

  public static final int CURRENTTEMP_FIELD_NUMBER = 2;
  private float currentTemp_;
  /**
   * <code>float currentTemp = 2;</code>
   */
  public float getCurrentTemp() {
    return currentTemp_;
  }

  public static final int REMAININGTIME_FIELD_NUMBER = 3;
  private int remainingTime_;
  /**
   * <code>int32 remainingTime = 3;</code>
   */
  public int getRemainingTime() {
    return remainingTime_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (status_ != io.grpc.examples.oven.OvenStatus.Status.OFF.getNumber()) {
      output.writeEnum(1, status_);
    }
    if (currentTemp_ != 0F) {
      output.writeFloat(2, currentTemp_);
    }
    if (remainingTime_ != 0) {
      output.writeInt32(3, remainingTime_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (status_ != io.grpc.examples.oven.OvenStatus.Status.OFF.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(1, status_);
    }
    if (currentTemp_ != 0F) {
      size += com.google.protobuf.CodedOutputStream
        .computeFloatSize(2, currentTemp_);
    }
    if (remainingTime_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, remainingTime_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof io.grpc.examples.oven.OvenStatus)) {
      return super.equals(obj);
    }
    io.grpc.examples.oven.OvenStatus other = (io.grpc.examples.oven.OvenStatus) obj;

    boolean result = true;
    result = result && status_ == other.status_;
    result = result && (
        java.lang.Float.floatToIntBits(getCurrentTemp())
        == java.lang.Float.floatToIntBits(
            other.getCurrentTemp()));
    result = result && (getRemainingTime()
        == other.getRemainingTime());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + STATUS_FIELD_NUMBER;
    hash = (53 * hash) + status_;
    hash = (37 * hash) + CURRENTTEMP_FIELD_NUMBER;
    hash = (53 * hash) + java.lang.Float.floatToIntBits(
        getCurrentTemp());
    hash = (37 * hash) + REMAININGTIME_FIELD_NUMBER;
    hash = (53 * hash) + getRemainingTime();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.grpc.examples.oven.OvenStatus parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.grpc.examples.oven.OvenStatus parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.grpc.examples.oven.OvenStatus parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.grpc.examples.oven.OvenStatus parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.grpc.examples.oven.OvenStatus parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.grpc.examples.oven.OvenStatus parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.grpc.examples.oven.OvenStatus parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.grpc.examples.oven.OvenStatus parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.grpc.examples.oven.OvenStatus parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.grpc.examples.oven.OvenStatus parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.grpc.examples.oven.OvenStatus parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.grpc.examples.oven.OvenStatus parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(io.grpc.examples.oven.OvenStatus prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code oven.OvenStatus}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:oven.OvenStatus)
      io.grpc.examples.oven.OvenStatusOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.grpc.examples.oven.OvenServiceImpl.internal_static_oven_OvenStatus_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.grpc.examples.oven.OvenServiceImpl.internal_static_oven_OvenStatus_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.grpc.examples.oven.OvenStatus.class, io.grpc.examples.oven.OvenStatus.Builder.class);
    }

    // Construct using io.grpc.examples.oven.OvenStatus.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      status_ = 0;

      currentTemp_ = 0F;

      remainingTime_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.grpc.examples.oven.OvenServiceImpl.internal_static_oven_OvenStatus_descriptor;
    }

    @java.lang.Override
    public io.grpc.examples.oven.OvenStatus getDefaultInstanceForType() {
      return io.grpc.examples.oven.OvenStatus.getDefaultInstance();
    }

    @java.lang.Override
    public io.grpc.examples.oven.OvenStatus build() {
      io.grpc.examples.oven.OvenStatus result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.grpc.examples.oven.OvenStatus buildPartial() {
      io.grpc.examples.oven.OvenStatus result = new io.grpc.examples.oven.OvenStatus(this);
      result.status_ = status_;
      result.currentTemp_ = currentTemp_;
      result.remainingTime_ = remainingTime_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof io.grpc.examples.oven.OvenStatus) {
        return mergeFrom((io.grpc.examples.oven.OvenStatus)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.grpc.examples.oven.OvenStatus other) {
      if (other == io.grpc.examples.oven.OvenStatus.getDefaultInstance()) return this;
      if (other.status_ != 0) {
        setStatusValue(other.getStatusValue());
      }
      if (other.getCurrentTemp() != 0F) {
        setCurrentTemp(other.getCurrentTemp());
      }
      if (other.getRemainingTime() != 0) {
        setRemainingTime(other.getRemainingTime());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      io.grpc.examples.oven.OvenStatus parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (io.grpc.examples.oven.OvenStatus) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int status_ = 0;
    /**
     * <code>.oven.OvenStatus.Status status = 1;</code>
     */
    public int getStatusValue() {
      return status_;
    }
    /**
     * <code>.oven.OvenStatus.Status status = 1;</code>
     */
    public Builder setStatusValue(int value) {
      status_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.oven.OvenStatus.Status status = 1;</code>
     */
    public io.grpc.examples.oven.OvenStatus.Status getStatus() {
      @SuppressWarnings("deprecation")
      io.grpc.examples.oven.OvenStatus.Status result = io.grpc.examples.oven.OvenStatus.Status.valueOf(status_);
      return result == null ? io.grpc.examples.oven.OvenStatus.Status.UNRECOGNIZED : result;
    }
    /**
     * <code>.oven.OvenStatus.Status status = 1;</code>
     */
    public Builder setStatus(io.grpc.examples.oven.OvenStatus.Status value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      status_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.oven.OvenStatus.Status status = 1;</code>
     */
    public Builder clearStatus() {
      
      status_ = 0;
      onChanged();
      return this;
    }

    private float currentTemp_ ;
    /**
     * <code>float currentTemp = 2;</code>
     */
    public float getCurrentTemp() {
      return currentTemp_;
    }
    /**
     * <code>float currentTemp = 2;</code>
     */
    public Builder setCurrentTemp(float value) {
      
      currentTemp_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>float currentTemp = 2;</code>
     */
    public Builder clearCurrentTemp() {
      
      currentTemp_ = 0F;
      onChanged();
      return this;
    }

    private int remainingTime_ ;
    /**
     * <code>int32 remainingTime = 3;</code>
     */
    public int getRemainingTime() {
      return remainingTime_;
    }
    /**
     * <code>int32 remainingTime = 3;</code>
     */
    public Builder setRemainingTime(int value) {
      
      remainingTime_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 remainingTime = 3;</code>
     */
    public Builder clearRemainingTime() {
      
      remainingTime_ = 0;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:oven.OvenStatus)
  }

  // @@protoc_insertion_point(class_scope:oven.OvenStatus)
  private static final io.grpc.examples.oven.OvenStatus DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.grpc.examples.oven.OvenStatus();
  }

  public static io.grpc.examples.oven.OvenStatus getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<OvenStatus>
      PARSER = new com.google.protobuf.AbstractParser<OvenStatus>() {
    @java.lang.Override
    public OvenStatus parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new OvenStatus(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<OvenStatus> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<OvenStatus> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.grpc.examples.oven.OvenStatus getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

