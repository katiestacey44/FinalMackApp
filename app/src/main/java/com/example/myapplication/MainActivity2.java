package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.textfield.TextInputEditText;

/**
 * MainActivity2 is the second activity in the Android Map Navigation App.
 * It displays a map with a navigation path and room markers.
 */
public class MainActivity2 extends AppCompatActivity {
    private Context context;
    private Resources resources;
    private RelativeLayout relativeLayout;
    private ImageView imageView;
    private int start;
    private int end;
    private float scaleValValue;
    private Path path;

    /**
     * Called when the activity is first created.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being
     *                           shut down, this Bundle contains the data it most recently supplied
     *                           in onSaveInstanceState(Bundle). Otherwise, it is null.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Initialize member variables
        context = getApplicationContext();
        resources = getResources();
        relativeLayout = findViewById(R.id.relativeLayout);
        imageView = findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.c1map);

        // Obtain current and next room ids from other activity
        start = getIntent().getIntExtra("current", 120);
        end = getIntent().getIntExtra("next", 110);

        // Display information
        ((TextView) findViewById(R.id.CurrText)).setText("Current:" + "\n" + "C1" + start);
        ((TextView) findViewById(R.id.NextText)).setText("Next:" + "\n" + "C1" + end);

        path = new Path();
    }

    /**
     * Displays the navigation path and room markers on the map.
     *
     * @param v The View that was clicked.
     */
    public void ShowButton(View v) {
        // Access colors from res>values>colors.xml
        int cyan = ContextCompat.getColor(context, R.color.cyan);
        int red = ContextCompat.getColor(context, R.color.red);
        int blue = ContextCompat.getColor(context, R.color.blue);

        // Obtain scale value for the map on this device to pass to our path function
        scaleValValue = imageView.getWidth() / (float) 200;
        C1floor c = new C1floor(scaleValValue, start, end);

        // Initialize display
        Bitmap bitmap = Bitmap.createBitmap(imageView.getWidth(), imageView.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();

        paint.setColor(cyan);
        paint.setStrokeWidth(22); // Line width
        paint.setAntiAlias(true);

        paint.setStyle(Paint.Style.STROKE); // STOKE for drawLine/drawPath

        // Get path
        path = c.getPath();

        // Display path and room markers
        canvas.drawPath(path, paint);

        paint.setStyle(Paint.Style.FILL); // FILL style to make circles
        paint.setColor(blue);

        canvas.drawCircle(c.getX(start), c.getY(start), 35, paint);
        paint.setColor(red);
        canvas.drawCircle(c.getX(end), c.getY(end), 30, paint);

        ImageView map = findViewById(R.id.pathDisplay);

        map.setImageBitmap(bitmap);
    }

    /**
     * Navigates back to the main activity.
     *
     * @param v The View that was clicked.
     */
    public void GoBackButton(View v) {
        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(intent);
    }
}
