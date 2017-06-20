package ru.dany.physics;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    String theme1 = "Первоначальные сведения о строении вещества";
    String theme2 = "Давление твёрдых тел, жидкостей и газов";
    public static String selectionTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.header);

        // setTitle("");

        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);

        button1.setText(theme1);
        button2.setText(theme2);

        //создаем обработчик кнопки1
        View.OnClickListener but1 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectionTheme = theme1;
                Intent intent = new Intent(MainActivity.this, DiffusionQuest001.class);
                startActivity(intent);
            }
        };
        button1.setOnClickListener(but1);

        //создаем обработчик кнопки2
        View.OnClickListener but2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectionTheme = theme2;
                Intent intent = new Intent(MainActivity.this, PressureQuest001.class);
                startActivity(intent);
            }
        };
        button2.setOnClickListener(but2);
    }
}