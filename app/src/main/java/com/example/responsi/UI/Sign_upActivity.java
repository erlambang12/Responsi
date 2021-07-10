package com.example.responsi.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.responsi.ButtonNavigation.HomeActivity;
import com.example.responsi.R;
import com.example.responsi.RoomDatabase.Dao.UserDao;
import com.example.responsi.RoomDatabase.Entity.UserEntity;
import com.example.responsi.RoomDatabase.UserDatabase;

public class Sign_upActivity extends AppCompatActivity {
    EditText email, password, confirm;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        confirm = findViewById(R.id.confirm);
        register = findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserEntity userEntity = new UserEntity();
                userEntity.setEmail(email.getText().toString());
                userEntity.setPassword(password.getText().toString());
                userEntity.setConfirm(confirm.getText().toString());
                if (validateInput(userEntity)) {
                    if (password.getText().toString().equals(confirm.getText().toString())) {
                        UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                        UserDao userDao = userDatabase.userDao();
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                userDao.registerUser(userEntity);
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(), "Sudah berhasil", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(Sign_upActivity.this, HomeActivity.class));
                                    }
                                });
                            }
                        }).start();
                    } else {
                        Toast.makeText(getApplicationContext(), "Password tidak boleh berbeda", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Mohon isi semua dengan benar", Toast.LENGTH_SHORT).show();
                }
            }

            private boolean validateInput(UserEntity userEntity) {
                if (userEntity.getEmail().isEmpty() ||
                        userEntity.getPassword().isEmpty() ||
                        userEntity.getConfirm().isEmpty()) {
                    return false;
                }
                return true;
            }
        });

    }
}