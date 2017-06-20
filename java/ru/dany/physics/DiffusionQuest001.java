package ru.dany.physics;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by Администратор on 12.06.2017.
 */

public class DiffusionQuest001 extends AppCompatActivity {

    Button buttonOk;
    boolean flagMCheckBox1 = true;
    boolean flagMCheckBox2 = false;
    boolean flagMCheckBox3 = false;
    boolean flagMCheckBox4 = false;
    boolean flagMCheckBox5 = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.typequest001);

        setTitle (MainActivity.selectionTheme);

        //переменные для текста чекбокса
        TextView textQuest = (TextView) findViewById(R.id.selection);
        CheckBox mCheckBox1 = (CheckBox) findViewById(R.id.checkBox1);
        CheckBox mCheckBox2 = (CheckBox) findViewById(R.id.checkBox2);
        CheckBox mCheckBox3 = (CheckBox) findViewById(R.id.checkBox3);
        CheckBox mCheckBox4 = (CheckBox) findViewById(R.id.checkBox4);
        CheckBox mCheckBox5 = (CheckBox) findViewById(R.id.checkBox5);
        //присваиваем текст
        textQuest.setText("Выберите несколько верных утверждений");
        mCheckBox1.setText("Диффузия - это физическая величина");
        mCheckBox2.setText("Все тела состоят из молекул");
        mCheckBox3.setText("При увеличении температуры вещества, увеличивается скорость движения молекул");
        mCheckBox4.setText("Промежутки между молекулами вещества в твёрдом состоянии меньше, чем в жидком");
        mCheckBox5.setText("Молекулы в газах движутся, а в твёрдых телах и в жидкостях находятся в покое");

        //создаем обработчики чекбоксов
        View.OnClickListener check1 = new View.OnClickListener() {
            @Override
            public void onClick(View v) { flagMCheckBox1 = !flagMCheckBox1;}        };
        View.OnClickListener check2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) { flagMCheckBox2 = !flagMCheckBox2;}        };
        View.OnClickListener check3 = new View.OnClickListener() {
            @Override
            public void onClick(View v) { flagMCheckBox3 = !flagMCheckBox3;}        };
        View.OnClickListener check4 = new View.OnClickListener() {
            @Override
            public void onClick(View v) { flagMCheckBox4 = !flagMCheckBox4;}        };
        View.OnClickListener check5 = new View.OnClickListener() {
            @Override
            public void onClick(View v) { flagMCheckBox5 = !flagMCheckBox5;}        };

        //скармливаем их переменным
        mCheckBox1.setOnClickListener(check1);
        mCheckBox2.setOnClickListener(check2);
        mCheckBox3.setOnClickListener(check3);
        mCheckBox4.setOnClickListener(check4);
        mCheckBox5.setOnClickListener(check5);

        //создаем обработчик кнопки
        buttonOk = (Button) findViewById(R.id.button_ok);
        View.OnClickListener ok = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flagMCheckBox1 && flagMCheckBox2 && flagMCheckBox3 && flagMCheckBox4 && flagMCheckBox5) {
                    Intent intent = new Intent(DiffusionQuest001.this, DiffusionQuest002.class);
                    startActivity(intent);
                }
            }
        };
        buttonOk.setOnClickListener(ok);
    }
}
