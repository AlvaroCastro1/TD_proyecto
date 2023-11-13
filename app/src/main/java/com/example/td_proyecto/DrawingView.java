package com.example.td_proyecto;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

public class DrawingView extends View {
    private Paint paint;
    private String numero;
    private float largo_view;

    public DrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setColor(getResources().getColor(android.R.color.holo_green_dark)); // Establecer color naranja
        paint.setStrokeWidth(10); // Ancho de la línea
    }

    public void set_numero(String numero){
        this.numero = numero;
    }

    public void set_largoView(float largo){
        this.largo_view = largo;
    }

    public int calcular_largo(){
        int maxCaracteres = 20; //Maximo de caracteres al ingresar
        return getWidth() / Math.min(numero.length(),maxCaracteres);
        //getWidth Busca y devuelve el ancho de la linea
        //Se devolvera la longitud de numero.length() si es menor o igual a 20
        //Si el numero es igual a maxCaracteres se retorna
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int inicio_x = 0;
        int largoLinea = calcular_largo();
        paint.setStrokeWidth(10);

        String mensaje = "Bits: " + numero.length() ;
        Toast.makeText(this.getContext(), mensaje, Toast.LENGTH_LONG).show();

        int prev_fin_x = 0;
        int prev_y = 0;

        paint.setColor(Color.argb(16,0,0,0));
        for (int i = 0; i < getWidth(); i += largoLinea) {
            canvas.drawLine(i, 0, i, getHeight(), paint);
        }
        for (int i = 0; i < getHeight(); i += 60) {
            canvas.drawLine(0, i, getWidth(), i, paint);
        }
        for (int i = 0; i < numero.length(); i++) {
            String bit = "" + numero.charAt(i);
            int fin_x = inicio_x + largoLinea; // Calcular el extremo de la línea
            color(i); // generar color intercalado
            int y = bit.equals("1") ? 60 : 10;

            if (i != 0) {
                canvas.drawLine(prev_fin_x, prev_y, inicio_x, y, paint);
            }

            canvas.drawLine(inicio_x, y, fin_x, y, paint);

            inicio_x = fin_x;
            prev_fin_x = fin_x;
            prev_y = y;
        }
    }

    public void color(int i) {
        if (i%2==0) {
            paint.setColor(getResources().getColor(android.R.color.holo_red_light));
        } else {
            paint.setColor(getResources().getColor(android.R.color.holo_red_dark));
        }
    }
}
