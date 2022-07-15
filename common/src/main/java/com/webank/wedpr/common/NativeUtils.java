// Copyright 2020 WeDPR Lab Project Authors. Licensed under Apache-2.0.

package com.webank.wedpr.common;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/** Shared utility functions for native interfaces (JNI). */
public class NativeUtils {
    private static final int MIN_FILENAME_LENGTH = 3;
    private static final String DIR_PREFIX = "wedpr_native_utils";
    private static File temporaryDir;

    /**
     * Loads dynamic library of native interfaces from a Jar file. The library file will be copied
     * into a temporary directory and then loaded into memory, and will be deleted after Java
     * runtime exits.
     */
    public static synchronized void loadLibraryFromJar(String pathInJar) throws IOException {
        // Obtain libFilename from pathInJar.
        String libFilename = checkAndExtractLibFilename(pathInJar);

        // Get a writable temporary path for the library file.
        File tempLibFile = getTempFilePath(libFilename);

        // Copy the library file from jar package to a temporary directory.
        try (InputStream inputStream = NativeUtils.class.getResourceAsStream(pathInJar)) {
            if (inputStream == null) {
                tempLibFile.delete();
                throw new FileNotFoundException(
                        String.format(
                                "The WeDPR dynamic library file was not found in '%s'.",
                                pathInJar));
            }
            Files.copy(inputStream, tempLibFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            // Other IO errors occurred.
            tempLibFile.delete();
            throw e;
        }

        // Load the library file.
        try {
            System.load(tempLibFile.getAbsolutePath());
        } finally {
            // The library file will be deleted after Java runtime exits.
            tempLibFile.deleteOnExit();
        }
    }

    private static String checkAndExtractLibFilename(String pathInJar) {
        if (pathInJar == null || !pathInJar.startsWith("/")) {
            throw new IllegalArgumentException(
                    String.format(
                            "A absolute JAR resource path is required (i.e. starting with '/'), but given '%s'.",
                            pathInJar));
        }

        Path path = Paths.get(pathInJar);
        String filename = path.getFileName().toString();
        if (filename == null || filename.length() < MIN_FILENAME_LENGTH) {
            throw new IllegalArgumentException(
                    String.format(
                            "The filename '%s' seems too short. Please check again", filename));
        }
        return filename;
    }

    private static File getTempFilePath(String filename) throws IOException {
        if (temporaryDir == null) {
            temporaryDir = Files.createTempDirectory(DIR_PREFIX).toFile();
            temporaryDir.deleteOnExit();
        }
        return new File(temporaryDir, filename);
    }
}
