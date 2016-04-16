package org.springframework.boot.autoconfigure.gcm;

import com.google.android.gcm.server.Sender;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GcmAutoConfiguration.class)
public class GcmAutoConfigurationTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void sender(){
        Sender bean = applicationContext.getBean(Sender.class);
        System.out.println(bean);
    }
}