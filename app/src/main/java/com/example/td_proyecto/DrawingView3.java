package com.example.td_proyecto;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

public class DrawingView3 extends View {
    private Paint paint;
    private String numero;
    private float largo_view;

    public DrawingView3(Context context, AttributeSet attrs) {
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
        int largoLinea = calcular_largo() / 2; // Dividir por 2 para la codificación de Manchester
        paint.setStrokeWidth(10);

        String mensaje = "Bits: " + numero.length();
        Toast.makeText(this.getContext(), mensaje, Toast.LENGTH_LONG).show();
        String bit_anterior = null;
        for (int i = 0; i < numero.length(); i++) {
            String bit = "" + numero.charAt(i);
            int medio_x = inicio_x + largoLinea; // Calcular el medio del intervalo de bit
            int fin_x = inicio_x + largoLinea; // Calcular el extremo de la línea
            color(i); // generar color intercalado

            if (bit.equals("1")) {
                canvas.drawLine(inicio_x, 10, fin_x, 10, paint); // Primera mitad del bit
                canvas.drawLine(medio_x, 10, medio_x, 60, paint); // Transición de alto a bajo
                canvas.drawLine(fin_x, 60, fin_x + largoLinea, 60, paint); // Segunda mitad del bit
            } else {
                canvas.drawLine(inicio_x, 60, fin_x, 60, paint); // Primera mitad del bit
                canvas.drawLine(medio_x, 60, medio_x, 10, paint); // Transición de bajo a alto
                canvas.drawLine(fin_x, 10, fin_x + largoLinea, 10, paint); // Segunda mitad del bit
            }
            if (bit_anterior!=null && bit_anterior.equals(bit)){
                paint.setColor(getResources().getColor(android.R.color.holo_blue_light));
                canvas.drawLine(inicio_x, 10, inicio_x, 60, paint); // conexion entre bits iguales
                //canvas.drawLine(inicio_x, 10, fin_x + largoLinea, 60, paint);
            }
            inicio_x = fin_x + largoLinea; // Ajustar el inicio para el siguiente bit
            bit_anterior= bit;
        }
    }


    public void color(int i) {
        if (i%2==0) {
            paint.setColor(getResources().getColor(android.R.color.holo_blue_dark));
        } else {
            paint.setColor(getResources().getColor(android.R.color.holo_blue_bright));
        }
    }
}
