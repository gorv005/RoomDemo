package com.example.net.roomdemo.view;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.net.roomdemo.R;
import com.example.net.roomdemo.entities.Contacts;
import com.example.net.roomdemo.room.database.AppDatabase;
import com.example.net.roomdemo.view.adapter.ListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListContant extends AppCompatActivity {
    private List<Contacts> movieList = new ArrayList<>();
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    ListAdapter listAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_contant);
        ButterKnife.bind(this);
        init();
    }

    void init(){
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        new getList().execute();
    }


    class getList extends AsyncTask<Void, Void, List<Contacts>> {

        @Override
        protected List<Contacts> doInBackground(Void... voids) {

            movieList= AppDatabase.getAppDatabase(getApplicationContext()).getContactDAO()
                    .getContacts();
            return movieList;
        }

        @Override
        protected void onPostExecute(List<Contacts> contacts) {
            super.onPostExecute(contacts);
            listAdapter=new ListAdapter(movieList);
            recyclerView.setAdapter(listAdapter);


        }
    }

}
