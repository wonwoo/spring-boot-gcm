package org.springframework.boot.push;


import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.MulticastResult;
import com.google.android.gcm.server.Sender;
import org.springframework.util.Assert;

import java.io.IOException;
import java.util.Arrays;

import static java.awt.SystemColor.info;
import static org.springframework.util.ObjectUtils.isEmpty;


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
    Assert.notNull(message, "message should not be null.");
    Assert.isTrue(!isEmpty(message.getRegIds()), "regIds should not be Null or empty string.");
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
