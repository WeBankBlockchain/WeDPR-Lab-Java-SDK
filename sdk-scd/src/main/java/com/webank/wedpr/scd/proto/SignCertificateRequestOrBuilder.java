// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: scd.proto

package com.webank.wedpr.scd.proto;

public interface SignCertificateRequestOrBuilder
        extends
        // @@protoc_insertion_point(interface_extends:com.webank.wedpr.scd.proto.SignCertificateRequest)
        com.google.protobuf.MessageOrBuilder {

    /** <code>.com.webank.wedpr.scd.proto.AttributeDict certificate_attribute_dict = 1;</code> */
    boolean hasCertificateAttributeDict();
    /** <code>.com.webank.wedpr.scd.proto.AttributeDict certificate_attribute_dict = 1;</code> */
    com.webank.wedpr.scd.proto.AttributeDict getCertificateAttributeDict();
    /** <code>.com.webank.wedpr.scd.proto.AttributeDict certificate_attribute_dict = 1;</code> */
    com.webank.wedpr.scd.proto.AttributeDictOrBuilder getCertificateAttributeDictOrBuilder();

    /** <code>string blinded_certificate_secrets = 2;</code> */
    String getBlindedCertificateSecrets();
    /** <code>string blinded_certificate_secrets = 2;</code> */
    com.google.protobuf.ByteString getBlindedCertificateSecretsBytes();

    /** <code>string blinded_certificate_secrets_correctness_proof = 3;</code> */
    String getBlindedCertificateSecretsCorrectnessProof();
    /** <code>string blinded_certificate_secrets_correctness_proof = 3;</code> */
    com.google.protobuf.ByteString getBlindedCertificateSecretsCorrectnessProofBytes();
}
