package com.example.myapplication;

import android.graphics.Path;

public class C1floor {

    private int visitedArr[];

    private PathMaker p;
    private Path path;
    private Graph C1;



    public C1floor(float scaleVale,int currRoom, int nextRoom) {

        int currentRoom = currRoom - 100;
        int desiredRoom = nextRoom - 100;

        addInfo(desiredRoom);

        C1.DFS(currentRoom);
        visitedArr = C1.getVisited();
        p = new PathMaker(scaleVale,visitedArr);
        path = p.getPath();
    }
    public Path getPath()
    {
        return path;
    }

    public float getX(int num){
        num -=100;
        return p.getX(num);
    }

    public float getY(int num){
        num -=100;
        return p.getY(num);
    }

    private void addInfo(int num){
        C1 = new Graph(70, num);

        C1.addEdge(60, 14); // the edges between all the room in the C1 floor
        C1.addEdge(60, 12);
        C1.addEdge(60, 10);
        C1.addEdge(60, 6);
        C1.addEdge(60, 4);
        C1.addEdge(60, 2);
        C1.addEdge(60, 61);
        C1.addEdge(61, 62);
        C1.addEdge(62, 20);
        C1.addEdge(62, 65);
        C1.addEdge(65, 49);
        C1.addEdge(65, 48);
        C1.addEdge(20, 30);
        C1.addEdge(20, 27);
        C1.addEdge(20, 25);

        C1.addEdge(20, 26);
        C1.addEdge(20, 64);
        C1.addEdge(64, 21);
        C1.addEdge(64, 22);
        C1.addEdge(64, 24);
        C1.addEdge(64, 33);
        C1.addEdge(64, 23);

        C1.addEdge(64, 32);
        C1.addEdge(65, 66);
        C1.addEdge(66, 40);
        C1.addEdge(40, 41);
        C1.addEdge(40, 42);
        C1.addEdge(40, 43);

        C1.addEdge(40, 45);
        C1.addEdge(40, 44);
        C1.addEdge(40, 46);
        C1.addEdge(40, 67);
        C1.addEdge(67, 52);
        C1.addEdge(67, 51);
        C1.addEdge(67, 50);
        C1.addEdge(67, 55);
        C1.addEdge(67, 56);
        C1.addEdge(67, 57);
        C1.addEdge(67, 54);
        C1.addEdge(67, 53);

    }





}


