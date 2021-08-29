package com.task.simpleshop.dto;

import java.io.Serializable;

public abstract class BaseDto implements Serializable {
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
