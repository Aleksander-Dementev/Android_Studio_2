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
import android.widget.Toast;

import java.util.List;

public class UserListFragment extends Fragment{
    private RecyclerView userRecyclerView; // компанет списка
    private UserAdapter userAdapter; //создаем переменную для адатера (что это?)

    @Override//Метод создает компанент View фрагмент из XML разментки
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){
    View view = inflater.inflate(R.layout.fragment_user_list,viewGroup,false); //раздуваем
        userRecyclerView =view.findViewById(R.id.userRecyclerView); //это просто список который вставили в fragment_user_list
        userRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity())); //Создаем менеджера по добавлению элементов
     // что такое LayoutManager для компановки упорядочивание и размещение элементов
        //кладем список пользователей для их отражения:
        UserList userList = UserList.get();
        List<User>users = userList.getUsers();
        userAdapter = new UserAdapter(users); //принимаем список пользователей
        userRecyclerView.setAdapter(userAdapter);

        return view;
    }// класс UserHolder формирует элементы списка (конструктор)
    private class UserHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView userItemTextView;
        private User itemUser; //текущий пользователь
        public UserHolder (LayoutInflater inflater, ViewGroup viewGroup){
            super(inflater.inflate(R.layout.list_ilem_user,viewGroup,false));//Передаем элемент для раздувания
            userItemTextView = itemView.findViewById(R.id.userIten); //itemView - это элемент списка (текущай мы заложили 100 в цикле)
            itemView.setOnClickListener(this); //будет ссылаться на 33 строчку
        }
//Связываем текст userItem и users
        public void bind(User user){
        itemUser = user; 
        String userName = "Имя: "+user.getUserName()+"\n"+"Фамилия: " + user.getUserLastName()+"\n"+"=========";
        userItemTextView.setText(userName);
        }

        @Override
        public void onClick(View view) {
            MainActivity.changeFragment(view, itemUser);
            /*Toast.makeText(getActivity(),"клик по элементу списка"+itemUser.getUserName(), Toast.LENGTH_SHORT).show();*/
        }
    }// UserAdapter нужен для предачи элементов в RecyclerView. А он в сою очередь  для отображения наэкране
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
