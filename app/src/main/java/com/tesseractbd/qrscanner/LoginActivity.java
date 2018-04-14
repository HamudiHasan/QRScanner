package com.tesseractbd.qrscanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.activeandroid.query.Select;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    EditText etUserName;
    EditText etPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUserName = findViewById(R.id.username_login);
        etPass = findViewById(R.id.username_pass);
    }

    public void onLogin(View view) {


        if (etUserName.getText().length() > 0 && etPass.getText().length() > 0) {

            String username = etUserName.getText().toString();
            String Pass = etPass.getText().toString();
            List<User> userList = new Select().from(User.class)
                    .where("userName = ? AND password = ? ", username, Pass)
                    .execute();

            if (userList.size() > 0) {
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this, QRActivity.class));
                finish();
            } else {
                Toast.makeText(this, "Please Register First !", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "User Name and Password can't be empty", Toast.LENGTH_SHORT).show();
        }

    }


}
