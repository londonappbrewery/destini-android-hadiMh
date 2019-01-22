package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private TextView mTv_story;
    private Button mBtn_buttonTop;
    private Button mBtn_buttonBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTv_story = (TextView) findViewById(R.id.storyTextView);
        mBtn_buttonTop = (Button) findViewById(R.id.buttonTop);
        mBtn_buttonBottom = (Button) findViewById(R.id.buttonBottom);

        mBtn_buttonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nextText = null;
                String nextTopButtonText = null;
                String nextBottomButtonText = null;
                String s = mTv_story.getText().toString();
                if (getResources().getString(R.string.T1_Story).equals(s) || getResources().getString(R.string.T2_Story).equals(s)) {
                    nextText = getResources().getString(R.string.T3_Story);
                    nextTopButtonText = getResources().getString(R.string.T3_Ans1);
                    nextBottomButtonText = getResources().getString(R.string.T3_Ans2);

                } else if (getResources().getString(R.string.T3_Story).equals(s)) {
                    nextText = getResources().getString(R.string.T6_End);
                    nextTopButtonText = "";
                    nextBottomButtonText = "";

                }

                setNextStoryElementsText(nextText ,nextTopButtonText ,nextBottomButtonText);
            }
        });

        mBtn_buttonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nextText = null;
                String nextTopButtonText = null;
                String nextBottomButtonText = null;
                String s = mTv_story.getText().toString();
                if (getResources().getString(R.string.T1_Story).equals(s)) {
                    nextText = getResources().getString(R.string.T2_Story);
                    nextTopButtonText = getResources().getString(R.string.T2_Ans1);
                    nextBottomButtonText = getResources().getString(R.string.T2_Ans2);

                } else if (getResources().getString(R.string.T3_Story).equals(s)) {
                    nextText = getResources().getString(R.string.T5_End);
                    nextTopButtonText = "";
                    nextBottomButtonText = "";

                } else if (getResources().getString(R.string.T2_Story).equals(s)) {
                    nextText = getResources().getString(R.string.T4_End);
                    nextTopButtonText = "";
                    nextBottomButtonText = "";

                }

                setNextStoryElementsText(nextText ,nextTopButtonText ,nextBottomButtonText);
            }
        });



    }

    private void setNextStoryElementsText(String nextText ,String nextTopButtonText ,String nextBottomButtonText) {
        mTv_story.setText(nextText);
        if(nextTopButtonText.equals("")) {
            mBtn_buttonTop.setVisibility(View.GONE);
        } else {
            mBtn_buttonTop.setText(nextTopButtonText);
        }
        if(nextBottomButtonText.equals("")) {
            mBtn_buttonBottom.setVisibility(View.GONE);
        } else {
            mBtn_buttonBottom.setText(nextBottomButtonText);
        }
    }

//    @Override
//    public void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//
//        outState.putString("StoryText", mTv_story.getText().toString());
//        outState.putString("TopButtonText", mBtn_buttonTop.getText().toString());
//        outState.putString("BottomButtonText", mBtn_buttonBottom.getText().toString());
//
//    }
}
