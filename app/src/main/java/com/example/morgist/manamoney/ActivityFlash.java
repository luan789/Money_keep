package com.example.morgist.manamoney;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class ActivityFlash extends Activity {

    ImageView img;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_flash);

        img = findViewById(R.id.layout_flash_icon);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.ani_flash);
        img.setAnimation(animation);
        new CountDownTimer(3000, 3000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(ActivityFlash.this, ActivityLogin.class);
                startActivity(intent);
                finish();
            }
        }.start();

    }
}
