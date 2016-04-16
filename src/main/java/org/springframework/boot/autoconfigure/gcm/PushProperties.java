package org.springframework.boot.autoconfigure.gcm;

abstract class PushProperties {

    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
