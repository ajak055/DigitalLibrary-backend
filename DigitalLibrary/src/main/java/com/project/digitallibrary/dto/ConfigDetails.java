package com.project.digitallibrary.dto;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.LinkedHashMap;
import java.util.Map;

public class ConfigDetails {

    Map<String, Object> config = new LinkedHashMap<>();

    public ConfigDetails() {}

    public ConfigDetails(Map<String, Object> config) {
        this.config = config;
    }

    @JsonAnySetter
    public void setConfig(String key, Object value) {
        config.put(key, value);
    }

    public Map<String, Object> getConfig() {
        return config;
    }
}
