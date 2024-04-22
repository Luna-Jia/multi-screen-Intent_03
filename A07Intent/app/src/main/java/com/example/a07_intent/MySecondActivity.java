package com.example.a07_intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.activity.OnBackPressedCallback;

public class MySecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_second);

        // 3 approaches https://medium.com/@sivakumarpurushothaman/android-adding-back-button-in-toolbar-70fdedd31296
        if (getIntent() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            //getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle("Back to First");

            Bundle extras = getIntent().getExtras();
            String lv_str = extras != null ? extras.getString("StrArg") : "Empty";
            TextView vvTvOut2 = findViewById(R.id.vv_tvOut2);
            vvTvOut2.setText("You Typed - " + lv_str);
        }
        // Method 2
        Button vvBtnTo1 = findViewById(R.id.vv_btnTo1);
        vvBtnTo1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        cfp_navBack(1);
                    }
                });

        //// HERE https://developer.android.com/guide/navigation/navigation-custom-back
        // This callback will only be called when MyFragment is at least Started.
        /*OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                // Handle the back button event
                //onBackPressed();
                getSupportActionBar().setTitle("Back");
                Intent lv_it = new Intent(MySecondActivity.this, MainActivity.class);
                startActivity(lv_it);
                overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_right);
            }
        };
        getOnBackPressedDispatcher().addCallback(this, callback);*/
        // The callback can be enabled or disabled here or in handleOnBackPressed()

    }
    // Method 1
    // https://www.geeksforgeeks.org/how-to-add-and-customize-back-button-of-action-bar-in-android/
   /*@Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //Intent lv_it = new Intent(MySecondActivity.this, MainActivity.class);
                //startActivity(lv_it);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }*/

    // Method 3a
    // Android on screen back button, this will disable it
    @Override
    public void onBackPressed() {
        //Intent lv_it = new Intent(MySecondActivity.this, MainActivity.class);
        //startActivity(lv_it);
        cfp_navBack(2);
    }

    // Method 1a
    // https://stackoverflow.com/questions/18780112/onsupportnavigateup-not-called/45076058
    // if you override onOptionsItemSelected, then onSupportNavigateUp will not be called.
    @Override
    public boolean onSupportNavigateUp() {
        //Intent lv_it = new Intent(MySecondActivity.this, MainActivity.class);
        //startActivity(lv_it);
        //onBackPressed();
        cfp_navBack(3);
        return true;
    }

    private void cfp_navBack (int type){
        Intent lv_it = new Intent(MySecondActivity.this, MainActivity.class);
        lv_it.putExtra("IntArg", type);
        startActivity(lv_it);
        overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_right);
    }
}