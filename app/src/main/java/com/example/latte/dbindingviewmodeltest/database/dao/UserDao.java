package com.example.latte.dbindingviewmodeltest.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.latte.dbindingviewmodeltest.database.entity.User;

import java.util.List;

/**
 * Created by latte on 2018. 2. 21..
 */

@Dao
public interface UserDao {
    @Query("SELECT * FROM users")
    List<User> getAll();

    @Query("SELECT * FROM users WHERE uid IN (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM users WHERE uid = :userId")
    List<User> loadAllById(int userId);

    @Query("SELECT * FROM users WHERE first_name LIKE :first AND "
            + "last_name LIKE :last LIMIT 1")
    User findByName(String first, String last);

    @Insert
    void insertAll(List<User> users);

    @Delete
    void delete(User user);
}