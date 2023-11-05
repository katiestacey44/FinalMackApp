package com.example.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;


public class MainActivity2 extends AppCompatActivity {
    Context context;
    Resources resources;
    RelativeLayout relativeLayout;
    Button button;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        context = getApplicationContext();
        resources = getResources();
        relativeLayout = findViewById(R.id.relativeLayout);
        button = findViewById(R.id.button4);
        imageView = findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.c1map);
        ImageView imageView2 = findViewById(R.id.imageView2);
        //access colors from res>values>colors.xml
        int cyan = ContextCompat.getColor(context, R.color.cyan);
        int red = ContextCompat.getColor(context, R.color.red);
        int blue = ContextCompat.getColor(context, R.color.blue);
        button.setOnClickListener(view -> {


            //The map image's original dimensions are 200x796 px
            float scaleValue = imageView.getWidth()/(float)200; //get the imageView's scaling multiplier

            // proof of concept for how path display will look once the node/edge structure
            // where this will use the x, y Coordinates of the node scaled to match the imageView

            //TESTING PATH DRAW FUNCTION
            float trueX = (165*scaleValue); //(trueX,trueY) c120 branch point
            float trueY =100*scaleValue;
            float trueY2=490*scaleValue;    //(trueX,trueY2) = c1140 branch point
            float x=(float)120*scaleValue;  //120 itself
            float y=(float)490*scaleValue;


            //Create bitmap the size of imageView to pass to canvas to be drawn on
            Bitmap bitmap = Bitmap.createBitmap(imageView.getWidth(), imageView.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            Paint paint = new Paint();
            paint.setColor(cyan);
            paint.setStrokeWidth(22); //line width
            paint.setAntiAlias(true);

            paint.setStyle(Paint.Style.STROKE);//STOKE for drawLine/drawPath
            //canvas.drawLine(trueX, trueY, trueX, trueY2, paint);

            //Path is a series of connected lines drawn
            Path path = new Path();
            path.moveTo(x, y);
            path.lineTo(trueX, trueY2);
            path.lineTo(trueX, trueY);
            path.lineTo(x, trueY);
            canvas.drawPath(path, paint);

            paint.setStyle(Paint.Style.FILL); //FILL style to make circles

            //canvas.drawCircle(trueX,trueY,12,paint);
            //canvas.drawCircle(trueX,trueY2,12,paint);

            paint.setColor(blue);
            canvas.drawCircle(x,y,35,paint);
            paint.setColor(red);
            canvas.drawCircle(x,trueY,30,paint);

            imageView2.setImageBitmap(bitmap);

        });
    }
}