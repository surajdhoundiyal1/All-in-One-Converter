package com.geipl.kgtopoundcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private TextView textView4;
    private EditText editText2;
    private EditText editText;
    private Button button2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        textView4 = findViewById(R.id.textView4);
        editText2= findViewById(R.id.editText2);
        editText = findViewById(R.id.editText);
        button2=findViewById(R.id.button2);
        Spinner spinner1 =findViewById(R.id.spinner1);
        Spinner spinner2=findViewById(R.id.spinner2);


        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String ss1 = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String ss2 = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayList<String> ar=new ArrayList<>();
        ar.add("KILOGRAM");
        ar.add("POUND");
        ar.add("METER");
        ar.add("KILOMETER");
        ar.add("CENTIMETER");
        ar.add("MILLIMETER");
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, ar);
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double result=0.0;
                String s1=editText.getText().toString();
                String s2=editText2.getText().toString();
                String ss1=spinner1.getSelectedItem().toString();
                String ss2=spinner2.getSelectedItem().toString();
                if((ss1.equals("KILOGRAM") || ss1.equals("POUND")) && (ss2.equals("KILOGRAM") || ss2.equals("POUND"))) {
                    if (s1.length() > 0 && s2.length() == 0) {
                        double kg = Double.parseDouble(s1);
                        double pound = 2.205 * kg;
                        result = pound;
                        textView4.setText("Your result from Kg to pound is:" + result+"LB");
                    } else if (s2.length() > 0 && s1.length() == 0) {
                        double pound1 = Double.parseDouble(s2);
                        double kg1 = pound1 * 45359237;
                        result = kg1;
                        textView4.setText("Your result from pound to Kg is:" + result+"KG");
                    } else if (s1.length() > 0 && s2.length() > 0) {
                        textView4.setText("OOPs.. you write value both the sides");
                    } else {
                        textView4.setText("Please Enter the value according to your choice");
                    }
                    if (result == 0.0) {
                        Toast.makeText(MainActivity.this, "!!!!ERROR!!!!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Result is :" + result, Toast.LENGTH_SHORT).show();
                    }
                }
                else if((ss1.equals("METER") || ss1.equals("KILOMETER")) && (ss2.equals("KILOMETER") || ss2.equals("METER"))){
                    if (s1.length() > 0 && s2.length() == 0) {
                        double meter = Double.parseDouble(s1);
                        double kilometer =meter/1000;
                        result = kilometer;
                        textView4.setText("Your result from Meter to kilometer is:" + result+"KM");
                    } else if (s2.length() > 0 && s1.length() == 0) {
                        double kilometer = Double.parseDouble(s2);
                        double meter = kilometer * 1000;
                        result = meter;
                        textView4.setText("Your result from kilometer to Meter is:" + result+"M");
                    } else if (s1.length() > 0 && s2.length() > 0) {
                        textView4.setText("OOPs.. you write value both the sides");
                    } else {
                        textView4.setText("Please Enter the value according to your choice");
                    }
                    if (result == 0.0) {
                        Toast.makeText(MainActivity.this, "!!!!ERROR!!!!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Result is :" + result, Toast.LENGTH_SHORT).show();
                    }
                }
                else if((ss1.equals("CENTIMETER") || ss1.equals("MILLIMETER")) && (ss2.equals("MILLIMETER") || ss2.equals("CENTIMETER"))){
                    if (s1.length() > 0 && s2.length() == 0) {
                        double centimeter = Double.parseDouble(s1);
                        double millimeter =centimeter*10;
                        result = millimeter;
                        textView4.setText("Your result from Centimeter to Millimeter is:" + result+"MM");
                    } else if (s2.length() > 0 && s1.length() == 0) {
                        double millimeter = Double.parseDouble(s2);
                        double centimeter = millimeter / 10;
                        result = centimeter;
                        textView4.setText("Your result from Millimeter to Centimeter is:" + result+"CM");
                    } else if (s1.length() > 0 && s2.length() > 0) {
                        textView4.setText("OOPs.. you write value both the sides");
                    } else {
                        textView4.setText("Please Enter the value according to your choice");
                    }
                    if (result == 0.0) {
                        Toast.makeText(MainActivity.this, "!!!!ERROR!!!!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Result is :" + result, Toast.LENGTH_SHORT).show();
                    }
                }
                else if((ss1.equals("CENTIMETER") || ss1.equals("METER")) && (ss2.equals("METER") || ss2.equals("CENTIMETER"))){
                    if (s1.length() > 0 && s2.length() == 0) {
                        double meter = Double.parseDouble(s1);
                        double centimeter =meter*100;
                        result = centimeter;
                        textView4.setText("Your result from Meter to Centimeter is:" + result+"CM");
                    } else if (s2.length() > 0 && s1.length() == 0) {
                        double centimeter = Double.parseDouble(s2);
                        double meter = centimeter / 100;
                        result = meter;
                        textView4.setText("Your result from Centimeter to meter is:" + result+"M");
                    } else if (s1.length() > 0 && s2.length() > 0) {
                        textView4.setText("OOPs.. you write value both the sides");
                    } else {
                        textView4.setText("Please Enter the value according to your choice");
                    }
                    if (result == 0.0) {
                        Toast.makeText(MainActivity.this, "!!!!ERROR!!!!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Result is :" + result, Toast.LENGTH_SHORT).show();
                    }
                }
                else if((ss1.equals("METER") || ss1.equals("MILLIMETER")) && (ss2.equals("MILLIMETER") || ss2.equals("METER"))){
                    if (s1.length() > 0 && s2.length() == 0) {
                        double meter = Double.parseDouble(s1);
                        double millimeter =meter*1000;
                        result = millimeter;
                        textView4.setText("Your result from Meter to Millimeter is:" + result+"MM");
                    } else if (s2.length() > 0 && s1.length() == 0) {
                        double millimeter = Double.parseDouble(s2);
                        double meter = millimeter / 1000;
                        result = meter;
                        textView4.setText("Your result from Millimeter to Meter is:" + result+"M");
                    } else if (s1.length() > 0 && s2.length() > 0) {
                        textView4.setText("OOPs.. you write value both the sides");
                    } else {
                        textView4.setText("Please Enter the value according to your choice");
                    }
                    if (result == 0.0) {
                        Toast.makeText(MainActivity.this, "!!!!ERROR!!!!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Result is :" + result, Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    textView4.setText("Please Choose appropriate calculation.... ");
                }
                //After clicking the button switch the image
                ImageView image=findViewById(R.id.imageView);
                image.setImageResource(R.drawable.img_2);


            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
                editText2.setText("");
            }
        });


    }
}