package com.example.latte.dbindingviewmodeltest.ui;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.latte.dbindingviewmodeltest.R;
import com.example.latte.dbindingviewmodeltest.database.AppDatabase;
import com.example.latte.dbindingviewmodeltest.database.entity.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<User> users = AppDatabase.getInstance(getApplicationContext()).userDao().getAll();
        Log.d(TAG, "user size = " + users.size());

        for (User user : users)
            Log.d(TAG, "user Name = " + user.getFirstName() + user.getLastName());
    }
}
