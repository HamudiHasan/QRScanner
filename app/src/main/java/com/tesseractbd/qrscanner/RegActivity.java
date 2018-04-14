package com.tesseractbd.qrscanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegActivity extends AppCompatActivity {

    EditText etUserName;
    EditText etPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        etUserName = findViewById(R.id.username_reg);
        etPass = findViewById(R.id.username_pass_reg);
    }

    public void onRegister(View view) {

        if (etUserName.getText().length() > 0 && etPass.getText().length() > 0) {
            User user = new User();
            user.userName = etUserName.getText().toString();
            user.password = etPass.getText().toString();
            user.save();

            Toast.makeText(this, "Successfully Added", Toast.LENGTH_SHORT).show();

            startActivity(new Intent(RegActivity.this, LoginActivity.class));
            finish();
        }
        else {
            Toast.makeText(this, "User Name and Password can't be empty", Toast.LENGTH_SHORT).show();
        }

    }
}
