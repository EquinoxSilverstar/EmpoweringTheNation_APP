package com.example.etn

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SixWeeksActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_six_weeks)

            val linkTextView: TextView = findViewById(R.id.linkTextView)
            linkTextView.setOnClickListener {
                val intent = Intent(this, ChildMinding::class.java)
                startActivity(intent)
            }
            val linkTextView2 : TextView = findViewById(R.id.linkTextView2)
                linkTextView2.setOnClickListener {
                    val intent2 = Intent(this, CookingCourse::class.java)
                    startActivity(intent2)
                }
            val linkTextView3 : TextView = findViewById(R.id.linkTextView3)
             linkTextView3.setOnClickListener {
                    val intent3 = Intent(this, GardenCourse::class.java)
                    startActivity(intent3)
        }


    }
}