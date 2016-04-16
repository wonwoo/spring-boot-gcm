package org.springframework.boot.push;

import com.google.android.gcm.server.InvalidRequestException;
import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.MulticastResult;
import com.google.android.gcm.server.Notification;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.gcm.GcmAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = GcmAutoConfiguration.class)
public class GcmPushResultSenderTest {

    @Autowired
    private PushSender gcmPushSender;

    private List<String> regIdList = new ArrayList<String>();

    @Before
    public void setup(){
        regIdList.add("regid");
    }

    @Test
    public void sendMessage(){
        Message message = new Message.Builder()
          .addData("message", "old value")
          .regIds(regIdList)
          .build();

        MulticastResult send = gcmPushSender.send(message);
        System.out.println(send);
    }

    @Test
    public void sendNoRetry(){
        Message message = new Message.Builder()
          .addData("message", "old value")
          .regIds(regIdList)
          .build();
        MulticastResult send = gcmPushSender.sendNoRetry(message);
        System.out.println(send);
    }

    @Test
    public void sendError(){
        Message message = new Message.Builder()
          .addData("message", "old value")
          .build();
        MulticastResult send = gcmPushSender.sendNoRetry(message);
        System.out.println(send);
    }
}