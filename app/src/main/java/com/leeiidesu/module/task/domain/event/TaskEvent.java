package com.leeiidesu.module.task.domain.event;

/**
 * Created by iilee on 2018/5/8.
 */

public class TaskEvent {
    private int type;
    private int position;

    public TaskEvent(int type, int position) {
        this.type = type;
        this.position = position;
    }

    public int getType() {
        return type;
    }

    public int getPosition() {
        return position;
    }
}
