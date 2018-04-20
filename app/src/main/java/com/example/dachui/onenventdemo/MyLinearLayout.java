package com.example.dachui.onenventdemo;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * <p>描述：自定义LinearLayout 验证事件分发</p>
 * 作者： liujiyi<br>
 * 日期： 2018/4/20<br>
 */
public class MyLinearLayout extends LinearLayout {
    private static final String TAG = MyLinearLayout.class.getSimpleName();

    public MyLinearLayout(Context context) {
        super(context);
    }

    public MyLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * return super: 不消费事件 调用自己的onInterceptTouchEvent
     * <p>
     * return false:不消费事件 调用上级的onTouchEvent
     * 04-20 11:06:29.464 29192-29192/com.example.dachui.onenventdemo E/MainActivity: dispatchTouchEvent ACTION_DOWN
     * 04-20 11:06:29.464 29192-29192/com.example.dachui.onenventdemo E/MyLinearLayout: dispatchTouchEvent ACTION_DOWN
     * 04-20 11:06:29.464 29192-29192/com.example.dachui.onenventdemo E/MainActivity: onTouchEvent ACTION_DOWN
     * <p>
     * return true: 消费事件 事件不再传递
     * 04-20 11:06:31.464 29192-29192/com.example.dachui.onenventdemo E/MainActivity: dispatchTouchEvent ACTION_DOWN
     * 04-20 11:06:31.464 29192-29192/com.example.dachui.onenventdemo E/MyLinearLayout: dispatchTouchEvent ACTION_DOWN
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
    }

    /**
     * return super || false: 不消费事件 调用下级的dispatchTouchEvent
     * 04-20 11:14:08.324 6221-6221/com.example.dachui.onenventdemo E/MainActivity: dispatchTouchEvent ACTION_DOWN
     * 04-20 11:14:08.324 6221-6221/com.example.dachui.onenventdemo E/MyLinearLayout: dispatchTouchEvent ACTION_DOWN
     * 04-20 11:14:08.324 6221-6221/com.example.dachui.onenventdemo E/MyLinearLayout: onInterceptTouchEvent ACTION_DOWN
     * 04-20 11:14:08.324 6221-6221/com.example.dachui.onenventdemo E/MyButton: dispatchTouchEvent ACTION_DOWN
     * 04-20 11:14:08.324 6221-6221/com.example.dachui.onenventdemo E/MainActivity: onTouch ACTION_DOWN
     * <p>
     * return true: 消费事件 调用自己的onTouchEvent
     * 04-20 11:22:57.124 16635-16635/com.example.dachui.onenventdemo E/MainActivity: dispatchTouchEvent ACTION_DOWN
     * 04-20 11:22:57.124 16635-16635/com.example.dachui.onenventdemo E/MyLinearLayout: dispatchTouchEvent ACTION_DOWN
     * 04-20 11:22:57.124 16635-16635/com.example.dachui.onenventdemo E/MyLinearLayout: onInterceptTouchEvent ACTION_DOWN
     * 04-20 11:22:57.124 16635-16635/com.example.dachui.onenventdemo E/MyLinearLayout: onTouchEvent ACTION_DOWN
     * 04-20 11:22:57.124 16635-16635/com.example.dachui.onenventdemo E/MainActivity: onTouchEvent ACTION_DOWN
     *
     * @param event
     * @return
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "onInterceptTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG, "onInterceptTouchEvent ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "onInterceptTouchEvent ACTION_UP");
                break;
            default:
                break;
        }

        return super.onInterceptTouchEvent(event);
//        return false;
//        return true;
    }

    /**
     * return super||false:不消费事件 调用上级的onTouchEvent
     * 04-20 11:14:08.324 6221-6221/com.example.dachui.onenventdemo E/MainActivity: dispatchTouchEvent ACTION_DOWN
     * 04-20 11:14:08.324 6221-6221/com.example.dachui.onenventdemo E/MyLinearLayout: dispatchTouchEvent ACTION_DOWN
     * 04-20 11:14:08.324 6221-6221/com.example.dachui.onenventdemo E/MyLinearLayout: onInterceptTouchEvent ACTION_DOWN
     * 04-20 11:14:08.324 6221-6221/com.example.dachui.onenventdemo E/MyButton: dispatchTouchEvent ACTION_DOWN
     * 04-20 11:14:08.324 6221-6221/com.example.dachui.onenventdemo E/MainActivity: onTouch ACTION_DOWN
     * 04-20 11:14:08.324 6221-6221/com.example.dachui.onenventdemo E/MyButton: onTouchEvent ACTION_DOWN
     * 04-20 11:14:08.324 6221-6221/com.example.dachui.onenventdemo E/MyLinearLayout: onTouchEvent ACTION_DOWN
     * 04-20 11:14:08.324 6221-6221/com.example.dachui.onenventdemo E/MainActivity: onTouchEvent ACTION_DOWN
     * <p>
     * return true: 消费事件  事件不再传递
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
