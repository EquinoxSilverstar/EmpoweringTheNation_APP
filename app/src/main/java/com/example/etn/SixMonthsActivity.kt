package com.example.etn

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class SixMonthsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sixmonths)

        val linkTextView: TextView = findViewById(R.id.linkTextViewM)
        linkTextView.setOnClickListener {
            val intent = Intent(this, FirstAid::class.java)
            startActivity(intent)
        }
        val linkTextView2 : TextView = findViewById(R.id.linkTextViewM2)
        linkTextView2.setOnClickListener {
            val intent2 = Intent(this, Sewing::class.java)
            startActivity(intent2)
        }
        val linkTextView3 : TextView = findViewById(R.id.linkTextViewM3)
        linkTextView3.setOnClickListener {
            val intent3 = Intent(this, Landscaping::class.java)
            startActivity(intent3)
        }
        val linkTextView4 : TextView = findViewById(R.id.linkTextViewM4)
        linkTextView4.setOnClickListener {
            val intent4 = Intent(this, LifeSkills::class.java)
            startActivity(intent4)
        }
    }
}