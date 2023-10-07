package com.example.notstackoverflow

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TimerActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var buttonStart: Button
    private lateinit var buttonPause: Button
    private lateinit var buttonReset: Button

    private var timer: CountDownTimer? = null
    private var seconds: Long = 0L
    private var isRunning = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)


        textView = findViewById(R.id.textView)
        buttonStart = findViewById(R.id.buttonStart)
        buttonPause = findViewById(R.id.buttonPause)
        buttonReset = findViewById(R.id.buttonReset)


        seconds = intent.getIntExtra("seconds", 0) * 1000L

        textView.text = formatTime(seconds)

        buttonStart.setOnClickListener {
            if (!isRunning) {
                startTimer()
            }
        }

        buttonPause.setOnClickListener {
            if (isRunning) {
                pauseTimer()
            }
        }

        buttonReset.setOnClickListener {
            resetTimer()
        }
    }

    private fun startTimer() {
        timer = object : CountDownTimer(seconds, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                seconds = millisUntilFinished
                textView.text = formatTime(seconds)
            }

            override fun onFinish() {
                resetTimer()
            }
        }.start()

        isRunning = true

        updateButtons()
    }

    private fun pauseTimer() {
        timer?.cancel()

        isRunning = false

        updateButtons()
    }

    private fun resetTimer() {
        timer?.cancel()

        seconds = intent.getIntExtra("seconds", 0) * 1000L

        textView.text = formatTime(seconds)

        isRunning = false

        updateButtons()
    }

    private fun updateButtons() {
        if (isRunning) {
            buttonStart.isEnabled = false
            buttonPause.isEnabled = true
            buttonReset.isEnabled = false
        } else {
            buttonStart.isEnabled = true
            buttonPause.isEnabled = false
            buttonReset.isEnabled = true
        }
    }

    private fun formatTime(millis: Long): String {
        val minutes = millis / 1000 / 60
        val seconds = millis / 1000 % 60
        return String.format("%02d:%02d", minutes, seconds)
    }
}
