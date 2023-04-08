package com.example.recyclerviewsetonclicklistener;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<User> usersList;
    private RecyclerView recyclerView;
    private ClassAdapter.RecyclerViewClickListener listener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        usersList = new ArrayList<>();

        setUserInfo();
        setAdapter();
    }

    private void setAdapter() {
        setOnClickListener();
        ClassAdapter adapter = new ClassAdapter(usersList, listener);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setOnClickListener() {
        listener = new ClassAdapter.RecyclerViewClickListener() {
            @Override
            public void onCLick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                intent.putExtra("username", usersList.get(position).getUsername());
                intent.putExtra("email", usersList.get(position).getEmail());
                intent.putExtra("image", usersList.get(position).getImage());
                startActivity(intent);
            }
        };
    }

    private void setUserInfo() {
        usersList.add(new User("Ferdi","ferdi@gmail.com", R.drawable.ferdi_model));
        usersList.add(new User("Aldi", "aldi@gmail.com", R.drawable.aldi));
        usersList.add(new User("Aldo", "aldo@gmail.com", R.drawable.aldo));
        usersList.add(new User("Aufa", "aufa@gmail.com", R.drawable.aufa));
        usersList.add(new User("Danu", "danu@gmail.com", R.drawable.danu));
        usersList.add(new User("Dina", "dina@gmail.com", R.drawable.dina));
        usersList.add(new User("Dzaky", "dzaky@gmail.com", R.drawable.dzaky));
        usersList.add(new User("Farhan", "farhan@gmail.com", R.drawable.farhan));
        usersList.add(new User("Fayat", "fayat@gmail.com", R.drawable.fayat));
        usersList.add(new User("Irfan", "irfan@gmail.com", R.drawable.ipan));
        usersList.add(new User("Mahen", "mahen@gmail.com", R.drawable.mahen));
        usersList.add(new User("Osama", "osama@gmail.com", R.drawable.osama));
        usersList.add(new User("Perdi", "perdi@gmail.com", R.drawable.perdi));
        usersList.add(new User("Ragil", "ragil@gmail.com", R.drawable.ragil));
        usersList.add(new User("Shania", "shania@gmail.com", R.drawable.shania));
        usersList.add(new User("Taqwim", "taqwim@gmail.com", R.drawable.taqwim));
        usersList.add(new User("Taufik", "taufik@gmail.com", R.drawable.topik));
        usersList.add(new User("Ummy", "ummy@gmail.com", R.drawable.ummy));
        usersList.add(new User("Yuli", "hehe@gmail.com", R.drawable.yuli));
        usersList.add(new User("Wan", "wan@gmail.com", R.drawable.jamau));
    }
}