package com.example.android.inclassassignment05_boenl;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String INTENT_STUDENT_LIST = "Student List";
    private ArrayList<Student> sList;
    boolean isGraduate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sList = new ArrayList<>();
        String key = getString(R.string.saved_username);
        SharedPreferences sharedPref = getPreferences(MODE_PRIVATE);
        String username = sharedPref.getString(key, getString(R.string.saved_username_default));

        TextView usernameDisplay = (TextView) findViewById(R.id.displayName);
        usernameDisplay.setText("Welcome, " + username + "!");
    }

    public void changeUsername(View view) {
        EditText editText = (EditText) findViewById(R.id.welcome);
        String newUsername = editText.getText().toString();
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(getString(R.string.saved_username), newUsername);
        editor.commit();

        editText.setText("");
        TextView usernameDisplay = (TextView) findViewById(R.id.displayName);
        usernameDisplay.setText("Welcome, " + newUsername + "!");
    }


    public void onRadioButtonGraduateClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.graduate:
                if (checked) {
                    isGraduate = true;
                }
                break;
            case R.id.nograduate:
                if (checked) {
                    isGraduate = false;
                }
                break;
        }

    }

    public void save(View view) {
        EditText editText = (EditText) findViewById(R.id.editText);
        String studentName = editText.getText().toString();

        EditText editText1 = (EditText) findViewById(R.id.editText1);
        int age = Integer.parseInt(editText1.getText().toString());
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        double gpa = Double.parseDouble(editText2.getText().toString());

//        RadioButton gra = (RadioButton) findViewById(R.id.graduate);

        Student s = new Student(studentName, age, gpa, isGraduate);
        sList.add(s);
        editText.setText("");
        editText1.setText("");
        editText2.setText("");

        Toast t = Toast.makeText(this, "Record Saved!", Toast.LENGTH_SHORT);
        t.show();
    }

    public void report(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("Student List", sList);
        startActivity(intent);
    }


}
