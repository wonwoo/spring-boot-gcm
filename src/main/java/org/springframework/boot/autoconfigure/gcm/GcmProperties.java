package org.springframework.boot.autoconfigure.gcm;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("spring.push.gcm")
public class GcmProperties extends PushProperties {
}
