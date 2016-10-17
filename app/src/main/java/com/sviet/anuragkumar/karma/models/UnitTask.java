package com.sviet.anuragkumar.karma.models;

/**
 * Created by Anurag Kumar on 16-Oct-16.
 */

public class UnitTask {

    //Task Content(String).
    private String content;

    //Task Completion State (true/false)
    private boolean state;

    public UnitTask(String content, boolean state) {
        this.content = content;
        this.state = state;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
