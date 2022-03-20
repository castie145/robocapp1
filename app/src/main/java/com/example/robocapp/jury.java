package com.example.robocapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class jury extends AppCompatActivity {
    BottomNavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jury);

        getSupportActionBar().hide();

        navigationView=findViewById(R.id.navbar);
        getSupportFragmentManager().beginTransaction().replace(R.id.body_container ,new suiveurFragment() ).commit();
        navigationView.setSelectedItemId(R.id.sr);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){ ;

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId())
                {
                    case   R.id.sr:
                        fragment = new suiveurFragment();
                                break;
                    case   R.id.jr:
                        fragment = new juniorFragment();
                        break;
                    case   R.id.au:
                        fragment = new autonomeFragment();
                        break;
                    case   R.id.tt:
                        fragment = new tterrainFragment();
                        break;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.body_container , fragment).commit();
                return true;
            }
        });
    }
}