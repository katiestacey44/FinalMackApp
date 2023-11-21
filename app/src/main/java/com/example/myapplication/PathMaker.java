package com.example.myapplication;

import android.graphics.Path;

public class PathMaker {

    private Path P;

    private Point[] pointArray;

    private float scaleVal;



    public PathMaker(float scale, int[] Array){
        scaleVal  = scale;
        P = new Path();
        pointArray = new Point[70];
        // Initialize the array with Point objects
        addPoints();

        float x = scaleVal*pointArray[Array[0]].getX();
        float y = scaleVal*pointArray[Array[0]].getY();

        P.moveTo(x, y);

        for (int i = 1; i < Array.length; i++){
            if (Array[i] != 0) {
                x = scaleVal * pointArray[Array[i]].getX();
                y = scaleVal * pointArray[Array[i]].getY();
                P.lineTo(x, y);
            }
        }


    }


    public float getX(int num){

    return pointArray[num].getX() * scaleVal;

    }

    public float getY(int num){

        return pointArray[num].getY() * scaleVal;
    }

    public Path getPath(){
        return P;

    }

    private void addPoints(){
        pointArray[10] = new Point(100, 640); // x and y of the rooms
        pointArray[12] = new Point(100, 640);
        pointArray[14] = new Point(100, 610);
        pointArray[4] = new Point(100, 640);
        pointArray[2] = new Point(100, 640);
        pointArray[6] = new Point(100, 610);
        pointArray[26] = new Point(120, 500);
        pointArray[25] = new Point(90, 500);
        pointArray[20] = new Point(120, 450);
        pointArray[27] = new Point(90, 450);
        pointArray[30] = new Point(80, 430);
        pointArray[24] = new Point(20, 450);
        pointArray[23] = new Point(20, 470);
        pointArray[22] = new Point(20, 490);
        pointArray[21] = new Point(20, 500);
        pointArray[32] = new Point(20, 370);
        pointArray[33] = new Point(20, 350);
        pointArray[50] = new Point(20, 250);
        pointArray[51] = new Point(20, 210);
        pointArray[52] = new Point(20, 180);
        pointArray[53] = new Point(20, 150);
        pointArray[54] = new Point(20, 120);
        pointArray[55] = new Point(20, 80);
        pointArray[56] = new Point(20, 50);
        pointArray[57] = new Point(20, 50);
        pointArray[40] = new Point(120, 100);
        pointArray[44] = new Point(90, 150);
        pointArray[43] = new Point(90, 180);
        pointArray[42] = new Point(90, 210);
        pointArray[41] = new Point(90, 250);
        pointArray[45] = new Point(120, 50);
        pointArray[46] = new Point(90, 50);
        pointArray[49] = new Point(90, 300);
        pointArray[48] = new Point(20, 300);
        pointArray[1] = new Point(165, 470);
        pointArray[60] = new Point(100, 580);
        pointArray[61] = new Point(165, 580);
        pointArray[62] = new Point(165, 470);
        pointArray[63] = new Point(90, 450);
        pointArray[64] = new Point(20, 400);
        pointArray[65] = new Point(165, 300);
        pointArray[66] = new Point(165, 90);
        pointArray[67] = new Point(20, 100);
    }







}
