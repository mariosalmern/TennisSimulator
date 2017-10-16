package com.salmeron.mario.tennis;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class playerNameSelector extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playernameselector);
    }

    protected void showToast(){

        Context context = getApplicationContext();
        CharSequence text = "Enter Player´s Names!";
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void obtainPlayerNames(View v){

        EditText player1 = (EditText)findViewById(R.id.player1_editText);
        Editable p_one = player1.getText();
        String p1 = p_one.toString();
        EditText player2 = (EditText)findViewById(R.id.player2_editText);
        Editable p_two = player2.getText();
        String p2 = p_two.toString();

        if((p1.equals("")) |( p2.equals(""))){
            showToast();
        }else{
            //startActivity(new Intent(playerNameSelector.this, GameActivity.class));
            Intent navigate = new Intent(this,GameActivity.class);
            navigate.putExtra("player1",p1);
            navigate.putExtra("player2",p2);

            startActivity(navigate);

        }


    }




}