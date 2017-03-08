package com.example.android.inclassassignment05_boenl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    private String displayMessage="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent=getIntent();
        ArrayList<Student> student = (ArrayList<Student>) intent.getSerializableExtra(MainActivity.INTENT_STUDENT_LIST);
        ScrollView displayView=(ScrollView)findViewById(R.id.displayView);

        for(int i=0; i<student.size();i++){
            String n=student.get(i).toString();
            displayMessage=displayMessage+n+'\n';
        }
        TextView bv=new TextView(this);
        bv.setText(displayMessage);
        bv.setTextSize(30);

        displayView.addView(bv);
    }

}
