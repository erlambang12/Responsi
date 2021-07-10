package com.example.responsi.ButtonNavigation;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.responsi.Fragment.HistoryFragment;
import com.example.responsi.Fragment.HomeFragment;
import com.example.responsi.Fragment.PaymentFragment;
import com.example.responsi.R;
import com.example.responsi.Fragment.SettingsFragment;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import org.jetbrains.annotations.NotNull;

public class HomeActivity extends AppCompatActivity {
    private static final int MY_PERMISSIONS_CAMERA = 1;
    private Fragment fragment = null;
    BottomNavigationView bottomNavigationView;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView = findViewById(R.id.bottomNavigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        bottomNavigationView.setSelectedItemId(R.id.homes);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.homes:
                        ;
                        fragment = new HomeFragment();
                        break;

                    case R.id.ebook:
                        ;
                        fragment = new PaymentFragment();
                        break;

                    case R.id.assignment:
                        ;
                        fragment = new HistoryFragment();
                        break;

                    case R.id.video:
                        ;
                        fragment = new SettingsFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
                return true;
            }
        });
        initFunctionality();
    }
        private void initFunctionality () {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA},
                        MY_PERMISSIONS_CAMERA);
            }
        }
    }