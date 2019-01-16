package com.example.net.roomdemo.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.net.roomdemo.R;
import com.example.net.roomdemo.entities.Contacts;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {

private List<Contacts> moviesList;

public class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView t1, t2, t3,t4;

    public MyViewHolder(View view) {
        super(view);
        t1 = (TextView) view.findViewById(R.id.t1);
        t2 = (TextView) view.findViewById(R.id.t2);
        t3 = (TextView) view.findViewById(R.id.t3);
        t4 = (TextView) view.findViewById(R.id.t4);

    }
}


    public ListAdapter(List<Contacts> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Contacts movie = moviesList.get(position);
        holder.t1.setText(movie.getFirstName());
        holder.t2.setText(movie.getLastName());
        holder.t3.setText(movie.getPhoneNumber());
        if(movie.getJobInfo()!=null) {
            holder.t4.setText(movie.getJobInfo().getCompanyName());
        }
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}
