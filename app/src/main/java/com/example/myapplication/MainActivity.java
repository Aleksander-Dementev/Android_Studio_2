package com.example.myapplication;

import android.os.UserManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//фрагменты
public class MainActivity extends AppCompatActivity {

    //с 12-19 код по соединению 2-х окон Activity_main и fragment_user
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = new UserListFragment(); // это фрагмент публикуем на экранее
        fragmentManager.beginTransaction().add(R.id.fragmentCotainer, fragment).commit(); //берем fragmentManager и вывызаем в нем метод beginTransaction- Помещает элементы на экран. Через медод add показываем где отображать фрагмент, а вторым аргкментом кладем фрагмент который планируем размещат + commit что бы зафексировать  --> 1434_02_12_2020 49:42
    }
}