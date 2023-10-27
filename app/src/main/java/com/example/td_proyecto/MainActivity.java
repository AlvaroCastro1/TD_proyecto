package com.example.td_proyecto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editTextBinary;
    private Button drawLineButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextBinary = findViewById(R.id.editTextBinary);
        drawLineButton = findViewById(R.id.drawLineButton);

        drawLineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredNumber = editTextBinary.getText().toString();
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("enteredNumber", enteredNumber);
                startActivity(intent);
            }
        });
    }
}
