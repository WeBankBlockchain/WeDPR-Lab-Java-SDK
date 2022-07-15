// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: scd.proto

package com.webank.wedpr.scd.proto;

/**
 *
 *
 * <pre>
 * Certificate signature signed by an issuer.
 * </pre>
 *
 * Protobuf type {@code com.webank.wedpr.scd.proto.CertificateSignature}
 */
public final class CertificateSignature extends com.google.protobuf.GeneratedMessageV3
        implements
        // @@protoc_insertion_point(message_implements:com.webank.wedpr.scd.proto.CertificateSignature)
        CertificateSignatureOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use CertificateSignature.newBuilder() to construct.
    private CertificateSignature(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }

    private CertificateSignature() {
        certificateSignature_ = "";
        signatureCorrectnessProof_ = "";
    }

    @Override
    @SuppressWarnings({"unused"})
    protected Object newInstance(UnusedPrivateParameter unused) {
        return new CertificateSignature();
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private CertificateSignature(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        this();
        if (extensionRegistry == null) {
            throw new NullPointerException();
        }
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

                            certificateSignature_ = s;
                            break;
                        }
                    case 18:
                        {
                            String s = input.readStringRequireUtf8();

                            signatureCorrectnessProof_ = s;
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
            this.unknownFields = unknownFields.build();
            makeExtensionsImmutable();
        }
    }

    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return com.webank.wedpr.scd.proto.Scd
                .internal_static_com_webank_wedpr_scd_proto_CertificateSignature_descriptor;
    }

    @Override
    protected FieldAccessorTable internalGetFieldAccessorTable() {
        return com.webank.wedpr.scd.proto.Scd
                .internal_static_com_webank_wedpr_scd_proto_CertificateSignature_fieldAccessorTable
                .ensureFieldAccessorsInitialized(
                        com.webank.wedpr.scd.proto.CertificateSignature.class,
                        com.webank.wedpr.scd.proto.CertificateSignature.Builder.class);
    }

    public static final int CERTIFICATE_SIGNATURE_FIELD_NUMBER = 1;
    private volatile Object certificateSignature_;
    /** <code>string certificate_signature = 1;</code> */
    public String getCertificateSignature() {
        Object ref = certificateSignature_;
        if (ref instanceof String) {
            return (String) ref;
        } else {
            com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
            String s = bs.toStringUtf8();
            certificateSignature_ = s;
            return s;
        }
    }
    /** <code>string certificate_signature = 1;</code> */
    public com.google.protobuf.ByteString getCertificateSignatureBytes() {
        Object ref = certificateSignature_;
        if (ref instanceof String) {
            com.google.protobuf.ByteString b =
                    com.google.protobuf.ByteString.copyFromUtf8((String) ref);
            certificateSignature_ = b;
            return b;
        } else {
            return (com.google.protobuf.ByteString) ref;
        }
    }

    public static final int SIGNATURE_CORRECTNESS_PROOF_FIELD_NUMBER = 2;
    private volatile Object signatureCorrectnessProof_;
    /** <code>string signature_correctness_proof = 2;</code> */
    public String getSignatureCorrectnessProof() {
        Object ref = signatureCorrectnessProof_;
        if (ref instanceof String) {
            return (String) ref;
        } else {
            com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
            String s = bs.toStringUtf8();
            signatureCorrectnessProof_ = s;
            return s;
        }
    }
    /** <code>string signature_correctness_proof = 2;</code> */
    public com.google.protobuf.ByteString getSignatureCorrectnessProofBytes() {
        Object ref = signatureCorrectnessProof_;
        if (ref instanceof String) {
            com.google.protobuf.ByteString b =
                    com.google.protobuf.ByteString.copyFromUtf8((String) ref);
            signatureCorrectnessProof_ = b;
            return b;
        } else {
            return (com.google.protobuf.ByteString) ref;
        }
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
        if (!getCertificateSignatureBytes().isEmpty()) {
            com.google.protobuf.GeneratedMessageV3.writeString(output, 1, certificateSignature_);
        }
        if (!getSignatureCorrectnessProofBytes().isEmpty()) {
            com.google.protobuf.GeneratedMessageV3.writeString(
                    output, 2, signatureCorrectnessProof_);
        }
        unknownFields.writeTo(output);
    }

    @Override
    public int getSerializedSize() {
        int size = memoizedSize;
        if (size != -1) return size;

        size = 0;
        if (!getCertificateSignatureBytes().isEmpty()) {
            size +=
                    com.google.protobuf.GeneratedMessageV3.computeStringSize(
                            1, certificateSignature_);
        }
        if (!getSignatureCorrectnessProofBytes().isEmpty()) {
            size +=
                    com.google.protobuf.GeneratedMessageV3.computeStringSize(
                            2, signatureCorrectnessProof_);
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
        if (!(obj instanceof com.webank.wedpr.scd.proto.CertificateSignature)) {
            return super.equals(obj);
        }
        com.webank.wedpr.scd.proto.CertificateSignature other =
                (com.webank.wedpr.scd.proto.CertificateSignature) obj;

        if (!getCertificateSignature().equals(other.getCertificateSignature())) return false;
        if (!getSignatureCorrectnessProof().equals(other.getSignatureCorrectnessProof()))
            return false;
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
        hash = (37 * hash) + CERTIFICATE_SIGNATURE_FIELD_NUMBER;
        hash = (53 * hash) + getCertificateSignature().hashCode();
        hash = (37 * hash) + SIGNATURE_CORRECTNESS_PROOF_FIELD_NUMBER;
        hash = (53 * hash) + getSignatureCorrectnessProof().hashCode();
        hash = (29 * hash) + unknownFields.hashCode();
        memoizedHashCode = hash;
        return hash;
    }

    public static com.webank.wedpr.scd.proto.CertificateSignature parseFrom(
            java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static com.webank.wedpr.scd.proto.CertificateSignature parseFrom(
            java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.webank.wedpr.scd.proto.CertificateSignature parseFrom(
            com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static com.webank.wedpr.scd.proto.CertificateSignature parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.webank.wedpr.scd.proto.CertificateSignature parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static com.webank.wedpr.scd.proto.CertificateSignature parseFrom(
            byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.webank.wedpr.scd.proto.CertificateSignature parseFrom(
            java.io.InputStream input) throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.webank.wedpr.scd.proto.CertificateSignature parseFrom(
            java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
                PARSER, input, extensionRegistry);
    }

    public static com.webank.wedpr.scd.proto.CertificateSignature parseDelimitedFrom(
            java.io.InputStream input) throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static com.webank.wedpr.scd.proto.CertificateSignature parseDelimitedFrom(
            java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
                PARSER, input, extensionRegistry);
    }

    public static com.webank.wedpr.scd.proto.CertificateSignature parseFrom(
            com.google.protobuf.CodedInputStream input) throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static com.webank.wedpr.scd.proto.CertificateSignature parseFrom(
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

    public static Builder newBuilder(com.webank.wedpr.scd.proto.CertificateSignature prototype) {
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
     * Certificate signature signed by an issuer.
     * </pre>
     *
     * Protobuf type {@code com.webank.wedpr.scd.proto.CertificateSignature}
     */
    public static final class Builder
            extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
            implements
            // @@protoc_insertion_point(builder_implements:com.webank.wedpr.scd.proto.CertificateSignature)
            com.webank.wedpr.scd.proto.CertificateSignatureOrBuilder {
        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
            return com.webank.wedpr.scd.proto.Scd
                    .internal_static_com_webank_wedpr_scd_proto_CertificateSignature_descriptor;
        }

        @Override
        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return com.webank.wedpr.scd.proto.Scd
                    .internal_static_com_webank_wedpr_scd_proto_CertificateSignature_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.webank.wedpr.scd.proto.CertificateSignature.class,
                            com.webank.wedpr.scd.proto.CertificateSignature.Builder.class);
        }

        // Construct using com.webank.wedpr.scd.proto.CertificateSignature.newBuilder()
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
            certificateSignature_ = "";

            signatureCorrectnessProof_ = "";

            return this;
        }

        @Override
        public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
            return com.webank.wedpr.scd.proto.Scd
                    .internal_static_com_webank_wedpr_scd_proto_CertificateSignature_descriptor;
        }

        @Override
        public com.webank.wedpr.scd.proto.CertificateSignature getDefaultInstanceForType() {
            return com.webank.wedpr.scd.proto.CertificateSignature.getDefaultInstance();
        }

        @Override
        public com.webank.wedpr.scd.proto.CertificateSignature build() {
            com.webank.wedpr.scd.proto.CertificateSignature result = buildPartial();
            if (!result.isInitialized()) {
                throw newUninitializedMessageException(result);
            }
            return result;
        }

        @Override
        public com.webank.wedpr.scd.proto.CertificateSignature buildPartial() {
            com.webank.wedpr.scd.proto.CertificateSignature result =
                    new com.webank.wedpr.scd.proto.CertificateSignature(this);
            result.certificateSignature_ = certificateSignature_;
            result.signatureCorrectnessProof_ = signatureCorrectnessProof_;
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
            if (other instanceof com.webank.wedpr.scd.proto.CertificateSignature) {
                return mergeFrom((com.webank.wedpr.scd.proto.CertificateSignature) other);
            } else {
                super.mergeFrom(other);
                return this;
            }
        }

        public Builder mergeFrom(com.webank.wedpr.scd.proto.CertificateSignature other) {
            if (other == com.webank.wedpr.scd.proto.CertificateSignature.getDefaultInstance())
                return this;
            if (!other.getCertificateSignature().isEmpty()) {
                certificateSignature_ = other.certificateSignature_;
                onChanged();
            }
            if (!other.getSignatureCorrectnessProof().isEmpty()) {
                signatureCorrectnessProof_ = other.signatureCorrectnessProof_;
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
            com.webank.wedpr.scd.proto.CertificateSignature parsedMessage = null;
            try {
                parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                parsedMessage =
                        (com.webank.wedpr.scd.proto.CertificateSignature) e.getUnfinishedMessage();
                throw e.unwrapIOException();
            } finally {
                if (parsedMessage != null) {
                    mergeFrom(parsedMessage);
                }
            }
            return this;
        }

        private Object certificateSignature_ = "";
        /** <code>string certificate_signature = 1;</code> */
        public String getCertificateSignature() {
            Object ref = certificateSignature_;
            if (!(ref instanceof String)) {
                com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
                String s = bs.toStringUtf8();
                certificateSignature_ = s;
                return s;
            } else {
                return (String) ref;
            }
        }
        /** <code>string certificate_signature = 1;</code> */
        public com.google.protobuf.ByteString getCertificateSignatureBytes() {
            Object ref = certificateSignature_;
            if (ref instanceof String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8((String) ref);
                certificateSignature_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }
        /** <code>string certificate_signature = 1;</code> */
        public Builder setCertificateSignature(String value) {
            if (value == null) {
                throw new NullPointerException();
            }

            certificateSignature_ = value;
            onChanged();
            return this;
        }
        /** <code>string certificate_signature = 1;</code> */
        public Builder clearCertificateSignature() {

            certificateSignature_ = getDefaultInstance().getCertificateSignature();
            onChanged();
            return this;
        }
        /** <code>string certificate_signature = 1;</code> */
        public Builder setCertificateSignatureBytes(com.google.protobuf.ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            checkByteStringIsUtf8(value);

            certificateSignature_ = value;
            onChanged();
            return this;
        }

        private Object signatureCorrectnessProof_ = "";
        /** <code>string signature_correctness_proof = 2;</code> */
        public String getSignatureCorrectnessProof() {
            Object ref = signatureCorrectnessProof_;
            if (!(ref instanceof String)) {
                com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
                String s = bs.toStringUtf8();
                signatureCorrectnessProof_ = s;
                return s;
            } else {
                return (String) ref;
            }
        }
        /** <code>string signature_correctness_proof = 2;</code> */
        public com.google.protobuf.ByteString getSignatureCorrectnessProofBytes() {
            Object ref = signatureCorrectnessProof_;
            if (ref instanceof String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8((String) ref);
                signatureCorrectnessProof_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }
        /** <code>string signature_correctness_proof = 2;</code> */
        public Builder setSignatureCorrectnessProof(String value) {
            if (value == null) {
                throw new NullPointerException();
            }

            signatureCorrectnessProof_ = value;
            onChanged();
            return this;
        }
        /** <code>string signature_correctness_proof = 2;</code> */
        public Builder clearSignatureCorrectnessProof() {

            signatureCorrectnessProof_ = getDefaultInstance().getSignatureCorrectnessProof();
            onChanged();
            return this;
        }
        /** <code>string signature_correctness_proof = 2;</code> */
        public Builder setSignatureCorrectnessProofBytes(com.google.protobuf.ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            checkByteStringIsUtf8(value);

            signatureCorrectnessProof_ = value;
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

        // @@protoc_insertion_point(builder_scope:com.webank.wedpr.scd.proto.CertificateSignature)
    }

    // @@protoc_insertion_point(class_scope:com.webank.wedpr.scd.proto.CertificateSignature)
    private static final com.webank.wedpr.scd.proto.CertificateSignature DEFAULT_INSTANCE;

    static {
        DEFAULT_INSTANCE = new com.webank.wedpr.scd.proto.CertificateSignature();
    }

    public static com.webank.wedpr.scd.proto.CertificateSignature getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<CertificateSignature> PARSER =
            new com.google.protobuf.AbstractParser<CertificateSignature>() {
                @Override
                public CertificateSignature parsePartialFrom(
                        com.google.protobuf.CodedInputStream input,
                        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                        throws com.google.protobuf.InvalidProtocolBufferException {
                    return new CertificateSignature(input, extensionRegistry);
                }
            };

    public static com.google.protobuf.Parser<CertificateSignature> parser() {
        return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<CertificateSignature> getParserForType() {
        return PARSER;
    }

    @Override
    public com.webank.wedpr.scd.proto.CertificateSignature getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
