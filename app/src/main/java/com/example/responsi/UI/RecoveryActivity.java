package com.example.responsi.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.responsi.R;
import com.example.responsi.RoomDatabase.Dao.UserDao;
import com.example.responsi.RoomDatabase.Entity.UserEntity;
import com.example.responsi.RoomDatabase.UserDatabase;

public class RecoveryActivity extends AppCompatActivity {
    EditText email;
    Button recovery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recovery);

        email = findViewById(R.id.email);
        recovery = findViewById(R.id.recovery);
        recovery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailText = email.getText().toString();
                if (emailText.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Mohon isi semua", Toast.LENGTH_SHORT).show();
                } else {
                    UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                    UserDao userDao = userDatabase.userDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            UserEntity userEntity = userDao.recovery(emailText);
                            if (userEntity == null) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(), "Tidak valid", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            } else {
                                startActivity(new Intent(RecoveryActivity.this, LoginActivity.class));
                            }
                        }
                    }).start();
                }
            }
        });
    }
}