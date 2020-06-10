package com.example.mobileapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

import static com.example.mobileapp.MainActivity.viewPager;

public class UpdateFragment extends Fragment {

    private static EditText newlastname;
    private static EditText newfirstname;
    private static EditText newmiddlename;
    private static EditText newstreet;
    private static EditText newbuilding;
    private static EditText newflat;
    private static EditText newphone;
    private static EditText newtarif;
    private static String key;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.update_fragment, container, false);

        newlastname = v.findViewById(R.id.newlastname);
        newfirstname = v.findViewById(R.id.newfirstname);
        newmiddlename = v.findViewById(R.id.newmiddlename);
        newstreet = v.findViewById(R.id.newstreet);
        newbuilding = v.findViewById(R.id.newbuilding);
        newflat = v.findViewById(R.id.newflat);
        newphone = v.findViewById(R.id.newphone);
        newtarif = v.findViewById(R.id.newtarif);
        Button button = v.findViewById(R.id.btn_save);

        final AwesomeValidation validation = new AwesomeValidation(ValidationStyle.BASIC);

        validation.addValidation(newlastname, RegexTemplate.NOT_EMPTY, "Введите фамилию");
        validation.addValidation(newfirstname, RegexTemplate.NOT_EMPTY,"Введите имя");
        validation.addValidation(newmiddlename, RegexTemplate.NOT_EMPTY,"Введите отчество");
        validation.addValidation(newstreet, RegexTemplate.NOT_EMPTY,"Введите название улицы/проспекта");
        validation.addValidation(newbuilding, RegexTemplate.NOT_EMPTY,"Введите номер дома");
        validation.addValidation(newflat, RegexTemplate.NOT_EMPTY,"Ввдите номер квартиры");
        validation.addValidation(newphone, RegexTemplate.NOT_EMPTY,"Введите номер телефона");
        validation.addValidation(newtarif, RegexTemplate.NOT_EMPTY,"Введите название тарифа");

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (validation.validate()) {

                    try {
                        final Abonent reAbonent = new Abonent();
                        RegistrationDate registrationDate = new RegistrationDate();
                        String dat = registrationDate.myDate();
                        reAbonent.setLastname(newlastname.getText().toString());
                        reAbonent.setFirstname(newfirstname.getText().toString());
                        reAbonent.setMiddlename(newmiddlename.getText().toString());
                        reAbonent.setStreet(newstreet.getText().toString());
                        reAbonent.setBuilding(newbuilding.getText().toString());
                        reAbonent.setFlat(newflat.getText().toString());
                        reAbonent.setPhone(newphone.getText().toString());
                        reAbonent.setTarif(newtarif.getText().toString());
                        reAbonent.setKey(key);
                        reAbonent.setDate(dat);

                        FireBase fireBase = new FireBase();
                        fireBase.update(reAbonent.getKey() , reAbonent);

                    } catch (Exception e) {
                        Log.d("_ERR", e + "");
                    }
                    viewPager.setCurrentItem(1);
                }
            }
        });
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