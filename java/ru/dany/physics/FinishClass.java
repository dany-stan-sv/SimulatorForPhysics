package ru.dany.physics;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Администратор on 16.06.2017.
 */

public class FinishClass extends AppCompatActivity {

    String themeName = MainActivity.selectionTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.finishclass);

        setTitle (themeName);
    }

    public void click (View view) {
        Intent intent = new Intent(FinishClass.this, MainActivity.class);
        startActivity(intent);
    }
}
