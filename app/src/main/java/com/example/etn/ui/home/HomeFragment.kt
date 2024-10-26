package com.example.etn.ui.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.etn.R
import com.example.etn.SixMonthsActivity
import com.example.etn.SixWeeksActivity
import com.example.etn.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Video setup for Month Course
        val videoView = binding.monthCourse
        val videoUri = Uri.parse("android.resource://" + requireContext().packageName + "/" + R.raw.firstaid2)
        videoView.setVideoURI(videoUri)
        videoView.requestFocus()
        videoView.start()
        videoView.setOnCompletionListener { videoView.start() }

        // Video setup for Week Course
        val videoView2 = binding.weekCourse
        val videoUri2 = Uri.parse("android.resource://" + requireContext().packageName + "/" + R.raw.childminding)
        videoView2.setVideoURI(videoUri2)
        videoView2.requestFocus()
        videoView2.start()
        videoView2.setOnCompletionListener { videoView2.start() }

        // Video setup for Hero video
        val videoView3 = binding.imageView6
        val videoUri3 = Uri.parse("android.resource://" + requireContext().packageName + "/" + R.raw.hero)
        videoView3.setVideoURI(videoUri3)
        videoView3.requestFocus()
        videoView3.start()
        videoView3.setOnCompletionListener { videoView3.start() }

        // Button click listeners for course navigation
        binding.buttonCourse.setOnClickListener {
            val intent = Intent(activity, SixMonthsActivity::class.java)
            startActivity(intent)
        }

        binding.buttonCourse2.setOnClickListener {
            val intent = Intent(activity, SixWeeksActivity::class.java)
            startActivity(intent)
        }

        return root
    }

    override fun onPause() {
        super.onPause()

        // Stop all videos and replace with fallback images
        binding.monthCourse.stopPlayback()
        binding.monthCourse.visibility = View.GONE
        binding.monthImage.setImageResource(R.drawable.firstaid) // Replace with actual image resource
        binding.monthImage.visibility = View.VISIBLE

        binding.weekCourse.stopPlayback()
        binding.weekCourse.visibility = View.GONE
        binding.weekImage.setImageResource(R.drawable.childminding) // Replace with actual image resource
        binding.weekImage.visibility = View.VISIBLE

        binding.imageView6.stopPlayback()
        binding.imageView6.visibility = View.GONE
        binding.heroImage.setImageResource(R.drawable.logo) // Replace with actual image resource
        binding.heroImage.visibility = View.VISIBLE
    }

    override fun onResume() {
        super.onResume()

        // Hide images and start videos again
        binding.monthImage.visibility = View.GONE
        binding.monthCourse.visibility = View.VISIBLE
        binding.monthCourse.start()

        binding.weekImage.visibility = View.GONE
        binding.weekCourse.visibility = View.VISIBLE
        binding.weekCourse.start()

        binding.heroImage.visibility = View.GONE
        binding.imageView6.visibility = View.VISIBLE
        binding.imageView6.start()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
