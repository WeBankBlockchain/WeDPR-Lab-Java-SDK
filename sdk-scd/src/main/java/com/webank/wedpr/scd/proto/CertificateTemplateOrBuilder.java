// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: scd.proto

package com.webank.wedpr.scd.proto;

public interface CertificateTemplateOrBuilder
        extends
        // @@protoc_insertion_point(interface_extends:com.webank.wedpr.scd.proto.CertificateTemplate)
        com.google.protobuf.MessageOrBuilder {

    /** <code>.com.webank.wedpr.scd.proto.CertificateSchema certificate_schema = 1;</code> */
    boolean hasCertificateSchema();
    /** <code>.com.webank.wedpr.scd.proto.CertificateSchema certificate_schema = 1;</code> */
    com.webank.wedpr.scd.proto.CertificateSchema getCertificateSchema();
    /** <code>.com.webank.wedpr.scd.proto.CertificateSchema certificate_schema = 1;</code> */
    com.webank.wedpr.scd.proto.CertificateSchemaOrBuilder getCertificateSchemaOrBuilder();

    /** <code>string template_correctness_proof = 2;</code> */
    String getTemplateCorrectnessProof();
    /** <code>string template_correctness_proof = 2;</code> */
    com.google.protobuf.ByteString getTemplateCorrectnessProofBytes();

    /** <code>.com.webank.wedpr.scd.proto.TemplatePublicKey template_public_key = 3;</code> */
    boolean hasTemplatePublicKey();
    /** <code>.com.webank.wedpr.scd.proto.TemplatePublicKey template_public_key = 3;</code> */
    com.webank.wedpr.scd.proto.TemplatePublicKey getTemplatePublicKey();
    /** <code>.com.webank.wedpr.scd.proto.TemplatePublicKey template_public_key = 3;</code> */
    com.webank.wedpr.scd.proto.TemplatePublicKeyOrBuilder getTemplatePublicKeyOrBuilder();
}
