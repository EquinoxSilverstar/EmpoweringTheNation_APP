package com.example.etn.ui.sixmonths

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.etn.FirstAid
import com.example.etn.Landscaping
import com.example.etn.LifeSkills
import com.example.etn.Sewing
import com.example.etn.databinding.FragmentSixmonthsBinding

class SixMonthsFragment : Fragment() {

    private var _binding: FragmentSixmonthsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSixmonthsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Set click listeners for each TextView
        binding.linkTextViewM.setOnClickListener {
            startActivity(Intent(requireContext(), FirstAid::class.java))
        }

        binding.linkTextViewM2.setOnClickListener {
            startActivity(Intent(requireContext(), Sewing::class.java))
        }

        binding.linkTextViewM3.setOnClickListener {
            startActivity(Intent(requireContext(), Landscaping::class.java))
        }

        binding.linkTextViewM4.setOnClickListener {
            startActivity(Intent(requireContext(), LifeSkills::class.java))
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
