package com.example.notstackoverflow

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.editText)
        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)

        button1.setOnClickListener {
            val seconds = editText.text.toString().toIntOrNull()
            if (seconds != null && seconds > 0) {
                val intent = Intent(this, TimerActivity::class.java)
                intent.putExtra("seconds", seconds)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Введите положительное число секунд", Toast.LENGTH_SHORT).show()
            }
        }

        button2.setOnClickListener {
            val seconds = editText.text.toString().toIntOrNull()
            if (seconds != null && seconds > 0) {
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_TEXT, seconds.toString())
                startActivity(Intent.createChooser(intent, "Отправить число"))
            } else {
                Toast.makeText(this, "Введите положительное число секунд", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
