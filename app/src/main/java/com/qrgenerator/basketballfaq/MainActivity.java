package com.qrgenerator.basketballfaq;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView faqs = findViewById(R.id.faqs);
        Resources res = getResources();
        String[] questions = res.getStringArray(R.array.questions);
        final String[] answers = res.getStringArray(R.array.answers);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1,questions);
        faqs.setAdapter(adapter);
        faqs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Answer")
                        .setMessage(answers[position])
                        .create().show();
            }
        });
    }
}
