package com.example.mobileapp;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.mobileapp.user.DataAdapterUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

import static com.example.mobileapp.Search.search_w;

public class FireBase {

    private Abonent abonentFromDb;
    private Abonent reAbonent;
    private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

    private List<Abonent> value = new ArrayList<>();
    private List<Abonent> newValue;

    public List<Abonent> getValue() {
        return value;
    }

    public void find(final DataAdapter adapter) {
        try {
            newValue = new ArrayList<>();
            if (search_w.equals("")) newValue = value;

            for (int i = 0; i < value.size(); i++) {
                if (value.get(i).getLastname().equals(search_w) || value.get(i).getFirstname().equals(search_w)) {
                    newValue.add(value.get(i));
                }
            }

            adapter.upd(newValue);

        } catch (Exception e) {
            Log.e("Error", e.toString());
        }
    }

    public void findForUser(final DataAdapterUser adapter) {
        try {
            newValue = new ArrayList<>();
            if (search_w.equals("")) newValue = value;

            for (int i = 0; i < value.size(); i++) {
                if (value.get(i).getLastname().equals(search_w) || value.get(i).getFirstname().equals(search_w)) {
                    newValue.add(value.get(i));
                }
            }

            adapter.upd(newValue);

        } catch (Exception e) {
            Log.e("Error", e.toString());
        }
    }

    public void readForUser(final DataAdapterUser adapter) {

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @com.google.firebase.database.annotations.Nullable String s) {
                abonentFromDb = dataSnapshot.getValue(Abonent.class);

                if (abonentFromDb != null) {
                    abonentFromDb.setKey(dataSnapshot.getKey());
                    value.add(0, abonentFromDb);
                }
                adapter.update();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @com.google.firebase.database.annotations.Nullable String s) {

                reAbonent = dataSnapshot.getValue(Abonent.class);

                if (reAbonent != null) {
                    reAbonent.setKey(dataSnapshot.getKey());
                    for (int i = 0; i < value.size(); i++) {
                        if (value.get(i).getKey().equals(reAbonent.getKey())) {
                            value.set(i, reAbonent);
                        }
                    }
                    adapter.upd(value);
                }
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                abonentFromDb = dataSnapshot.getValue(Abonent.class);

                if (abonentFromDb != null) {
                    abonentFromDb.setKey(dataSnapshot.getKey());
                    for (int i = 0; i < value.size(); i++) {
                        if (value.get(i).getKey().equals(abonentFromDb.getKey())) {
                            value.remove(i);
                        }
                    }
                    adapter.upd(value);
                }
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void read(final DataAdapter adapter) {

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @com.google.firebase.database.annotations.Nullable String s) {
                abonentFromDb = dataSnapshot.getValue(Abonent.class);

                if (abonentFromDb != null) {
                    abonentFromDb.setKey(dataSnapshot.getKey());
                    value.add(0, abonentFromDb);
                }
                adapter.update();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @com.google.firebase.database.annotations.Nullable String s) {

                reAbonent = dataSnapshot.getValue(Abonent.class);

                if (reAbonent != null) {
                    reAbonent.setKey(dataSnapshot.getKey());
                    for (int i = 0; i < value.size(); i++) {
                        if (value.get(i).getKey().equals(reAbonent.getKey())) {
                            value.set(i, reAbonent);
                        }
                    }
                    adapter.upd(value);
                }
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                abonentFromDb = dataSnapshot.getValue(Abonent.class);

                if (abonentFromDb != null) {
                    abonentFromDb.setKey(dataSnapshot.getKey());
                    for (int i = 0; i < value.size(); i++) {
                        if (value.get(i).getKey().equals(abonentFromDb.getKey())) {
                            value.remove(i);
                        }
                    }
                    adapter.upd(value);
                }
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void delete(final String key) {
        databaseReference.child(key).removeValue();
    }

    public void write(Abonent abonentForDB) {

        RegistrationDate registrationDate= new RegistrationDate();

        databaseReference.push().setValue(abonentForDB);
    }

    public void update(String key, Abonent newAbonent) {
        databaseReference.child(key).setValue(newAbonent);
    }
}


