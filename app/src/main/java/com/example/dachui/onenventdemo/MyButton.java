package com.example.dachui.onenventdemo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

/**
 * <p>描述：自定义button 验证事件分发</p>
 * 作者： liujiyi<br>
 * 日期： 2018/4/20<br>
 */
@SuppressLint("AppCompatCustomView")
public class MyButton extends Button {
    private static final String TAG = MyButton.class.getSimpleName();

    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * return super: 不消费事件 调用自己的ontouch--->onTouchEvent
     * <p>
     * return false:不消费事件 调用上级的onTouchEvent
     * 04-20 11:06:29.464 29192-29192/com.example.dachui.onenventdemo E/MainActivity: dispatchTouchEvent ACTION_DOWN
     * 04-20 11:06:29.464 29192-29192/com.example.dachui.onenventdemo E/MyLinearLayout: dispatchTouchEvent ACTION_DOWN
     * 04-20 11:06:29.464 29192-29192/com.example.dachui.onenventdemo E/MyLinearLayout: onInterceptTouchEvent ACTION_DOWN
     * 04-20 11:06:29.464 29192-29192/com.example.dachui.onenventdemo E/MyButton: dispatchTouchEvent ACTION_DOWN
     * 04-20 11:06:29.464 29192-29192/com.example.dachui.onenventdemo E/MyLinearLayout: onTouchEvent ACTION_DOWN
     * 04-20 11:06:29.464 29192-29192/com.example.dachui.onenventdemo E/MainActivity: onTouchEvent ACTION_DOWN
     * <p>
     * return true: 消费事件 事件不再传递
     * 04-20 11:06:31.464 29192-29192/com.example.dachui.onenventdemo E/MainActivity: dispatchTouchEvent ACTION_DOWN
     * 04-20 11:06:31.464 29192-29192/com.example.dachui.onenventdemo E/MyLinearLayout: dispatchTouchEvent ACTION_DOWN
     * 04-20 11:06:31.464 29192-29192/com.example.dachui.onenventdemo E/MyLinearLayout: onInterceptTouchEvent ACTION_DOWN
     * 04-20 11:06:31.464 29192-29192/com.example.dachui.onenventdemo E/MyButton: dispatchTouchEvent ACTION_DOWN
     *
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
//        return true;
//        return false;
    }

    /**
     * return super.onTouchEvent(event):
     * 1、如果view控件不可点击&&没有写setOnClickListener监听 则不消费事件 往上传递onTouchEvent
     * 2、如果view控件可点击||写setOnClickListener监听 则消费事件 不往上传递onTouchEvent
     * <p>
     * return false:  不消费事件 往上传递onTouchEvent
     * 04-20 10:45:34.074 3694-3694/com.example.dachui.onenventdemo E/MainActivity: dispatchTouchEvent ACTION_DOWN
     * 04-20 10:45:34.074 3694-3694/com.example.dachui.onenventdemo E/MyLinearLayout: dispatchTouchEvent ACTION_DOWN
     * 04-20 10:45:34.074 3694-3694/com.example.dachui.onenventdemo E/MyLinearLayout: onInterceptTouchEvent ACTION_DOWN
     * 04-20 10:45:34.074 3694-3694/com.example.dachui.onenventdemo E/MyButton: dispatchTouchEvent ACTION_DOWN
     * 04-20 10:45:34.074 3694-3694/com.example.dachui.onenventdemo E/MainActivity: onTouch ACTION_DOWN
     * 04-20 10:45:34.074 3694-3694/com.example.dachui.onenventdemo E/MyButton: onTouchEvent ACTION_DOWN
     * 04-20 10:45:34.074 3694-3694/com.example.dachui.onenventdemo E/MyLinearLayout: onTouchEvent ACTION_DOWN
     * 04-20 10:45:34.074 3694-3694/com.example.dachui.onenventdemo E/MainActivity: onTouchEvent ACTION_DOWN
     * <p>
     * return ture:  消费事件 不往上传递onTouchEvent
     * 04-20 10:48:05.414 6936-6936/com.example.dachui.onenventdemo E/MainActivity: dispatchTouchEvent ACTION_DOWN
     * 04-20 10:48:05.424 6936-6936/com.example.dachui.onenventdemo E/MyLinearLayout: dispatchTouchEvent ACTION_DOWN
     * 04-20 10:48:05.424 6936-6936/com.example.dachui.onenventdemo E/MyLinearLayout: onInterceptTouchEvent ACTION_DOWN
     * 04-20 10:48:05.424 6936-6936/com.example.dachui.onenventdemo E/MyButton: dispatchTouchEvent ACTION_DOWN
     * 04-20 10:48:05.424 6936-6936/com.example.dachui.onenventdemo E/MainActivity: onTouch ACTION_DOWN
     * 04-20 10:48:05.424 6936-6936/com.example.dachui.onenventdemo E/MyButton: onTouchEvent ACTION_DOWN
     *
     * @param event
     * @return
     */
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
//        return false;
//        return true;
    }
}
