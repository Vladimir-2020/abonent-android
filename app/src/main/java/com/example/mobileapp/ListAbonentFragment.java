package com.example.mobileapp;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import static com.example.mobileapp.Search.search_w;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;


public class ListAbonentFragment extends Fragment {

    private FireBase fireBase = new FireBase();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.list_abonent_fragment, container, false);

        RecyclerView recyclerView = v.findViewById(R.id.list);
        final EditText search = v.findViewById(R.id.search_field);
        Button btn = v.findViewById(R.id.search_btn);


        final DataAdapter adapter = new DataAdapter(inflater.getContext(), fireBase.getValue());
        fireBase.read(adapter);
        recyclerView.setAdapter(adapter);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                search_w = search.getText().toString().trim();
                fireBase.find(adapter);
            }
        });



        return v;
}

}
