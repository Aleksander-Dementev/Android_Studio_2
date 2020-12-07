package com.example.myapplication;

import android.content.Context;
import android.os.UserManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.Serializable;

//фрагменты
public class MainActivity extends AppCompatActivity {
    //с 12-19 код по соединению 2-х окон Activity_main и fragment_user
    @Override
    protected void onCreate(Bundle savedInstanceState) { //метод onCreate создающий активность
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // метод onCreate отображает из файл activity_main (является дизайном нашего приложения)

        FragmentManager fragmentManager = getSupportFragmentManager(); //создаем FragmentManager он нужен для управления фрагментами с помощью функции  getSupportFragmentManager
        Fragment fragment = new UserListFragment(); // Задаем сам фрагмент (UserListFragment-класс фрагмента)
        fragmentManager.beginTransaction().add(R.id.fagmentCotainer, fragment).commit(); //берем fragmentManager и вывызаем в нем метод beginTransaction- Помещает элементы на экран. Через медод add показываем где отображать фрагмент, а вторым аргкментом кладем фрагмент который планируем размещат + commit что бы зафексировать  --> 1434_02_12_2020 49:42
    }   //R.id.fragmentCotainer это фрагмент из файла  activity_main.xml
    //UserListFragment размещается на fagmentCotainer


    /*
    @Override
    public void onBackPressed(){
        super.onBackPressed();
        Toast.makeText(MainActivity/this, "Сейчас будет выход", Toast.LENGTH_SHORT).show();
    }*/



    public static void changeFragment(View view, User user){
        // Получаем хостинговую активность (в нашем  случае MianActivity )
        FragmentActivity activity = (FragmentActivity) view.getContext();
        // Создаем Менеджер фрагмент
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        //  создаем фрагмент
        Fragment fragment = new UserFragment();
        //Создаем bundle (это как колекция)
        Bundle bundle = new Bundle();
        // Записываем user  в bundle для передачи во фрагмент
        bundle.putSerializable("user", user);
        // Кладем bundle во фрагмент
        fragment.setArguments(bundle);
        // заменяем фрагмент
        fragmentManager.beginTransaction().replace(R.id.fagmentCotainer,fragment).commit();
    }
}