package com.wanis.assessment;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button playAgainButton;
    TextView endGameMessage;
    ImageButton selectedCard;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playAgainButton = (Button) findViewById(R.id.playAgainButton);
        endGameMessage = (TextView) findViewById(R.id.finalGameTextView);
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
    }

    public void playAgain(View view) {
        selectedCard.setImageResource(R.drawable.card);
        endGameMessage.setVisibility(View.INVISIBLE);
        playAgainButton.setVisibility(View.INVISIBLE);
        isLinearLayoutTouchEnabled(true);
    }

    public void cardClicked(View selectedCard) {
        this.selectedCard = (ImageButton) selectedCard;
        Random random = new Random();
        if (random.nextBoolean()) {
            this.selectedCard.setImageResource(R.drawable.ace_card);
            setWinningText();
        } else {
            this.selectedCard.setImageResource(R.drawable.joker_card);
            setLosingText();
        }

        isLinearLayoutTouchEnabled(false);
        playAgainButton.setVisibility(View.VISIBLE);
    }

    private void setWinningText() {
        endGameMessage.setTextColor(Color.GREEN);
        endGameMessage.setVisibility(View.VISIBLE);
        endGameMessage.setText(R.string.final_game_winning_text);
    }

    private void setLosingText() {
        endGameMessage.setTextColor(Color.RED);
        endGameMessage.setVisibility(View.VISIBLE);
        endGameMessage.setText(R.string.final_game_losing_text);
    }

    private void isLinearLayoutTouchEnabled(Boolean condition) {
        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            View view = linearLayout.getChildAt(i);
            view.setEnabled(condition);
        }
    }
}
