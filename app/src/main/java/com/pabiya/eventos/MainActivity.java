package com.pabiya.eventos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView cambio, touch,longClick;
    EditText focus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cambio=findViewById(R.id.textCam);
        touch =findViewById(R.id.touch);
        longClick=findViewById(R.id.longClick);
        focus=findViewById(R.id.focus);

        touch.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        cambio.setText("Has actibado Touch");
                    break;
                        case MotionEvent.ACTION_MOVE:
                        cambio.setText("Has movido touch");
                        break;
                    case MotionEvent.ACTION_UP:
                        cambio.setText("Has desactivado touch");
                        break;

                }
                return true;
            }
        });
        longClick.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                cambio.setText("mantiene pulsado");
                return true;
            }
        });
        focus.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b){
                    cambio.setText("on focus");
                }else{
                    cambio.setText("off focus");
                }
            }
        });

    }
}