// Copyright 2020 WeDPR Lab Project Authors. Licensed under Apache-2.0.

package com.webank.wedpr.scd;

import com.webank.wedpr.common.WedprException;
import com.webank.wedpr.scd.proto.CertificateSchema;
import java.util.List;

/**
 * Client class used by a SCD certificate issuer. This is the main interface class for Java apps
 * using SCD functions.
 */
public class IssuerClient extends ScdClient {
    /**
     * Makes a certificate template for users to fill data.
     *
     * @param schema the schema defining the certificate attribute name list.
     * @return IssuerResult containing data for certificateTemplate, templatePrivateKey.
     * @throws WedprException if any error occurred.
     */
    public IssuerResult makeCertificateTemplate(List<String> schema) throws WedprException {
        return NativeInterface.issuerMakeCertificateTemplate(
                        protoToEncodedString(
                                CertificateSchema.newBuilder().addAllAttributeName(schema).build()))
                .expectNoError();
    }

    /**
     * Signs a verified certificate from a user.
     *
     * @param certificateTemplate the encoded certificate template.
     * @param templatePrivateKey the encoded template private key.
     * @param signRequest the encoded certificate signing request from the user.
     * @param userId the encoded user id.
     * @param userNonce the encoded nonce from the user.
     * @return IssuerResult containing data for certificateSignature, issuerNonce.
     * @throws WedprException if any error occurred.
     */
    public IssuerResult signCertificate(
            String certificateTemplate,
            String templatePrivateKey,
            String signRequest,
            String userId,
            String userNonce)
            throws WedprException {
        return NativeInterface.issuerSignCertificate(
                        certificateTemplate, templatePrivateKey, signRequest, userId, userNonce)
                .expectNoError();
    }
}
