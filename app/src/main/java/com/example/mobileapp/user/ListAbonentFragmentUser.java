package com.example.mobileapp.user;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobileapp.FireBase;
import com.example.mobileapp.R;

import static com.example.mobileapp.Search.search_w;


public class ListAbonentFragmentUser extends Fragment {

    private FireBase fireBase = new FireBase();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.list_abonent_fragment_user, container, false);

        RecyclerView recyclerView = v.findViewById(R.id.list);
        final EditText search = v.findViewById(R.id.search_field);
        Button btn = v.findViewById(R.id.search_btn);

        final DataAdapterUser adapter = new DataAdapterUser(inflater.getContext(), fireBase.getValue());
        fireBase.readForUser(adapter);
        recyclerView.setAdapter(adapter);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                search_w = search.getText().toString().trim();
                fireBase.findForUser(adapter);
            }
        });

        return v;
    }
}
