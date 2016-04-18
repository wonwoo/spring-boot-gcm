package org.springframework.boot.push;


import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.MulticastResult;
import com.google.android.gcm.server.Sender;

import java.io.IOException;

import static org.springframework.util.Assert.isTrue;
import static org.springframework.util.Assert.notNull;
import static org.springframework.util.ObjectUtils.isEmpty;

/**
 * Created by wonwoo on 2016. 4. 16..
 */
public class GcmPushSender implements PushSender {

  private static final int RE_TRIES = 3;
  private static final int NO_RETRY = 0;

  private Sender sender;

  public GcmPushSender(Sender sender){
    this.sender = sender;
  }

  public MulticastResult send(Message message) {
    return send(message, RE_TRIES);
  }

  public MulticastResult send(Message message, int retries) {
    notNull(message, "message should not be null.");
    isTrue(!isEmpty(message.getRegIds()), "regIds should not be Null or empty string.");
    isTrue(message.getRegIds().size() <= 1000, "limit exception");

    try {
      return sender.send(message, message.getRegIds(), retries);
    } catch (IOException e) {
      //all JSON posts failed due to GCM unavailability
      throw new GcmException(e.getMessage(), e);
    }
  }

  public MulticastResult sendNoRetry(Message message) {
    return send(message, NO_RETRY);
  }
}
