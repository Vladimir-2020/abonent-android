package com.example.mobileapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static com.example.mobileapp.MainActivity.viewPager;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<Abonent> abonentList;
    private FireBase fireBase;

    public DataAdapter(Context context, List<Abonent> abonentList) {
        this.abonentList = abonentList;
        this.inflater = LayoutInflater.from(context);
    }

    public void update() {
        notifyDataSetChanged();
    }

    public void upd(List<Abonent> listAfterDelete) {
        abonentList = listAfterDelete;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.list_item, parent, false);

        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull final DataAdapter.ViewHolder holder, int position) {

        final Abonent abonent = abonentList.get(position);

        holder.name.setText(abonent.getLastname() + "\n"
                + abonent.getFirstname());
        holder.date.setText(abonent.getDate());
        holder.name.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                UpdateFragment.writeIn(abonent);
                viewPager.setCurrentItem(2);
            }
        });

        holder.btn_del.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                fireBase = new FireBase();
                fireBase.delete(abonent.getKey());
            }
        });
    }

    @Override
    public int getItemCount() {
        return abonentList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        final TextView name;
        final TextView date;
        final Button btn_del;

        ViewHolder(View view) {
            super(view);

            name = view.findViewById(R.id.name);
            date = view.findViewById(R.id.date);
            btn_del = view.findViewById(R.id.btn_del);
        }
    }
}