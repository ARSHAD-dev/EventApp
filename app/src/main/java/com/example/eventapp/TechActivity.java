package com.example.eventapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TechActivity extends AppCompatActivity {
    private TextView GenClubHeading;
    private Button amtc, alias;
    int value, nvalue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tech_activity);
        GenClubHeading = findViewById(R.id.genclubhead);
        amtc = findViewById(R.id.amtc_bttn);
        alias = findViewById(R.id.alias_btn);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            value = bundle.getInt("value");

        }
        Display();
        amtc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TechActivity.this, AmtcActivity.class);
                nvalue = 10 * value + 1;
                intent.putExtra("value", nvalue);
                startActivity(intent);

            }
        });
        alias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nvalue = 10 * value + 2;
                Intent intent = new Intent(TechActivity.this, AmtcActivity.class);
                intent.putExtra("value", nvalue);
                startActivity(intent);


            }
        });
    }

    void Display() {
        alias.setVisibility(View.GONE);
        switch (value) {
            case 1:
                GenClubHeading.setText("TECHNICAL SOCIETIES");
                amtc.setText("AMTC");
                alias.setVisibility(View.VISIBLE);
                alias.setText("ALIAS");
                break;
            case 2:
                GenClubHeading.setText("DANCE SOCIETIES");
                amtc.setText("CEZZANE");
                break;
            case 3:
                GenClubHeading.setText("MUSIC SOCIETIES");
                amtc.setText("DASP");
                break;
            case 4:
                GenClubHeading.setText("ART SOCIETIES");
                amtc.setText("STROKES");
                break;
            case 5:
                GenClubHeading.setText("DRAMA SOCIETIES");
                amtc.setText("AZMIE");
                break;
            case 6:
                GenClubHeading.setText("LITERARY SOCIETIES");
                amtc.setText("ALFAAZ");
                break;
        }

    }

}

