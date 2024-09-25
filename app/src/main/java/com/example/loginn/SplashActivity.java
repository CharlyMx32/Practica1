package com.example.loginn;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private TextView timerTextView;
    private long timeLeftInMillis = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        Button irLogin = findViewById(R.id.irLogin);
        timerTextView = findViewById(R.id.timerTextView);

        // Configura el botón de login para iniciar el temporizador
        irLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startCountDown();
            }
        });
    }

    // Iniciar el contador
    private void startCountDown() {
        // Cambiar a MainActivity cuando el tiempo llegue a 0
        CountDownTimer countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateTimer();
            }

            @Override
            public void onFinish() {
                // Cambiar a MainActivity cuando el tiempo llegue a 0
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }.start();
    }

    // Actualiza el TextView del contador
    private void updateTimer() {
        int seconds = (int) (timeLeftInMillis / 1000);
        timerTextView.setText(String.valueOf(seconds));
    }
}

