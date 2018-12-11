package com.example.latte.dbindingviewmodeltest.database.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.example.latte.dbindingviewmodeltest.model.UserModel;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by latte on 2018. 2. 21..
 */
@Entity(tableName = "users")
public class User  implements UserModel{
    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "first_name")
    private String firstName;

    @ColumnInfo(name = "last_name")
    private String lastName;

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public int getUid() {
        return uid;
    }

    @Override
    public String getName() {
        return firstName + " / "+lastName;
    }
}
