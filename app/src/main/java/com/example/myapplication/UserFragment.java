package com.example.myapplication;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


//соединению 2-х окон Activity_main и fragment_use
public class  UserFragment extends Fragment {
    private User user;
    private TextView userName_userLastname_View;
    @Override
    public void onCreate (Bundle sevedInstanceState){
    super.onCreate(sevedInstanceState);
    user = new User();
    user.setUserName("Иван");
    user.setUserLastName("Иванов");
    }
    @Override// момент форирования
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle sevedInstanceState){
    View view = inflater.inflate(R.layout.fragment_user,container,false); //при роздувании необходимо указывать что наполняем MainActivity
    userName_userLastname_View = view.findViewById(R.id.userName_userLastname_View);
    String userName = "Имя: "+user.getUserName()+"\n"+"Фамилия: " + user.getUserLastName(); //????дубль
    userName_userLastname_View.setText(userName);

        return view;
}

}
