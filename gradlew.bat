package com.example.android.class30;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.creativityapps.gmailbackgroundlibrary.BackgroundMail;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    //Holds the value of the amount of coffee
    int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void decrement(View view) {
        if (quantity == 1){
            Toast.makeText(getApplicationContext(), "You cannot have less than one coffee", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity - 1;
        display(quantity);
    }

    public void increment(View view) {
        if (quantity>100){
            Toast.makeText(getApplicationContext(), "You cannot have less than one coffee", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity + 1;
        display(quantity);
    }
    public void display(int number){
        TextView textView  = findViewById(R.id.tv);
        textView.setText(""+number);
    }
    //This method generates the order information
    public void submitOrder(View view) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyy 'at' HH:mm:ss");
        String date = sdf.format(new Date());

        EditText nameEditText = findViewById(R.id.name_et);
        String name = nameEditText.getText().toString();

        EditText emailEditText = findViewById(R.id.email_et);
        String email = emailEditText.getText().toString();

        CheckBox whippedCreamCheckBox = findViewById(R.id.whipped_cream_checked);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        CheckBox chocolateCheckBox = findViewById(R.id.chocolate_checked);
        boolean hasChocolate = chocolateC