package com.example.mobileapp.user;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobileapp.Abonent;
import com.example.mobileapp.FireBase;
import com.example.mobileapp.R;

import java.util.List;

import static com.example.mobileapp.user.Main3Activity.viewPagerUser;

public class DataAdapterUser extends RecyclerView.Adapter<DataAdapterUser.ViewHolder> {

    private LayoutInflater inflater;
    private List<Abonent> abonentList;
    private FireBase fireBase;

    public DataAdapterUser(Context context, List<Abonent> abonentList) {
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
    public DataAdapterUser.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.list_item_user, parent, false); // ???

        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull final DataAdapterUser.ViewHolder holder, int position) {

        final Abonent abonent = abonentList.get(position);

        holder.name.setText(abonent.getLastname() + "\n"
                + abonent.getFirstname());
        holder.date.setText(abonent.getDate());
        holder.name.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                UpdateFragmentUser.writeIn(abonent);
                viewPagerUser.setCurrentItem(1);
            }
        });
    }

    @Override
    public int getItemCount() {
        try {
            return abonentList.size();
        } catch (Exception e) {
            return 0;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        final TextView name;
        final TextView date;

        ViewHolder(View view) {
            super(view);

            name = view.findViewById(R.id.name);
            date = view.findViewById(R.id.date);
        }
    }
}