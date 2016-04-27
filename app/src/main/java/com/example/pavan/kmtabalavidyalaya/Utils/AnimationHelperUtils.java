package com.example.pavan.kmtabalavidyalaya.Utils;




import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;


/**
 * Created by kai on 26/4/16.
 */
public class AnimationHelperUtils {

    public static boolean isLollipop() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static void statusBarColorTransition(int newclr, int duration, Context mContext) {

        if (!isLollipop())
            return;

        final Window window = ((Activity) mContext).getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        int oldclr = window.getStatusBarColor();

        ValueAnimator anim = ValueAnimator.ofArgb(oldclr, newclr);
        anim.setDuration(duration);

        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                window.setStatusBarColor((int) animation.getAnimatedValue());
            }
        });

        anim.start();

    }
}
