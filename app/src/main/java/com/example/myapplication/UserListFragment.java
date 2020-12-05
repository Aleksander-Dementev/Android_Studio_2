package com.example.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class UserListFragment extends Fragment{
    private RecyclerView userRecyclerView;
    private UserAdapter userAdapter; //создаем переменную для адатера

    @Override//Метод создает компанент View фрагмент из XML разментки
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){
    View view = inflater.inflate(R.layout.fragment_user_list,viewGroup,false); //раздуваем
        userRecyclerView =view.findViewById(R.id.userRecyclerView);
        userRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity())); //Создаем менеджера по добавлению элементов
     //кладем список пользователей для их отражения:
        UserList userList = UserList.get();
        List<User>users = userList.getUsers();
        userAdapter = new UserAdapter(users); //принимаем список пользователей
        userRecyclerView.setAdapter(userAdapter);

        return view;
    }
    private class UserHolder extends RecyclerView.ViewHolder{
        private TextView userItem;
        public UserHolder (LayoutInflater inflater, ViewGroup viewGroup){
            super(inflater.inflate(R.layout.list_ilem_user,viewGroup,false));//Передаем элемент для раздувания
            userItem = itemView.findViewById(R.id.userIten); //itemView - текущая мы их заложили 100 в цикле
        }
//Связываем текст userItem и users
        public void bind(User user){
        String userName = "Имя: "+user.getUserName()+"\n"+"Фамилия: " + user.getUserLastName()+"\n"+"=========";
        userItem.setText(userName);
        }

    }
    private class UserAdapter extends RecyclerView.Adapter<UserHolder>{
        private List<User> users;//список пользователей

        public UserAdapter(List<User> users) {
            this.users = users;
        }

        @NonNull
        @Override //вызывается при необходимости отражения элемента
        public UserHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            return new UserHolder(inflater, viewGroup);
        }

        @Override //привязывание контента
        public void onBindViewHolder(@NonNull UserHolder userHolder, int position) {
        User user = users.get(position);
        userHolder.bind(user);
        }

        @Override //возращает количество элементов в списке
        public int getItemCount() {
            return users.size();//привязываем к элементам

        }
    }
}
