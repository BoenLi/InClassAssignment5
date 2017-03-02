package com.example.android.inclassassignment05_boenl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static android.R.attr.name;
import static android.R.id.edit;

public class MainActivity extends AppCompatActivity {
    ArrayList<Student>sList=new ArrayList<>();
    boolean isGraduate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onRadioButtonGraduateClicked(View view){
        boolean checked=((RadioButton)view).isChecked();
        switch(view.getId()){
            case R.id.graduate:
                if(checked){
                    isGraduate=true;
                }
                break;
            case R.id.nograduate:
            if(checked){
                isGraduate=false;
            }
                break;
        }

    }

    public void save(View view){
        EditText editText = (EditText) findViewById(R.id.editText);
        String studentName=editText.getText().toString();

        EditText editText1 = (EditText) findViewById(R.id.editText1);
        int age = Integer.parseInt(editText1.getText().toString());
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        double gpa =Double.parseDouble(editText2.getText().toString());

//        RadioButton gra = (RadioButton) findViewById(R.id.graduate);

        Student s = new Student(studentName,age,gpa,isGraduate);
        sList.add(s);
        editText.setText("");
        editText1.setText("");
        editText2.setText("");

        Toast t=Toast.makeText(this,"Record Saved!",Toast.LENGTH_SHORT);
        t.show();
    }

    public void report(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("Student List", sList);
        startActivity(intent);
    }


}
