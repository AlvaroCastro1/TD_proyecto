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

public class DrawingView extends View {
    private Paint paint;

    public DrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setColor(getResources().getColor(android.R.color.holo_orange_light)); // Establecer color naranja
        paint.setStrokeWidth(5); // Ancho de la línea
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int startX = 0; // Coordenada x de inicio
        int endX = getWidth(); // Coordenada x de fin (ancho de la vista)
        int centerY = getHeight() / 2; // Coordenada y en el centro de la vista

        canvas.drawLine(startX, centerY, endX, centerY, paint);
    }
}
