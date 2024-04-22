package com.example.a07_intent;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


// ver01 simplest intent, just goes to 2nd
// https://www.vogella.com/tutorials/AndroidIntent/article.html Also Chapter 53
// ver02 back button by ActionBar and Menu
// ver03 alternate back button and button
// ver04 alternate back button via callback
// ver05 animation
// https://stackoverflow.com/questions/5151591/android-left-to-right-slide-animation
// https://www.geeksforgeeks.org/how-to-add-slide-animation-between-activities-in-android/
// ver06 data transfer

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getIntent() != null) {
            Bundle extras = getIntent().getExtras();
            int type = extras != null ? extras.getInt("IntArg") : -1;
            String str = "";
            switch (type) {
                case -1: str = "From Launch"; break;
                case 1: str = "From Second, by Button"; break;
                case 2: str = "From Second, by Nav"; break;
                case 3: str = "From Second, by Arrow"; break;
            }
            TextView vvTvOut1 = findViewById(R.id.vv_tvOut1);
            vvTvOut1.setText(str);
        }
        Button vvBtnTo2 = findViewById(R.id.vv_btnTo2);
        vvBtnTo2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ////Context ctx =  MainActivity.this;
                        // need MainActivity.this since 'this' is new OnclickListener
                        Intent lv_it = new Intent(MainActivity.this, MySecondActivity.class);
                        EditText vvEtIn1 = findViewById(R.id.vv_etIn1);
                        lv_it.putExtra("StrArg", vvEtIn1.getText().toString());
                        startActivity(lv_it);
                        overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_left);
                    }
                });
    }
}