package com.openmind.common;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Encoder {
    private String encode(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
        } catch (Exception e) {
            throw new RuntimeException("Encoding error", e);
        }
    }

    private String encode(Number value){
        return encode(value.toString());
    }
}
