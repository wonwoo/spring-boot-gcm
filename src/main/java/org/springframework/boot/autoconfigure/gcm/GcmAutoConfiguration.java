package org.springframework.boot.autoconfigure.gcm;

import com.google.android.gcm.server.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.push.GcmPushSender;
import org.springframework.boot.push.PushSender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by wonwoo on 2016. 4. 16..
 */
@Configuration
@ConditionalOnClass(Sender.class)
@ConditionalOnProperty(prefix = "spring.push.gcm", name = "key")
@EnableConfigurationProperties(GcmProperties.class)
public class GcmAutoConfiguration {

    @Autowired
    private GcmProperties properties;

    @Bean
    public Sender sender() {
        return new Sender(properties.getKey());
    }

    @Bean
    public PushSender gcmPushSender(){
        return new GcmPushSender(sender());
    }
}
