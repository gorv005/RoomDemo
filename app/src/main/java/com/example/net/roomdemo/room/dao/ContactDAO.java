package com.example.net.roomdemo.room.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.net.roomdemo.entities.Contacts;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface ContactDAO {

    @Insert(onConflict = REPLACE)
    public void insert(Contacts... contacts);

    @Update
    public void update(Contacts... contacts);

    @Delete
    public void delete(Contacts contact);

    @Query("SELECT * FROM Contacts")
    public List<Contacts> getContacts();

    @Query("SELECT * FROM Contacts WHERE phoneNumber = :number")
    public Contacts getContactWithId(String number);
}
