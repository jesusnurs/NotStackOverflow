package com.example.notstackoverflow

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.layout);
        var helloTextView:TextView = findViewById(R.id.hello_name);
        var name = getString(R.string.name)
        helloTextView.setText("Hello, my name is ${name}");
    }
}
