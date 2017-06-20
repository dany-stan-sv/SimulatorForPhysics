package ru.dany.physics;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by Администратор on 12.06.2017.
 */

public class DiffusionQuest004 extends AppCompatActivity {

    Button buttonOk;
    boolean flagSpinner1 = false;
    boolean flagSpinner2 = false;
    boolean flagSpinner3 = false;
    int rightPosition1 = 2;
    int rightPosition2 = 0;
    int rightPosition3 = 1;
    String[] variant = {"лед", "пар", "вода"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.typequest004);

        setTitle (MainActivity.selectionTheme);

        TextView textQuest = (TextView) findViewById(R.id.selection);
        TextView textView1 = (TextView) findViewById(R.id.textView1);
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);

        textQuest.setText("Для каждого агрегатного состояния воды выберите название");
        textView1.setText("жидкое");
        textView2.setText("твердое");
        textView3.setText("газообразное");

        // Настраиваем адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, variant);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Вызываем адаптеры
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);
        spinner3.setAdapter(adapter);

        //при выборе какого-либо варианты flagSpiiner обновляется
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent,
                                       View itemSelected, int selectedItemPosition, long selectedId) {
                flagSpinner1 = (selectedItemPosition == rightPosition1);
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent,
                                       View itemSelected, int selectedItemPosition, long selectedId) {
                flagSpinner2 = (selectedItemPosition == rightPosition2);
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent,
                                       View itemSelected, int selectedItemPosition, long selectedId) {
                flagSpinner3 = (selectedItemPosition == rightPosition3);
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        //создаем обработчик кнопки
        buttonOk = (Button) findViewById(R.id.button_ok);
        View.OnClickListener ok = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flagSpinner1 && flagSpinner2 && flagSpinner3) {
                    Intent intent = new Intent(DiffusionQuest004.this, DiffusionQuest005.class);
                    startActivity(intent);
                }
            }
        };
        buttonOk.setOnClickListener(ok);
    }
}