package com.salmeron.mario.tennis;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //Initialize Model
        TextView playerName1 = (TextView)findViewById(R.id.tv_nameofplayer1) ;
        TextView playerName2 = (TextView)findViewById(R.id.tv_nameofplayer2) ;
        TextView absScoreofPlayer1 = (TextView)findViewById(R.id.absolute_score_player_one) ;
        TextView absScoreofPlayer2 = (TextView)findViewById(R.id.absolute_score_player_two) ;
        TextView totalScore = (TextView)findViewById(R.id.tv_totalscore) ;

        //Player´s Names from previous Layout;
        Bundle bundle=getIntent().getExtras();
        String player1 = bundle.getString("player1");
        String player2 = bundle.getString("player2");
        playerName1.setText(player1);
        playerName2.setText(player2);

        //Initial values of Score in the Game between the two players.
        String initialvalue="0";
        absScoreofPlayer1.setText(initialvalue);
        absScoreofPlayer2.setText(initialvalue);

        totalScore.setText(R.string.love_All);


    }

    public void advanceGame(View v) {

        //More Complex Modelating of Data.
        TextView absScoreofPlayer1 = (TextView) findViewById(R.id.absolute_score_player_one);
        TextView absScoreofPlayer2 = (TextView) findViewById(R.id.absolute_score_player_two);
        TextView totalScore = (TextView) findViewById(R.id.tv_totalscore);

        TextView playerName1 = (TextView) findViewById(R.id.tv_nameofplayer1);
        TextView playerName2 = (TextView) findViewById(R.id.tv_nameofplayer2);

        String pointsP1 = absScoreofPlayer1.getText().toString();
        String pointsP2 = absScoreofPlayer2.getText().toString();

        String nm1 = playerName1.getText().toString();
        String nm2 = playerName2.getText().toString();

        //Evolution(Based on aleatory numbers) of Game for Every Player.

        boolean B1 = false;
        boolean B2 = false;

        String sw_operator = "";
        String sw_complementary = "";
        String name_operator = "";
        String name_complementary = "";

        //Generating 50% chance for every player to make a point.
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(100);

        if (randomInt < 50) {

            if (pointsP1.equals("0")) {
                pointsP1 = "15";
            } else if (pointsP1.equals("15")) {
                pointsP1 = "30";
            } else if (pointsP1.equals("30")) {
                pointsP1 = "40";
            } else if (pointsP1.equals("40")) {
                pointsP1 = "WIN";
            }
            B1 = true;
            absScoreofPlayer1.setText(pointsP1);

        } else {

            if (pointsP2.equals("0")) {
                pointsP2 = "15";
            } else if (pointsP2.equals("15")) {
                pointsP2 = "30";
            } else if (pointsP2.equals("30")) {
                pointsP2 = "40";
            } else if (pointsP2.equals("40")) {
                pointsP1 = "WIN";
            }
            B2 = true;
            absScoreofPlayer2.setText(pointsP2);

        }

        //Total Score in Array .

        String totalScoreArray = totalScore.getText().toString();
        String collector = "";
        String[] anArray = new String[20];
        anArray[0]= totalScoreArray;


        if (B1) {
            sw_operator = pointsP1;
            sw_complementary = pointsP2;
            name_operator = nm1;
            name_complementary = nm2;
        } else if (B2) {
            sw_operator = pointsP2;
            sw_complementary = pointsP1;
            name_operator = nm2;
            name_complementary = nm1;
        }


        switch (sw_operator) {
            case "0":
                if (sw_complementary.equals("WIN")) {
                    totalScoreArray = "WIN for: " + name_complementary;
                } else if (sw_complementary.equals("40")) {
                    totalScoreArray = "Advantage for: " + name_complementary;
                } else if (sw_complementary.equals("30")) {
                    totalScoreArray = "Thirty-Love";
                } else if (sw_complementary.equals("15")) {
                    totalScoreArray = "Fifteen-Love";
                } else if (sw_complementary.equals("0")) {
                    totalScoreArray = "Love-All";
                }
                collector = totalScoreArray;
                anArray[0]=anArray[0]+" , "+collector;
                totalScore.setText(anArray[0]);
                break;

            case "15":
                if (sw_complementary.equals("WIN")) {
                    totalScoreArray = "WIN for: " + name_complementary;
                } else if (sw_complementary.equals("40")) {
                    totalScoreArray = "Advantage for: " + name_complementary;
                } else if (sw_complementary.equals("30")) {
                    totalScoreArray = "Thirty-Fifteen";
                } else if (sw_complementary.equals("15")) {
                    totalScoreArray = "Fifteen-All";
                } else if (sw_complementary.equals("0")) {
                    totalScoreArray = "Fifteen-Love";
                }
                collector = totalScoreArray;
                anArray[0]=anArray[0]+" , "+collector;
                totalScore.setText(anArray[0]);
                break;
            case "30":
                if (sw_complementary.equals("WIN")) {
                    totalScoreArray = "WIN for: " + name_complementary;
                } else if (sw_complementary.equals("40")) {
                    totalScoreArray = "Advantage for: " + name_complementary;
                } else if (sw_complementary.equals("30")) {
                    totalScoreArray = "Thirty-All";
                } else if (sw_complementary.equals("15")) {
                    totalScoreArray = "Thirty-Fifteen";
                } else if (sw_complementary.equals("0")) {
                    totalScoreArray = "Thirty-Love";
                }
                collector = totalScoreArray;
                anArray[0]=anArray[0]+" , "+collector;
                totalScore.setText(anArray[0]);
                break;
            case "40":
                if (sw_complementary.equals("WIN")) {
                    totalScoreArray = "WIN for: " + name_complementary;
                }else if (sw_complementary.equals("40")) {
                    totalScoreArray = "DEUCE";
                } else if (sw_complementary.equals("30")) {
                    totalScoreArray = "Advantage for: " + name_operator;
                } else if (sw_complementary.equals("15")) {
                    totalScoreArray = "Advantage for: " + name_operator;
                } else if (sw_complementary.equals("0")) {
                    totalScoreArray = "Advantage for: " + name_operator;
                }
                collector = totalScoreArray;
                anArray[0]=anArray[0]+" , "+collector;
                totalScore.setText(anArray[0]);
                break;
            case "WIN":
                if (sw_complementary.equals("WIN")) {
                    totalScoreArray = "WIN for: " + name_complementary;
                } else if (sw_complementary.equals("0")) {
                    totalScoreArray = "WIN for: " + name_operator;
                } else if (sw_complementary.equals("15")) {
                    totalScoreArray = "WIN for: " + name_operator;
                } else if (sw_complementary.equals("30")) {
                    totalScoreArray = "WIN for: " + name_operator;
                } else if (sw_complementary.equals("40")) {
                    totalScoreArray = "WIN for: " + name_operator;
                }
                collector = totalScoreArray;
                anArray[0]=anArray[0]+" , "+collector;
                if (( anArray[0].contains("WIN"))) {
                    break;
                } else {
                    totalScore.setText(anArray[0]);
                    break;
                }


        }

    }




}






















