package org.springframework.boot.push;

/**
 * Created by wonwoo on 2016. 4. 16..
 */
public class GcmException extends RuntimeException {
  private final String message;
  private final Throwable e;

  public GcmException(String message, Throwable e) {
    this.message = message;
    this.e = e;
  }

  @Override
  public String getMessage() {
    return message;
  }

  @Override
  public synchronized Throwable getCause() {
    return this.e;
  }
}
