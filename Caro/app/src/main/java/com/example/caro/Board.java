package com.example.caro;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class Board extends View {
    private final int boardColor;
    private final int XColor;
    private final int OColor;
    private final int winningLineColor;

    private final Paint paint= new Paint();
    private int cellSize = getWidth()/3;
    public Board(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,R.styleable.Board,0,0);
        try{
            boardColor = a.getInteger(R.styleable.Board_boardColor,0);
            XColor = a.getInteger(R.styleable.Board_XColor,0);
            OColor = a.getInteger(R.styleable.Board_OColor,0);
            winningLineColor = a.getInteger(R.styleable.Board_winningLineColor,0);
        }finally {
            a.recycle();
        }
    }
    @Override
    protected void onMeasure(int width,int height){
        super.onMeasure(width,height);


        int dimensions = Math.min(getMeasuredWidth(),getMeasuredHeight());
        cellSize = dimensions/3;
        setMeasuredDimension(dimensions,dimensions);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);

        drawGameBoard(canvas);
    }

    private void drawGameBoard(Canvas canvas) {
        paint.setColor(boardColor);
        paint.setStrokeWidth(16);
        for(int c=1;c<3;c++){
            canvas.drawLine(cellSize*c,0,cellSize*c,canvas.getWidth(),paint);
        }
        for(int r=1;r<3;r++){
            canvas.drawLine(0,cellSize*r ,canvas.getWidth(),cellSize*r,paint);
        }
    }
}
