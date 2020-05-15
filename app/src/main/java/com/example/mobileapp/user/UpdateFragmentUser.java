package com.example.mobileapp.user;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.mobileapp.Abonent;
import com.example.mobileapp.R;

public class UpdateFragmentUser extends Fragment {

    private static TextView newlastname;
    private static TextView newfirstname;
    private static TextView newmiddlename;
    private static TextView newstreet;
    private static TextView newbuilding;
    private static TextView newflat;
    private static TextView newphone;
    private static TextView newtarif;
    private static String key;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.update_fragment_user, container, false); // ???

        newlastname = v.findViewById(R.id.newlastname);
        newfirstname = v.findViewById(R.id.newfirstname);
        newmiddlename = v.findViewById(R.id.newmiddlename);
        newstreet = v.findViewById(R.id.newstreet);
        newbuilding = v.findViewById(R.id.newbuilding);
        newflat = v.findViewById(R.id.newflat);
        newphone = v.findViewById(R.id.newphone);
        newtarif = v.findViewById(R.id.newtarif);

        return v;
    }

    @SuppressLint("SetTextI18n")
    public static void writeIn(Abonent newAbonent) {
        newlastname.setText(newAbonent.getLastname());
        newfirstname.setText(newAbonent.getFirstname());
        newmiddlename.setText(newAbonent.getMiddlename());
        newstreet.setText(newAbonent.getStreet());
        newbuilding.setText(newAbonent.getBuilding());
        newflat.setText(newAbonent.getFlat());
        newphone.setText(newAbonent.getPhone());
        newtarif.setText(newAbonent.getTarif());
        key = newAbonent.getKey();
    }
}