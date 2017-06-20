package ru.dany.physics;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String themeName1, themeName2;
    public static String selectionTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.header);

        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);

        ArrayList<String> list = new ArrayList<>();

        try {
            XmlPullParser parser = getResources().getXml(R.xml.data);

            while (parser.getEventType() != XmlPullParser.END_DOCUMENT) {
                if (parser.getEventType() == XmlPullParser.START_TAG
                        && parser.getName().equals("theme")) {

                    if (parser.getAttributeValue(0).equals("1")){themeName1 = parser.getAttributeValue(1);}
                    if (parser.getAttributeValue(0).equals("2")){themeName2 = parser.getAttributeValue(1);}
                }

                parser.next();
            }
        } catch (Throwable t) {
            Toast.makeText(this,
                    "Ошибка при загрузке XML-документа: " + t.toString(), Toast.LENGTH_LONG)
                    .show();
        }

        button1.setText(themeName1);
        button2.setText(themeName2);

        //создаем обработчик кнопки1
        button1 = (Button) findViewById(R.id.button1);
        View.OnClickListener but1 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectionTheme=themeName1;
                Intent intent = new Intent(MainActivity.this, FinishClass.class);
                startActivity(intent);
            }
        };
        button1.setOnClickListener(but1);

        //создаем обработчик кнопки2
        button2 = (Button) findViewById(R.id.button2);
        View.OnClickListener but2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectionTheme=themeName2;
                Intent intent = new Intent(MainActivity.this, FinishClass.class);
                startActivity(intent);
            }
        };
        button2.setOnClickListener(but2);
    }
}