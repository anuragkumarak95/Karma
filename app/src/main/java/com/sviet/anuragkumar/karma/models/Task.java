package com.sviet.anuragkumar.karma.models;

import java.util.ArrayList;

/**
 * Created by Anurag Kumar on 15-Oct-16.
 */

public class Task {
    //Not null, Unique ID.
    private final String ID;

    //Task Set Title, User Specified.
    private String title;

    //Collection as Tasks in this Task Set.
    private ArrayList<UnitTask> mini_tasks;

    //Personalization color for this Task Set.
    private String color;

    public Task(String ID,String title, ArrayList<UnitTask> mini_tasks,String color) {
        this.ID = ID;
        this.title = title;
        this.mini_tasks = mini_tasks;
        this.color = color;
    }

    public String getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<UnitTask> getMini_tasks() {
        return mini_tasks;
    }

    public void setMini_tasks(ArrayList<UnitTask> mini_tasks) {
        this.mini_tasks = mini_tasks;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
