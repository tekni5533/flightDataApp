package com.ordina.aditya.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "sky")
public class SkyDataProperties {
    private String baseUrl;
    private String apiUri;
    private String regionQueryString;

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getApiUri() {
        return apiUri;
    }

    public void setApiUri(String apiUri) {
        this.apiUri = apiUri;
    }

    public String getRegionQueryString() {
        return regionQueryString;
    }

    public void setRegionQueryString(String regionQueryString) {
        this.regionQueryString = regionQueryString;
    }
}
