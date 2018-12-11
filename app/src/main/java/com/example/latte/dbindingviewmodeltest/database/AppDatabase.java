package com.example.latte.dbindingviewmodeltest.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.latte.dbindingviewmodeltest.database.dao.UserDao;
import com.example.latte.dbindingviewmodeltest.database.entity.User;

import java.util.List;

import android.support.annotation.NonNull;

/**
 * Created by latte on 2018. 2. 21..
 */

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();

    private static final String DB_NAME = "db-latte";
    private static AppDatabase dbInstance;

    public static AppDatabase getInstance(final Context context) {
        if (dbInstance == null) {
            synchronized (AppDatabase.class) {
                dbInstance = buildDatabase(context.getApplicationContext());
            }
        }
        return dbInstance;
    }

    private static AppDatabase buildDatabase(final Context appContext) {

        return Room.databaseBuilder(appContext, AppDatabase.class, DB_NAME)
                .addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        AppDatabase database = Room.databaseBuilder(appContext,
                                AppDatabase.class, "db-latte").build();
                        List<User> users = DataGenerator.generateUsers();
                        insertData(database, users);
                    }
                }).allowMainThreadQueries().build();
    }


    private static void insertData(AppDatabase database, List<User> users) {
        database.runInTransaction(() -> {
            database.userDao().insertAll(users);
        });
    }
}