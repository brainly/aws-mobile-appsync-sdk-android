/*
 * Copyright 2020 Amazon.com,
 * Inc. or its affiliates. All Rights Reserved.
 * <p>
 * SPDX-License-Identifier: Apache-2.0
 */
package com.amazonaws.mobileconnectors.appsync;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.test.InstrumentationRegistry;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

final class DataFile {
    private DataFile() {}

    @NonNull
    public static String create(String fileName, String data) {
        Context context = InstrumentationRegistry.getContext();
        File file = new File(context.getCacheDir() + fileName);
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            fileOutputStream.write(data.getBytes());
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
        return file.getAbsolutePath();
    }
}
