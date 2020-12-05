package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

//Сингалетный класс (может быть создан только один объект)
//Класс отвечающий за список пользователей:
public class UserList {
    private static UserList userList; //static это то свойство которое позволяет обращаться не создавая объект
    private List users; // переменная
    public static UserList get(){
        if(userList==null){
            userList = new UserList();
        }
    return userList;
    }
    //цикл ArrayList создающий пользователей в переменную лист:
    private UserList(){
        users = new ArrayList();
        for (int i = 0; i < 100; i++) {// генерируем 100 пользователей
            User user = new User();
            user.setUserName("ИМЯ_ "+ i);
            user.setUserLastName("Фамилия_ "+i);
            users.add(user);
        }
    }

    public List getUsers() {
        return users;
    }
}
