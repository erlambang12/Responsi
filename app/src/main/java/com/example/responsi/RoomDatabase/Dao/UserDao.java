package com.example.responsi.RoomDatabase.Dao;

import androidx.room.Insert;
import androidx.room.Query;

import com.example.responsi.RoomDatabase.Entity.UserEntity;

public interface UserDao {
    @Insert
    void registerUser(UserEntity userEntity);

    @Query("SELECT * from users where email=(:email) and password=(:password)")
    UserEntity login(String email, String password);

    @Query("SELECT * from users where email=(:email)")
    UserEntity recovery(String email);
}
