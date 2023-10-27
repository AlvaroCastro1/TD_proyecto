package com.example.td_proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        String enteredNumber = getIntent().getStringExtra("enteredNumber");
        TextView resultTextView = findViewById(R.id.resultTextView);
        resultTextView.setText("Número ingresado: " + enteredNumber);

        // Encontrar la DrawingView y forzar el redibujado
        DrawingView drawingView = findViewById(R.id.drawingView);
        drawingView.invalidate(); // Esta línea fuerza el redibujado de la vista personalizada
    }
}
