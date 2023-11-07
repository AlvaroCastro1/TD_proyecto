package com.example.td_proyecto;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

public class DrawingView2 extends View {
    private Paint paint;
    private String numero;
    private float largo_view;

    public DrawingView2(Context context, AttributeSet attrs) {
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
        return (int) 1080 / 20;
        //return (int) largo_view / numero.length();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int inicio_x = 0;
        int largoLinea = calcular_largo();
        paint.setStrokeWidth(10);

        String mensaje = "Bits: " + numero.length() ;
        Toast.makeText(this.getContext(), mensaje, Toast.LENGTH_LONG).show();

        int y = 60; // Comenzamos en la posición baja
        for (int i = 0; i < numero.length(); i++) {
            String bit = "" + numero.charAt(i);
            int fin_x = inicio_x + largoLinea; // Calcular el extremo de la línea
            color1(i); // generar color intercalado

                if (bit.equals("1")) {
            // Para un "1", invertimos el nivel del bit
                   y = (y == 60) ? 10 : 60;
               }
            // Dibujamos la línea en el nivel del bit actual
               canvas.drawLine(inicio_x, y, fin_x, y, paint);
               inicio_x = fin_x;
        }
    }

    public void color1(int i) {
        if (i%2==0) {
            paint.setColor(getResources().getColor(android.R.color.holo_green_dark));
        } else {
            paint.setColor(getResources().getColor(android.R.color.holo_green_dark));
        }
    }
}
