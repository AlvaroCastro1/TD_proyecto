package com.example.td_proyecto;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    private String Numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String numero = getIntent().getStringExtra("enteredNumber");

        if (numero.length() < 8) {
            showValidationErrorDialog("Entrada inválida", "Asegúrate de ingresar más de 8 caracteres.");
        } else if (numero.length() > 20) {
            showValidationErrorDialog("Entrada inválida", "Asegúrate de ingresar menos de 20 caracteres.");
        } else if (!numero.matches("[01]+")) {
            showValidationErrorDialog("Entrada inválida", "Asegúrate de ingresar solo 0s y 1s.");
        } else {
            inicio();
        }
    }

    private void showValidationErrorDialog(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Cierra el cuadro de diálogo, el usuario permanece en la página actual.
                        dialog.dismiss();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public int obtenerAnchoPantalla() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display display = getWindowManager().getDefaultDisplay();
        display.getMetrics(displayMetrics);
        int anchoPantalla = displayMetrics.widthPixels;
        return anchoPantalla;
    }

    public void inicio(){
        setContentView(R.layout.activity_result);

        String numero = getIntent().getStringExtra("enteredNumber");
        TextView resultTextView = findViewById(R.id.resultTextView);


        resultTextView.setText("Número ingresado: " + numero);

        // Encontrar el elemento y forzar el redibujado
        DrawingView drawingView = findViewById(R.id.drawingView);
        DrawingView2 drawingView2 = findViewById(R.id.drawingView2);
        DrawingView3 drawingView3 = findViewById(R.id.drawingView3);
        drawingView.set_numero(numero);
        drawingView2.set_numero(numero);
        drawingView3.set_numero(numero);
        int ancho = obtenerAnchoPantalla();
        //String mensaje = "len: " + numero.length();
        //Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();

        drawingView.set_largoView(ancho);
        drawingView2.set_largoView(ancho);
        drawingView3.set_largoView(ancho);
        drawingView.invalidate();
        drawingView2.invalidate();
        drawingView3.invalidate();
    }
}
