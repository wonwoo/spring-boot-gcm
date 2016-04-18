package org.springframework.boot.autoconfigure.gcm;

/**
 * Created by wonwoo on 2016. 4. 16..
 */
abstract class PushProperties {

    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
