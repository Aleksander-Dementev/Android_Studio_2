package com.example.myapplication;

import java.io.Serializable;
import java.util.UUID;

public class User implements Serializable {
    private String userName; // переменная имя
    private String userLastName; // переменная фамилия
    private UUID uuid; // идентификатор пользоватея
// класс отвечащий за пользователей:
    public User() {
        this.uuid = UUID.randomUUID();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public UUID getUuid() {
        return uuid;
    }

}
