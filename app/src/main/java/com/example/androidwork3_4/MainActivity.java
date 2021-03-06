package com.example.androidwork3_4;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);

        setContentView(R.layout.activity_main);
        Button buttonOk = findViewById(R.id.ok);
        final Spinner spinner = findViewById(R.id.spinner);
        final Spinner spinnerColor = findViewById(R.id.spinnerColor);

        ArrayAdapter<?> adapter = ArrayAdapter.createFromResource(this, R.array.local, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        ArrayAdapter<?> adapterColor =
                ArrayAdapter.createFromResource(this, R.array.color, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerColor.setAdapter(adapterColor);



        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selected = (String) spinner.getSelectedItem();
                switch (selected) {
                    case ("Английский"):
                        createLocal("en");
                        break;
                    case ("Russian"):
                        createLocal("ru");
                        break;
                }
                String selectedColor = (String) spinnerColor.getSelectedItem();
                switch (selectedColor) {
                    case ("Зеленый"):
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_DEFAULT);
                        break;
                    case ("Фиолетовый"):
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_VIOLET);
                        break;
                    case ("Синий"):
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_BLUE);
                        break;
                    case ("Green"):
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_DEFAULT);
                        break;
                    case ("Violet"):
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_VIOLET);
                        break;
                    case ("Blue"):
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_BLUE);
                        break;
                }
            }
        });
    }
    void createLocal(String local) {
        Configuration config = new Configuration();
        config.locale = new Locale(local);
        getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        recreate();
    }
}