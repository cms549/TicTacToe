package com.example.cms549.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameScreen extends AppCompatActivity {

    int[] board;
    int[] buttonsToId;
    TextView turn;
    boolean currPlayer;
    boolean gameOver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);
        board = new int[9];
        for(int i=0; i<board.length; i++){
            board[i] =0;
        }
        currPlayer = false;
        gameOver=false;
        buttonsToId = new int[9];
        buttonsToId[0] = R.id.b1;
        buttonsToId[1] = R.id.b2;
        buttonsToId[2] = R.id.b3;
        buttonsToId[3] = R.id.b4;
        buttonsToId[4] = R.id.b5;
        buttonsToId[5] = R.id.b6;
        buttonsToId[6] = R.id.b7;
        buttonsToId[7] = R.id.b8;
        buttonsToId[8] = R.id.b9;
        turn = (TextView) findViewById(R.id.turn);

    }

    public void makeMove(View view) {
        if(gameOver){
            return;
        }
        int buttonId = view.getId();
        int i;
        for(i=0;i<9; i++) {
            if (buttonsToId[i] == buttonId) {
                break;
            }
        }


        if(board[i]!=0){
            //Can't move
            turn.setText("Can't go there.");
        }
        else{
            //check who's turn it is
            int xoro=1;
            char x = 'x';
            if(currPlayer){
                xoro=-1;
                x ='o';
            }
            board[i] = xoro;
            Button b = (Button) view;
            b.setText(""+x);
            //check if they won
            if(didWin(xoro)){
                turn.setText("PLAYER "+ x+" Wins!!!");
               gameOver=true;
                return;
            }

            //switch player turn
            currPlayer= !currPlayer;
            changeTurnText();
        }


    }

    public void restart(View view) {
        gameOver=false;
        currPlayer = false;
        changeTurnText();
        Button b;
        for(int i=0; i<9;i++){
            board[i]=0;
            b= (Button) findViewById(buttonsToId[i]);
            b.setText(" ");
        }
    }

    private void changeTurnText(){
        char t  = 'x';
        if(currPlayer){
            t = 'o';
        }
        turn.setText("Player "+t+"'s turn.");
    }

    private boolean didWin(int x){
        int ans = 3;
        if(x<0){
            ans=-3;
        }
        for(int i=0; i<9; i=i+3){
            if(board[i]+ board[i+1]+board[i+2]==ans){
                return true;
            }
        }
        for(int i=0; i<3; i++){
            if(board[i]+ board[i+3]+board[i+6]==ans){
                return true;
            }
        }
        if(board[0]+board[4]+board[8]==ans){
            return true;
        }
        if(board[2]+board[4]+board[6]==ans) {
            return true;
        }

        return false;
    }
}
