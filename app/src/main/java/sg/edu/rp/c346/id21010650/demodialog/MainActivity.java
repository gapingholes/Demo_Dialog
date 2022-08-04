package sg.edu.rp.c346.id21010650.demodialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button buttonDemo1, buttonDemo2, buttonDemo3, buttonExercise3, buttonDemo4, buttonDemo5;
    TextView textViewDemo2, textViewDemo3, textViewExercise3, textViewDemo4, textViewDemo5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonDemo1 = findViewById(R.id.buttonDemo1);
        buttonDemo2 = findViewById(R.id.buttonDemo2);
        buttonDemo3 = findViewById(R.id.buttonDemo3);
        buttonExercise3 = findViewById(R.id.buttonExercise3);
        buttonDemo4 = findViewById(R.id.buttonDemo4);
        buttonDemo5 = findViewById(R.id.buttonDemo5);

        textViewDemo2 = findViewById(R.id.textViewDemo2);
        textViewDemo3 = findViewById(R.id.textViewDemo3);
        textViewExercise3 = findViewById(R.id.textViewExercise3);
        textViewDemo4 = findViewById(R.id.textViewDemo4);
        textViewDemo5 = findViewById(R.id.textViewDemo5);

        buttonDemo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                /*
                myBuilder.setTitle("Demo 1 - Simple Dialog");
                myBuilder.setMessage("I cannot develop an Android App.");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Close",null);
                */

                myBuilder.setTitle("Congratulations");
                myBuilder.setMessage("I have completed a simple Dialog Box :)");
                myBuilder.setCancelable(true);
                myBuilder.setPositiveButton("Dismiss",null);

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        buttonDemo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                myBuilder.setTitle("Demo 2 - Button Dialog");
                myBuilder.setMessage("Select one of the buttons below");
                myBuilder.setCancelable(false);

                //Configure the No button
                myBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface,int which) {
                        textViewDemo2.setText("  I have selected No.");
                    }
                });

                // Configure the Yes button
                myBuilder.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface,int which) {
                        textViewDemo2.setText("  I have selected Yes.");
                    }
                });

                // Configure the neutral button
                myBuilder.setNeutralButton("Cancel",null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        buttonDemo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Inflate the input.xml layout file
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input,null);

                // Obtain the UI component in the input.xml layout
                // It needs to be defined as "final", so that it can used in the onClick() method later
                final EditText etInput = viewDialog.findViewById(R.id.editTextPersonName);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog);  // Set the view of the dialog
                myBuilder.setTitle("Demo 3-Text Input Dialog");

                myBuilder.setPositiveButton("OK",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,int which) {
                        // Extract the text entered by the user
                        String message = etInput.getText().toString();
                        // Set the text to the TextView
                        textViewDemo3.setText(message);
                    }
                });
                myBuilder.setNegativeButton("CANCEL",null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });
        buttonExercise3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.exercise3input,null);

                final EditText etInput1 = viewDialog.findViewById(R.id.editTextNumber1);
                final EditText etInput2 = viewDialog.findViewById(R.id.editTextNumber2);
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog);
                myBuilder.setTitle("Exercise 3");
                myBuilder.setPositiveButton("OK",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,int which) {
                        String no1 = etInput1.getText().toString();
                        String no2 = etInput2.getText().toString();
                        int sum = Integer.parseInt(no1) + Integer.parseInt(no2);
                        String message = "The sum is ";
                        textViewExercise3.setText(message + sum);
                    }
                });
                myBuilder.setNegativeButton("CANCEL",null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        buttonDemo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create the Listener to set the date
                DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view,int year,int monthOfYear,int dayOfMonth) {
                        textViewDemo4.setText("  Date: " + dayOfMonth + "/" + (monthOfYear+1) + "/" + year);
                    }
                };

                // Create the Date Picker Dialog to show the current date when it first appears
                Calendar now = Calendar.getInstance();
                int year = now.get(Calendar.YEAR);
                int month = now.get(Calendar.MONTH);
                int day = now.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this,
                        myDateListener, year, month, day);
                myDateDialog.show();
            }
        });

        TimePickerDialog.OnTimeSetListener myTimeListener = null;
        buttonDemo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create the Listener to set the date
                TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view,int hourOfDay,int minute) {
                        textViewDemo5.setText("Time: " + hourOfDay + ":" + minute);
                    }
                };
                // Create the Time Picker Dialog
                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this,
                        myTimeListener, 20, 00, false);
                myTimeDialog.show();
            }
            // Create the Date Picker Dialog to show the current date when it first appears
            Calendar now = Calendar.getInstance();
            int hourOfDay = now.get(Calendar.HOUR_OF_DAY);  // Current Hour
            int minute = now.get(Calendar.MINUTE);  // Current Minute
            TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this,
                    null, hourOfDay, minute, true);

        });}}