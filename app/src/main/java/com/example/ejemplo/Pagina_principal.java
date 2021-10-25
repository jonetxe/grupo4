package com.example.ejemplo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Pagina_principal extends AppCompatActivity {

    Fragment_ajustes fragment_ajustes = new Fragment_ajustes();
    Fragment_home fragment_home = new Fragment_home();
    Fragment_usuario fragment_usuario = new Fragment_usuario();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_principal);


        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        loadFragment(fragment_usuario);
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id. fragment_home:
                    loadFragment(fragment_home);
                    return true;
                case R.id. fragment_ajustes:
                    loadFragment(fragment_ajustes);
                    return true;
                case R.id. fragment_usuario:
                    loadFragment(fragment_usuario);
                    return true;
            }
            return false;
        }
    };
    public void loadFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_principal, fragment);
        transaction.commit();
    }
}