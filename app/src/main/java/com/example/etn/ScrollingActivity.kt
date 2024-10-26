package com.example.etn

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class ScrollingActivity : AppCompatActivity() {

    private lateinit var monthCourse: VideoView
    private lateinit var weekCourse: VideoView
    private lateinit var imageView6: VideoView
    private lateinit var buttonCourse: View
    private lateinit var buttonCourse2: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)

        // Initialize views
        monthCourse = findViewById(R.id.monthCourse)
        weekCourse = findViewById(R.id.weekCourse)
        imageView6 = findViewById(R.id.imageView6)
        buttonCourse = findViewById(R.id.buttonCourse)
        buttonCourse2 = findViewById(R.id.buttonCourse2)

        // Video setup for Month Course
        val videoUri = Uri.parse("android.resource://${packageName}/${R.raw.firstaid2}")
        monthCourse.setVideoURI(videoUri)
        monthCourse.requestFocus()
        monthCourse.start()
        monthCourse.setOnCompletionListener { monthCourse.start() }

        // Video setup for Week Course
        val videoUri2 = Uri.parse("android.resource://${packageName}/${R.raw.childminding}")
        weekCourse.setVideoURI(videoUri2)
        weekCourse.requestFocus()
        weekCourse.start()
        weekCourse.setOnCompletionListener { weekCourse.start() }

        // Video setup for Hero video
        val videoUri3 = Uri.parse("android.resource://${packageName}/${R.raw.hero}")
        imageView6.setVideoURI(videoUri3)
        imageView6.requestFocus()
        imageView6.start()
        imageView6.setOnCompletionListener { imageView6.start() }

        // Button click listeners for course navigation
        buttonCourse.setOnClickListener {
            val intent = Intent(this, SixMonthsActivity::class.java)
            startActivity(intent)
        }

        buttonCourse2.setOnClickListener {
            val intent = Intent(this, SixWeeksActivity::class.java)
            startActivity(intent)
        }
    }
}