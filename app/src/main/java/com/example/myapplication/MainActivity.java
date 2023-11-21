package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;


/**
 * MainActivity is the main activity of the Android Map Navigation App.
 * It allows users to input current and next room numbers and navigate to the
 * MainActivity2 activity to display the navigation path.
 */

public class MainActivity extends AppCompatActivity {
    private String currentRoom;
    private String nextRoom;
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
        setContentView(R.layout.activity_main);
    }
    /**
     * Opens MainActivity2 to display the navigation path based on the entered current and next room numbers.
     *
     * @param v The View that was clicked.
     */

    public void openMainActivity2(View v){


            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("current", Integer.parseInt(currentRoom));
            intent.putExtra("next", Integer.parseInt(nextRoom));
            startActivity(intent);

            //Toast.makeText(this,"Current Room or Next Room does not Exist", Toast.LENGTH_LONG);


    }
    /**
     * Sets the current room number based on the user input.
     *
     * @param v The View that was clicked.
     */


    public void CurEnter(View v){


        TextInputEditText num  = findViewById(R.id.CurrentRoomNum);//gets the input from user

        String CurrentN = num.getText().toString(); // makes it a string because its initially a char

        currentRoom = CurrentN;                     // set the input to the right variable

        ((TextView)findViewById(R.id.textCurr)).setText("Current room: C1 - "+ CurrentN);

    }

    /**
     * Sets the next room number based on the user input.
     *
     * @param v The View that was clicked.
     */

    public void NextEnter(View v){

        TextInputEditText num  = findViewById(R.id.NextRoomNum);//gets the input from user

        String NextN = num.getText().toString(); // makes it a string because its initially a char

        nextRoom = NextN;

        ((TextView)findViewById(R.id.TextNext)).setText("Next room: C1 - "+ NextN);


    }

}