package ru.dany.physics;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.view.View.OnClickListener;
import android.widget.TextView;

/**
 * Created by Администратор on 12.06.2017.
 */

public class PressureQuest006 extends AppCompatActivity {

    Button buttonOk;
    boolean flag1 = true;
    boolean flag2 = true;
    boolean flag3 = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.typequest003);

        setTitle (MainActivity.selectionTheme);

        TextView textQuest = (TextView) findViewById(R.id.selection);
        textQuest.setText("Отметьте те картинки, на которых изображены устройства, действие которых основано на Законе Паскаля");

        //загрузка картинок
        ImageButton iB1 = (ImageButton) findViewById(R.id.imageButton1);
        ImageButton iB2 = (ImageButton) findViewById(R.id.imageButton2);
        ImageButton iB3 = (ImageButton) findViewById(R.id.imageButton3);

        iB1.setImageResource(R.mipmap.brake);
        iB2.setImageResource(R.mipmap.jack_vint);
        iB3.setImageResource(R.mipmap.jack);

        //агрузка галочек на каждую
        final ImageView iv1 = (ImageView) findViewById(R.id.imageView1);
        final ImageView iv2 = (ImageView) findViewById(R.id.imageView2);
        final ImageView iv3 = (ImageView) findViewById(R.id.imageView3);
        iv2.setImageResource(R.mipmap.otmetka_off);
        iv1.setImageResource(R.mipmap.otmetka_off);
        iv3.setImageResource(R.mipmap.otmetka_off);

        //создание метода переключения галочки
        iB1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (flag1) {iv1.setImageResource(R.mipmap.otmetka_on);}
                else {iv1.setImageResource(R.mipmap.otmetka_off);}
                flag1 = !flag1;
            }
        });
        iB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag2) {iv2.setImageResource(R.mipmap.otmetka_on);}
                else {iv2.setImageResource(R.mipmap.otmetka_off);}
                flag2 = !flag2;
            }
        });
        iB3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag3) {iv3.setImageResource(R.mipmap.otmetka_on);}
                else {iv3.setImageResource(R.mipmap.otmetka_off);}
                flag3 = !flag3;
            }
        });

        //создаем обработчик кнопки
        buttonOk = (Button) findViewById(R.id.button_ok);
        View.OnClickListener ok = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!flag1 && flag2 && !flag3) {
                    Intent intent = new Intent(PressureQuest006.this, FinishClass.class);
                    startActivity(intent);
                }
            }
        };
        buttonOk.setOnClickListener(ok);
    }
}
