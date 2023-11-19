package com.example.myapplication;

import java.util.*;
import java.util.LinkedList;


public class Graph {
    private int numNode;         //intialzing the number of nodes var
    private int DesiredRoom; // initialzing the desired room number

    private LinkedList<Integer> adj[];   //initializing the adjacency list

    private int visited[];

    private int k;

    private boolean found;

    /**
     * @param numRooms
     *  It takes an integer numRooms as an argument,
     * which represents the number of vertices in the graph.
     *
     * When you create a Graph object,
     * you provide the number of vertices it should have.
     */
    public Graph(int numRooms,  int desiredRoom) {
        numNode = numRooms; // number of rooms that the floor has
        k =0;
        found = false;

        visited = new int[numRooms];
        adj = new LinkedList[numRooms]; // Each element of this array will hold a linked list
        // Each linked list represents the list of adjacent vertices for a specific vertex in the graph.
        DesiredRoom = desiredRoom;
        for (int i = 0; i < numRooms; i++) {
            adj[i] = new LinkedList();

        }


    }




    public int[] getVisited() {
        return visited;
    }

    private void addVisited(int i, int v){
        visited[i] = v;

    }

    /**
     * @param v vertex/room
     * @param w vertex/room
     *  helps creates an adj. list of the bidirectional egdes in a graph by
     *  making two additions to the adj. list. One that add (v,w) and One that adds (w,v)
     */
    public void addEdge (int v, int w)
    {
        adj[w].add(v);
        adj[v].add(w);
    }

    /**
     *
     * @param StartRoom vertex from which DFS starts.
     * @param nodes A boolean array used to keep track of which vertices have been visited during the DFS traversal.
     * This method is a utility function for performing a depth-first search (DFS) starting from a given vertex.
     */
    private void DFSUtil(int StartRoom, boolean nodes[])
    {
        nodes[StartRoom] = true;
        addVisited(k,StartRoom);
        k++;
        int a = 0;

        for (int i = 0; i < adj[StartRoom].size() +1; i++) {

            if (!found) {
                if (i < adj[StartRoom].size()) {
                    a = adj[StartRoom].get(i);

                    if (!nodes[a]) {
                        if (!foundRoom(a)) {
                            DFSUtil(a, nodes);
                        }
                        else {
                            nodes[a] = true;
                            addVisited(k, a);
                            found = true;
                        }
                    }
                }
                else if (i + 1 >= adj[StartRoom].size()) {
                    k--;
                    addVisited(k, 0);
                }
            }
        }
    }



    /**
     * @param v
     * This method is the entry point for performing a depth-first search (DFS) on the graph,
     * starting from a specified vertex 'v'.
     */

    public void DFS(int v)
    {
        boolean already[] = new boolean[numNode];
        DFSUtil(v, already);
    }

    /**
     *
     * @param roomNum the room/ vertice
     * This method checks if the roomNum passed as an argument matches the DesiredRoom.
     * @return true if there is a match, indicating that the desired room has been found.
     */
    private boolean foundRoom(int roomNum)
    {
        return roomNum == DesiredRoom; // returns true if the para  is equal to the  DesiredRoom, or false if not
    }

}
