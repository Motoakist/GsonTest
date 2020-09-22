package com.example.gsontest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.JsonWriter;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private boolean flag = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // flagがtrueの時
                if (flag) {
                    textView.setText("Hello");
                    flag = false;
                    JsonWriter writer;
                    try {
                        writer = new JsonWriter(new FileWriter("../../test.json"));

                        writer.beginObject();//{
                        writer.name("name").value("mkyong");//"name" : "mkyong"
                        writer.name("age").value(29);//"age" : 29
                        writer.name("messages");//"messages" :
                        writer.beginArray();//[    writer.value("msg 1");//"msg 1"
                        writer.value("msg 2");//"msg 2"
                        writer.value("msg 3");//"msg 3"
                        writer.endArray();//]
                        writer.endObject();//}
                        writer.close();

                        System.out.println("Done");
                    } catch (
                            IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    textView.setText("world");
                    flag = true;
                }
            }
        });
    }
}
