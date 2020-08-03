package com.example.trainingandroidapplication;

import java.io.Serializable;

class MyObject implements Serializable {
    private String text;
    public MyObject(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}