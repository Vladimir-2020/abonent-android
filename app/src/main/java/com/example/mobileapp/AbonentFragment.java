package com.example.mobileapp;

import android.os.Bundle;
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

public class AbonentFragment extends Fragment {

    private EditText lastname;
    private EditText firsname;
    private EditText middlename;
    private EditText street;
    private EditText building;
    private EditText flat;
    private EditText phone;
    private EditText tarif;

    private Abonent abonent;
    private FireBase fireBase;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.abonent_fragment, container, false);
        Button button = v.findViewById(R.id.button);
        lastname = v.findViewById(R.id.lastname);
        firsname = v.findViewById(R.id.firstname);
        middlename = v.findViewById(R.id.middlename);
        street = v.findViewById(R.id.street);
        building = v.findViewById(R.id.building);
        flat = v.findViewById(R.id.flat);
        phone = v.findViewById(R.id.phone);
        tarif = v.findViewById(R.id.tarif);

        final AwesomeValidation validation = new AwesomeValidation(ValidationStyle.BASIC);

        validation.addValidation(lastname, RegexTemplate.NOT_EMPTY, "Введите фамилию");
        validation.addValidation(firsname, RegexTemplate.NOT_EMPTY, "Введите имя");
        validation.addValidation(middlename, RegexTemplate.NOT_EMPTY,"Введите отчество");
        validation.addValidation(street, RegexTemplate.NOT_EMPTY, "Введите название улицы/проспекта");
        validation.addValidation(building, RegexTemplate.NOT_EMPTY, "Введите номер дома");
        validation.addValidation(flat, RegexTemplate.NOT_EMPTY, "Введите номер квартиры");
        validation.addValidation(phone, RegexTemplate.NOT_EMPTY, "Введите номер телефона");
        validation.addValidation(tarif, RegexTemplate.NOT_EMPTY, "Введите название тарифа");

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (validation.validate()) {

                    abonent = new Abonent();

                    String last = lastname.getText().toString().trim();
                    String first = firsname.getText().toString().trim();
                    String middle = middlename.getText().toString().trim();
                    String st = street.getText().toString().trim();
                    String build = building.getText().toString().trim();
                    String fl = flat.getText().toString().trim();
                    String ph = phone.getText().toString().trim();
                    String tar = tarif.getText().toString().trim();

                    abonent.setLastname(last);
                    abonent.setFirstname(first);
                    abonent.setMiddlename(middle);
                    abonent.setStreet(st);
                    abonent.setBuilding(build);
                    abonent.setFlat(fl);
                    abonent.setPhone(ph);
                    abonent.setTarif(tar);

                    fireBase = new FireBase();
                    fireBase.write(abonent);
                    viewPager.setCurrentItem(1);
                }
            }
        });

        return v;
    }
}
