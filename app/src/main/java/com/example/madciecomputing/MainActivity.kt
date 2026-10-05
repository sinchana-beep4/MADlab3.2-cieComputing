package com.example.madciecomputing

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.graphics.Color

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val cie1 = findViewById<EditText>(R.id.cie1)
        val cie2 = findViewById<EditText>(R.id.cie2)
        val cie3 = findViewById<EditText>(R.id.cie3)
        val aat = findViewById<EditText>(R.id.aat)
        val calc = findViewById<Button>(R.id.calculate)
        val res = findViewById<TextView>(R.id.result)

        calc.setOnClickListener {
            val t1 = cie1.text.toString().toDoubleOrNull()?:0.0
            val t2 = cie2.text.toString().toDoubleOrNull()?:0.0
            val t3 = cie3.text.toString().toDoubleOrNull()?:0.0
            val a = aat.text.toString().toDoubleOrNull()?:0.0

            val tests = listOf(t1, t2, t3)
            val bestTwo = tests.sortedDescending().take(2)
            val avg = (bestTwo[0] + bestTwo[1]) / 2
            val cie = avg + a
            res.text = "CIE Marks: $cie"

            if (cie < 20){
                res.setTextColor(Color.RED)
            } else {
                res.setTextColor(Color.parseColor("#0F6900"))
            }
        }

    }
}