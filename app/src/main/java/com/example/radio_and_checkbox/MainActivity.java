package com.example.radio_and_checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {


    CheckBox checkBox_1,checkBox_2,checkBox_3;
    RadioGroup radioGroup;
    TextView textView,hobby;
    String hobbys;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup=findViewById(R.id.group_1);
        textView=findViewById(R.id.text2);
        hobby=findViewById(R.id.text3);
        hobbys=new String();
        checkBox_1=findViewById(R.id.box_1);
        checkBox_2=findViewById(R.id.box_2);
        checkBox_3=findViewById(R.id.box_3);
        checkBox_1.setOnCheckedChangeListener(this);
        checkBox_2.setOnCheckedChangeListener(this);
        checkBox_3.setOnCheckedChangeListener(this);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton=findViewById(i);
                if (i==R.id.button_1){
                    textView.setText("您的性别为男");
                }
                else{
                    textView.setText("您选择的性别是女");
                }
                    //textView.setText("您选择的性别是:");
                    //textView.setText(textView.getText()+radioButton.getText().toString());

                Toast.makeText(MainActivity.this, textView.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        String text_box=compoundButton.getText().toString();
        if (b){
            if (!hobbys.contains(text_box)) {
                hobbys = hobbys + text_box;
                hobby.setText("选择的爱好有"+hobbys);
                Toast.makeText(this, "执行成功1", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            if (hobbys.contains(text_box)){
                hobbys=hobbys.replace(text_box,"");
                hobby.setText("选择的爱好有"+hobbys);
                Toast.makeText(MainActivity.this,"执行成功2",Toast.LENGTH_SHORT).show();
            }
        }
    }
}