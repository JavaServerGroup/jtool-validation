package com.jtool.validator;

public class ValidationResultsExceptionItem {
    private String key;

    private String info;

    public ValidationResultsExceptionItem(String key, String info) {
        this.key = key;
        this.info = info;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
