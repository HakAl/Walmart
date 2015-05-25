package com.jacmobile.productlookup.utils;


import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.ResultReceiver;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.inputmethod.InputMethodManager;
import android.widget.Spinner;

@SuppressWarnings("unchecked")
public class Ui
{
    public static Bitmap createBitmapFromView(View v) {
        Bitmap bitmap = Bitmap.createBitmap(v.getWidth(), v.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        v.layout(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());
        v.draw(canvas);

        return bitmap;
    }

    public static <T extends View> T findView(Activity activity, int resId) {
        return (T) activity.findViewById(resId);
    }

    public static <T extends View> T findView(View view, int resId) {
        return (T) view.findViewById(resId);
    }

    public static <T extends Fragment> T findFragment(FragmentActivity activity, int resId) {
        return (T) activity.getSupportFragmentManager().findFragmentById(resId);
    }

    public static <T extends Fragment> T findFragment(FragmentActivity activity, String tag) {
        return (T) activity.getSupportFragmentManager().findFragmentByTag(tag);
    }

    // Measuring

    public static int[] measureRatio(int widthMeasureSpec, int heightMeasureSpec, double aspectRatio) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = widthMode == MeasureSpec.UNSPECIFIED ? Integer.MAX_VALUE : MeasureSpec
                .getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = heightMode == MeasureSpec.UNSPECIFIED ? Integer.MAX_VALUE : MeasureSpec
                .getSize(heightMeasureSpec);

        int measuredWidth;
        int measuredHeight;

        if (heightMode == MeasureSpec.EXACTLY && widthMode == MeasureSpec.EXACTLY) {
            measuredWidth = widthSize;
            measuredHeight = heightSize;

        }
        else if (heightMode == MeasureSpec.EXACTLY) {
            measuredWidth = (int) Math.min(widthSize, heightSize * aspectRatio);
            measuredHeight = (int) (measuredWidth / aspectRatio);

        }
        else if (widthMode == MeasureSpec.EXACTLY) {
            measuredHeight = (int) Math.min(heightSize, widthSize / aspectRatio);
            measuredWidth = (int) (measuredHeight * aspectRatio);

        }
        else {
            if (widthSize > heightSize * aspectRatio) {
                measuredHeight = heightSize;
                measuredWidth = (int) (measuredHeight * aspectRatio);
            }
            else {
                measuredWidth = widthSize;
                measuredHeight = (int) (measuredWidth / aspectRatio);
            }

        }

        return new int[] { measuredWidth, measuredHeight };
    }

    // Spinners

    public static void setSelection(Spinner spinner, Object selection) {
        setSelection(spinner, selection.toString());
    }

    public static void setSelection(Spinner spinner, String selection) {
        final int count = spinner.getCount();
        for (int i = 0; i < count; i++) {
            String item = spinner.getItemAtPosition(i).toString();
            if (item.equalsIgnoreCase(selection)) {
                spinner.setSelection(i);
            }
        }
    }

    // Keyboard

    public static void hideSoftKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void showSoftkeyboard(View view) {
        showSoftkeyboard(view, null);
    }

    public static void showSoftkeyboard(View view, ResultReceiver resultReceiver) {
        Configuration config = view.getContext().getResources().getConfiguration();
        if (config.hardKeyboardHidden == Configuration.HARDKEYBOARDHIDDEN_YES) {
            InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(
                    Context.INPUT_METHOD_SERVICE);

            if (resultReceiver != null) {
                imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT, resultReceiver);
            }
            else {
                imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
            }
        }
    }
}