package org.springframework.boot.push;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.MulticastResult;

/**
 * Created by wonwoo on 2016. 4. 16..
 */
public interface PushSender {

  MulticastResult send(Message message);

  MulticastResult send(Message message, int retries);

  MulticastResult sendNoRetry(Message message);
}
