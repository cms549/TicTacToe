package com.example.christina.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;

    private boolean currColor=false;
    private char[][] board = new char[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        one = findViewById();
        //draw empty board
    }

    public void changeColor(){
        currColor = !currColor;
        //redraw the page in new color
        if(currColor==false){
            //draw it in red
        }
        else{
            //draw it in blue
        }
    }

    public void onClick(){

    }

}
