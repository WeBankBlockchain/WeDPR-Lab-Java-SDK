// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: scd.proto

package com.webank.wedpr.scd.proto;

/**
 *
 *
 * <pre>
 * Certificate schema.
 * </pre>
 *
 * Protobuf type {@code com.webank.wedpr.scd.proto.CertificateSchema}
 */
public final class CertificateSchema extends com.google.protobuf.GeneratedMessageV3
        implements
        // @@protoc_insertion_point(message_implements:com.webank.wedpr.scd.proto.CertificateSchema)
        CertificateSchemaOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use CertificateSchema.newBuilder() to construct.
    private CertificateSchema(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }

    private CertificateSchema() {
        attributeName_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    }

    @Override
    @SuppressWarnings({"unused"})
    protected Object newInstance(UnusedPrivateParameter unused) {
        return new CertificateSchema();
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private CertificateSchema(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        this();
        if (extensionRegistry == null) {
            throw new NullPointerException();
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
                    case 10:
                        {
                            String s = input.readStringRequireUtf8();
                            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
                                attributeName_ = new com.google.protobuf.LazyStringArrayList();
                                mutable_bitField0_ |= 0x00000001;
                            }
                            attributeName_.add(s);
                            break;
                        }
                    default:
                        {
                            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        }
                }
            }
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
            throw e.setUnfinishedMessage(this);
        } catch (java.io.IOException e) {
            throw new com.google.protobuf.InvalidProtocolBufferException(e)
                    .setUnfinishedMessage(this);
        } finally {
            if (((mutable_bitField0_ & 0x00000001) != 0)) {
                attributeName_ = attributeName_.getUnmodifiableView();
            }
            this.unknownFields = unknownFields.build();
            makeExtensionsImmutable();
        }
    }

    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.webank.wedpr.scd.proto.Scd
                .internal_static_com_webank_wedpr_scd_proto_CertificateSchema_descriptor;
    }

    @Override
    protected FieldAccessorTable internalGetFieldAccessorTable() {
        return com.webank.wedpr.scd.proto.Scd
                .internal_static_com_webank_wedpr_scd_proto_CertificateSchema_fieldAccessorTable
                .ensureFieldAccessorsInitialized(
                        com.webank.wedpr.scd.proto.CertificateSchema.class,
                        com.webank.wedpr.scd.proto.CertificateSchema.Builder.class);
    }

    public static final int ATTRIBUTE_NAME_FIELD_NUMBER = 1;
    private com.google.protobuf.LazyStringList attributeName_;
    /** <code>repeated string attribute_name = 1;</code> */
    public com.google.protobuf.ProtocolStringList getAttributeNameList() {
        return attributeName_;
    }
    /** <code>repeated string attribute_name = 1;</code> */
    public int getAttributeNameCount() {
        return attributeName_.size();
    }
    /** <code>repeated string attribute_name = 1;</code> */
    public String getAttributeName(int index) {
        return attributeName_.get(index);
    }
    /** <code>repeated string attribute_name = 1;</code> */
    public com.google.protobuf.ByteString getAttributeNameBytes(int index) {
        return attributeName_.getByteString(index);
    }

    private byte memoizedIsInitialized = -1;

    @Override
    public final boolean isInitialized() {
        byte isInitialized = memoizedIsInitialized;
        if (isInitialized == 1) return true;
        if (isInitialized == 0) return false;

        memoizedIsInitialized = 1;
        return true;
    }

    @Override
    public void writeTo(com.google.protobuf.CodedOutputStream output) throws java.io.IOException {
        for (int i = 0; i < attributeName_.size(); i++) {
            com.google.protobuf.GeneratedMessageV3.writeString(output, 1, attributeName_.getRaw(i));
        }
        unknownFields.writeTo(output);
    }

    @Override
    public int getSerializedSize() {
        int size = memoizedSize;
        if (size != -1) return size;

        size = 0;
        {
            int dataSize = 0;
            for (int i = 0; i < attributeName_.size(); i++) {
                dataSize += computeStringSizeNoTag(attributeName_.getRaw(i));
            }
            size += dataSize;
            size += 1 * getAttributeNameList().size();
        }
        size += unknownFields.getSerializedSize();
        memoizedSize = size;
        return size;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof com.webank.wedpr.scd.proto.CertificateSchema)) {
            return super.equals(obj);
        }
        com.webank.wedpr.scd.proto.CertificateSchema other =
                (com.webank.wedpr.scd.proto.CertificateSchema) obj;

        if (!getAttributeNameList().equals(other.getAttributeNameList())) return false;
        if (!unknownFields.equals(other.unknownFields)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        if (memoizedHashCode != 0) {
            return memoizedHashCode;
        }
        int hash = 41;
        hash = (19 * hash) + getDescriptor().hashCode();
        if (getAttributeNameCount() > 0) {
            hash = (37 * hash) + ATTRIBUTE_NAME_FIELD_NUMBER;
            hash = (53 * hash) + getAttributeNameList().hashCode();
        }
        hash = (29 * hash) + unknownFields.hashCode();
        memoizedHashCode = hash;
        return hash;
    }

    public static com.webank.wedpr.scd.proto.CertificateSchema parseFrom(java.nio.ByteBuffer data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static com.webank.wedpr.scd.proto.CertificateSchema parseFrom(
            java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.webank.wedpr.scd.proto.CertificateSchema parseFrom(
            com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static com.webank.wedpr.scd.proto.CertificateSchema parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.webank.wedpr.scd.proto.CertificateSchema parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static com.webank.wedpr.scd.proto.CertificateSchema parseFrom(
            byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.webank.wedpr.scd.proto.CertificateSchema parseFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.webank.wedpr.scd.proto.CertificateSchema parseFrom(
            java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
                PARSER, input, extensionRegistry);
    }

    public static com.webank.wedpr.scd.proto.CertificateSchema parseDelimitedFrom(
            java.io.InputStream input) throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.webank.wedpr.scd.proto.CertificateSchema parseDelimitedFrom(
            java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
                PARSER, input, extensionRegistry);
    }

    public static com.webank.wedpr.scd.proto.CertificateSchema parseFrom(
            com.google.protobuf.CodedInputStream input) throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.webank.wedpr.scd.proto.CertificateSchema parseFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
                PARSER, input, extensionRegistry);
    }

    @Override
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(com.webank.wedpr.scd.proto.CertificateSchema prototype) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }

    @Override
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override
    protected Builder newBuilderForType(BuilderParent parent) {
        Builder builder = new Builder(parent);
        return builder;
    }
    /**
     *
     *
     * <pre>
     * Certificate schema.
     * </pre>
     *
     * Protobuf type {@code com.webank.wedpr.scd.proto.CertificateSchema}
     */
    public static final class Builder
            extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
            implements
            // @@protoc_insertion_point(builder_implements:com.webank.wedpr.scd.proto.CertificateSchema)
            com.webank.wedpr.scd.proto.CertificateSchemaOrBuilder {
        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
            return com.webank.wedpr.scd.proto.Scd
                    .internal_static_com_webank_wedpr_scd_proto_CertificateSchema_descriptor;
        }

        @Override
        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return com.webank.wedpr.scd.proto.Scd
                    .internal_static_com_webank_wedpr_scd_proto_CertificateSchema_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.webank.wedpr.scd.proto.CertificateSchema.class,
                            com.webank.wedpr.scd.proto.CertificateSchema.Builder.class);
        }

        // Construct using com.webank.wedpr.scd.proto.CertificateSchema.newBuilder()
        private Builder() {
            maybeForceBuilderInitialization();
        }

        private Builder(BuilderParent parent) {
            super(parent);
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {}
        }

        @Override
        public Builder clear() {
            super.clear();
            attributeName_ = com.google.protobuf.LazyStringArrayList.EMPTY;
            bitField0_ = (bitField0_ & ~0x00000001);
            return this;
        }

        @Override
        public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
            return com.webank.wedpr.scd.proto.Scd
                    .internal_static_com_webank_wedpr_scd_proto_CertificateSchema_descriptor;
        }

        @Override
        public com.webank.wedpr.scd.proto.CertificateSchema getDefaultInstanceForType() {
            return com.webank.wedpr.scd.proto.CertificateSchema.getDefaultInstance();
        }

        @Override
        public com.webank.wedpr.scd.proto.CertificateSchema build() {
            com.webank.wedpr.scd.proto.CertificateSchema result = buildPartial();
            if (!result.isInitialized()) {
                throw newUninitializedMessageException(result);
            }
            return result;
        }

        @Override
        public com.webank.wedpr.scd.proto.CertificateSchema buildPartial() {
            com.webank.wedpr.scd.proto.CertificateSchema result =
                    new com.webank.wedpr.scd.proto.CertificateSchema(this);
            int from_bitField0_ = bitField0_;
            if (((bitField0_ & 0x00000001) != 0)) {
                attributeName_ = attributeName_.getUnmodifiableView();
                bitField0_ = (bitField0_ & ~0x00000001);
            }
            result.attributeName_ = attributeName_;
            onBuilt();
            return result;
        }

        @Override
        public Builder clone() {
            return super.clone();
        }

        @Override
        public Builder setField(
                com.google.protobuf.Descriptors.FieldDescriptor field, Object value) {
            return super.setField(field, value);
        }

        @Override
        public Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor field) {
            return super.clearField(field);
        }

        @Override
        public Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneof) {
            return super.clearOneof(oneof);
        }

        @Override
        public Builder setRepeatedField(
                com.google.protobuf.Descriptors.FieldDescriptor field, int index, Object value) {
            return super.setRepeatedField(field, index, value);
        }

        @Override
        public Builder addRepeatedField(
                com.google.protobuf.Descriptors.FieldDescriptor field, Object value) {
            return super.addRepeatedField(field, value);
        }

        @Override
        public Builder mergeFrom(com.google.protobuf.Message other) {
            if (other instanceof com.webank.wedpr.scd.proto.CertificateSchema) {
                return mergeFrom((com.webank.wedpr.scd.proto.CertificateSchema) other);
            } else {
                super.mergeFrom(other);
                return this;
            }
        }

        public Builder mergeFrom(com.webank.wedpr.scd.proto.CertificateSchema other) {
            if (other == com.webank.wedpr.scd.proto.CertificateSchema.getDefaultInstance())
                return this;
            if (!other.attributeName_.isEmpty()) {
                if (attributeName_.isEmpty()) {
                    attributeName_ = other.attributeName_;
                    bitField0_ = (bitField0_ & ~0x00000001);
                } else {
                    ensureAttributeNameIsMutable();
                    attributeName_.addAll(other.attributeName_);
                }
                onChanged();
            }
            this.mergeUnknownFields(other.unknownFields);
            onChanged();
            return this;
        }

        @Override
        public final boolean isInitialized() {
            return true;
        }

        @Override
        public Builder mergeFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            com.webank.wedpr.scd.proto.CertificateSchema parsedMessage = null;
            try {
                parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                parsedMessage =
                        (com.webank.wedpr.scd.proto.CertificateSchema) e.getUnfinishedMessage();
                throw e.unwrapIOException();
            } finally {
                if (parsedMessage != null) {
                    mergeFrom(parsedMessage);
                }
            }
            return this;
        }

        private int bitField0_;

        private com.google.protobuf.LazyStringList attributeName_ =
                com.google.protobuf.LazyStringArrayList.EMPTY;

        private void ensureAttributeNameIsMutable() {
            if (!((bitField0_ & 0x00000001) != 0)) {
                attributeName_ = new com.google.protobuf.LazyStringArrayList(attributeName_);
                bitField0_ |= 0x00000001;
            }
        }
        /** <code>repeated string attribute_name = 1;</code> */
        public com.google.protobuf.ProtocolStringList getAttributeNameList() {
            return attributeName_.getUnmodifiableView();
        }
        /** <code>repeated string attribute_name = 1;</code> */
        public int getAttributeNameCount() {
            return attributeName_.size();
        }
        /** <code>repeated string attribute_name = 1;</code> */
        public String getAttributeName(int index) {
            return attributeName_.get(index);
        }
        /** <code>repeated string attribute_name = 1;</code> */
        public com.google.protobuf.ByteString getAttributeNameBytes(int index) {
            return attributeName_.getByteString(index);
        }
        /** <code>repeated string attribute_name = 1;</code> */
        public Builder setAttributeName(int index, String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            ensureAttributeNameIsMutable();
            attributeName_.set(index, value);
            onChanged();
            return this;
        }
        /** <code>repeated string attribute_name = 1;</code> */
        public Builder addAttributeName(String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            ensureAttributeNameIsMutable();
            attributeName_.add(value);
            onChanged();
            return this;
        }
        /** <code>repeated string attribute_name = 1;</code> */
        public Builder addAllAttributeName(Iterable<String> values) {
            ensureAttributeNameIsMutable();
            com.google.protobuf.AbstractMessageLite.Builder.addAll(values, attributeName_);
            onChanged();
            return this;
        }
        /** <code>repeated string attribute_name = 1;</code> */
        public Builder clearAttributeName() {
            attributeName_ = com.google.protobuf.LazyStringArrayList.EMPTY;
            bitField0_ = (bitField0_ & ~0x00000001);
            onChanged();
            return this;
        }
        /** <code>repeated string attribute_name = 1;</code> */
        public Builder addAttributeNameBytes(com.google.protobuf.ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            checkByteStringIsUtf8(value);
            ensureAttributeNameIsMutable();
            attributeName_.add(value);
            onChanged();
            return this;
        }

        @Override
        public final Builder setUnknownFields(
                final com.google.protobuf.UnknownFieldSet unknownFields) {
            return super.setUnknownFields(unknownFields);
        }

        @Override
        public final Builder mergeUnknownFields(
                final com.google.protobuf.UnknownFieldSet unknownFields) {
            return super.mergeUnknownFields(unknownFields);
        }

        // @@protoc_insertion_point(builder_scope:com.webank.wedpr.scd.proto.CertificateSchema)
    }

    // @@protoc_insertion_point(class_scope:com.webank.wedpr.scd.proto.CertificateSchema)
    private static final com.webank.wedpr.scd.proto.CertificateSchema DEFAULT_INSTANCE;

    static {
        DEFAULT_INSTANCE = new com.webank.wedpr.scd.proto.CertificateSchema();
    }

    public static com.webank.wedpr.scd.proto.CertificateSchema getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<CertificateSchema> PARSER =
            new com.google.protobuf.AbstractParser<CertificateSchema>() {
                @Override
                public CertificateSchema parsePartialFrom(
                        com.google.protobuf.CodedInputStream input,
                        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                        throws com.google.protobuf.InvalidProtocolBufferException {
                    return new CertificateSchema(input, extensionRegistry);
                }
            };

    public static com.google.protobuf.Parser<CertificateSchema> parser() {
        return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<CertificateSchema> getParserForType() {
        return PARSER;
    }

    @Override
    public com.webank.wedpr.scd.proto.CertificateSchema getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}