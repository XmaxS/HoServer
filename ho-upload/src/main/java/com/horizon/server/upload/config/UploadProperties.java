package com.horizon.server.upload.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "ho.upload")
@Component
public class UploadProperties {

    private String baseUrl;
    private List<String> allowTypes;

}
