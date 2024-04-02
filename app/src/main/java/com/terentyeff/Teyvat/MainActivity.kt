package com.terentyeff.Teyvat

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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

        findViewById<Button>(R.id.btnGetWeight)
            .setOnClickListener {
                val str = findViewById<EditText>(R.id.editTextText)
                val strWeight = str.text.toString()

                val toast = Toast.makeText(this, "Введите число. Например: 65.3", Toast.LENGTH_LONG)
                val i = strWeight.toDoubleOrNull()

                if (i != null) {
                    val dWeight = strWeight.toDouble()

                    val strResult  = dWeight * 21.99

                    val strKgResult = strResult * 0.1019716213

                    findViewById<TextView>(R.id.textViewKg).setText("Результат: " + String.format("%.2f", strKgResult) + "Кг")
                } else {
                    toast.show()
                }
            }

        findViewById<Button>(R.id.btnAbout)
            .setOnClickListener {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent);
                }
            }
    }