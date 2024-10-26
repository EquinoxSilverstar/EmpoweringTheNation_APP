package com.example.etn.ui.sixweeks

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.etn.R
import com.example.etn.ChildMinding
import com.example.etn.CookingCourse
import com.example.etn.GardenCourse
import com.example.etn.databinding.FragmentSixweeksBinding

class SixWeeksFragment : Fragment() {

    private var _binding: FragmentSixweeksBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSixweeksBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Set up TextView click listeners to navigate to respective activities
        val linkTextView: TextView = binding.root.findViewById(R.id.linkTextView)
        linkTextView.setOnClickListener {
            val intent = Intent(requireContext(), ChildMinding::class.java)
            startActivity(intent)
        }

        val linkTextView2: TextView = binding.root.findViewById(R.id.linkTextView2)
        linkTextView2.setOnClickListener {
            val intent = Intent(requireContext(), CookingCourse::class.java)
            startActivity(intent)
        }

        val linkTextView3: TextView = binding.root.findViewById(R.id.linkTextView3)
        linkTextView3.setOnClickListener {
            val intent = Intent(requireContext(), GardenCourse::class.java)
            startActivity(intent)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
