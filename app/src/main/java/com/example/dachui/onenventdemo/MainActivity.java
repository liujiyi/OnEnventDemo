package com.example.dachui.onenventdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyButton btn = (MyButton) findViewById(R.id.btn);

        /**
         * 这里return ture 表示消费了事件 事件不再往下传递（即onTouchEvent不再调用）
         * return false  表示不消费事件 事件继续往下传递
         */
        btn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();

                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        Log.e(TAG, "onTouch ACTION_DOWN");
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Log.e(TAG, "onTouch ACTION_MOVE");
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.e(TAG, "onTouch ACTION_UP");
                        break;
                    default:
                        break;
                }
                return false;
            }
        });

        //设置btn是否可以点击
        //如果可以点击的话 说明消费了事件 btn执行onTouchEvent后如果return super，事件不再传递
        btn.setClickable(false);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.e(TAG, "onClick");
//            }
//        });
    }

    /**
     * return true||false: 事件都不再往下传递
     * 04-20 11:28:58.884 23955-23955/com.example.dachui.onenventdemo E/MainActivity: dispatchTouchEvent ACTION_DOWN
     * 04-20 11:28:58.894 23955-23955/com.example.dachui.onenventdemo E/MainActivity: dispatchTouchEvent ACTION_MOVE
     * 04-20 11:28:58.904 23955-23955/com.example.dachui.onenventdemo E/MainActivity: dispatchTouchEvent ACTION_MOVE
     * 04-20 11:28:58.904 23955-23955/com.example.dachui.onenventdemo E/MainActivity: dispatchTouchEvent ACTION_UP
     *
     * return super：事件向下传递
     * @param event
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "dispatchTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG, "dispatchTouchEvent ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "dispatchTouchEvent ACTION_UP");
                break;
            default:
                break;
        }
        return super.dispatchTouchEvent(event);
//        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "onTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG, "onTouchEvent ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "onTouchEvent ACTION_UP");
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }
}
