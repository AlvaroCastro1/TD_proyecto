package com.example.td_proyecto;

import android.content.Context;
import android.graphics.Canvas;
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

        for (int i = 0; i < numero.length(); i++) {
            String bit = "" + numero.charAt(i);
            int fin_x = inicio_x + largoLinea; // Calcular el extremo de la línea
            color(i); // generar color intercalado


            if (bit.equals("1")) {
                canvas.drawLine(inicio_x, 10, fin_x, 10, paint);
            } else {
                canvas.drawLine(inicio_x, 60, fin_x, 60, paint);
            }
            inicio_x = fin_x;
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
