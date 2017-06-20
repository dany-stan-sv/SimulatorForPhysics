package ru.dany.physics;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Администратор on 12.06.2017.
 */

public class PressureQuest001 extends AppCompatActivity {

    Button buttonOk;
    boolean flagText1 = false;
    boolean flagText2 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.typequest002);

        setTitle (MainActivity.selectionTheme);

        //заголовок и высказывание
        TextView textQuest = (TextView) findViewById(R.id.selection);
        TextView textUtterance = (TextView) findViewById(R.id.textView1);
        TextView textNumber1 = (TextView) findViewById(R.id.textView2);
        TextView textNumber2 = (TextView) findViewById(R.id.textView3);

        textQuest.setText("Вставьте в высказывание пропущенные слова");
        textUtterance.setText("Внутри жидкости существует давление и на одном и том же уровне оно (1) по всем направлениям. С глубиной давление (2)");
        textNumber1.setText("1)");
        textNumber2.setText("2)");

        EditText editText1 = (EditText)findViewById(R.id.editText1);
        EditText editText2 = (EditText)findViewById(R.id.editText2);

        editText1.addTextChangedListener(new TextWatcher(){
            @Override
            public void afterTextChanged(Editable s) {
                // Прописываем то, что надо выполнить после изменения текста
                flagText1 = s.toString().equals("ОДИНАКОВО");
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
        editText2.addTextChangedListener(new TextWatcher(){
            @Override
            public void afterTextChanged(Editable s) {
                // Прописываем то, что надо выполнить после изменения текста
                flagText2 = s.toString().equals("УВЕЛИЧИВАЕТСЯ");
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });

        //создаем обработчик кнопки
        buttonOk = (Button) findViewById(R.id.button_ok);
        View.OnClickListener ok = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flagText1 && flagText2) {
                    Intent intent = new Intent(PressureQuest001.this, PressureQuest002.class);
                    startActivity(intent);
                }
            }
        };
        buttonOk.setOnClickListener(ok);
    }
}
