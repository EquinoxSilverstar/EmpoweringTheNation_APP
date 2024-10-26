package com.example.etn

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class PaymentActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.payment_activity)

        val editName = findViewById<EditText>(R.id.secondEditText)
        val editPhone = findViewById<EditText>(R.id.firstEditText)
        val editEmail = findViewById<EditText>(R.id.thirdEditText)
        val textView = findViewById<TextView>(R.id.textView19)
        val checkCooking = findViewById<CheckBox>(R.id.cookingCheckBox)
        val checkChildMinding = findViewById<CheckBox>(R.id.childMindingCheckBox)
        val checkGardenMaintenance = findViewById<CheckBox>(R.id.gardenMaintenceCheckBox)
        val checkFirstAid = findViewById<CheckBox>(R.id.firstAidCheckBox)
        val checkSewing = findViewById<CheckBox>(R.id.sewingCheckBox)
        val checkLandscaping = findViewById<CheckBox>(R.id.landscapingCheckBox)
        val checkLifeSkills = findViewById<CheckBox>(R.id.lifeSkillsCheckBox)

        val calculateBtn = findViewById<Button?>(R.id.FeeButton)

        calculateBtn?.setOnClickListener {
            val name = editName.text.toString()
            val phone = editPhone.text.toString()
            val email = editEmail.text.toString()

            // Validate user input
            if (name.isEmpty() || phone.isEmpty() || email.isEmpty()) {
                if (name.isEmpty()) editName.error = "Please enter your name"
                if (phone.isEmpty()) editPhone.error = "Please enter your phone number"
                if (email.isEmpty()) editEmail.error = "Please enter your email"
                return@setOnClickListener
            }

            // Course selection and fee calculation
            val selectedCourses = mutableListOf<String>()
            var totalFees = 0

            if (checkCooking.isChecked) {
                selectedCourses.add("Cooking - R750")
                totalFees += 750
            }
            if (checkChildMinding.isChecked) {
                selectedCourses.add("Child Minding - R750")
                totalFees += 750
            }
            if (checkGardenMaintenance.isChecked) {
                selectedCourses.add("Garden Maintenance - R750")
                totalFees += 750
            }
            if (checkFirstAid.isChecked) {
                selectedCourses.add("First Aid - R1500")
                totalFees += 1500
            }
            if (checkSewing.isChecked) {
                selectedCourses.add("Sewing - R1500")
                totalFees += 1500
            }
            if (checkLandscaping.isChecked) {
                selectedCourses.add("Landscaping - R1500")
                totalFees += 1500
            }
            if (checkLifeSkills.isChecked) {
                selectedCourses.add("Life Skills - R1500")
                totalFees += 1500
            }

            if (selectedCourses.isEmpty()) {
                Toast.makeText(
                    this,
                    "Please select at least one course.",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            // Discount logic
            val discount = when {
                selectedCourses.size > 3 -> 0.15
                selectedCourses.size == 3 -> 0.10
                selectedCourses.size == 2 -> 0.05
                else -> 0.0
            }

            val discountAmount = totalFees * discount
            val discountedTotal = totalFees - discountAmount

            // VAT calculation (15%)
            val vat = discountedTotal * 0.15
            val finalAmount = discountedTotal + vat

            // Display pop-up dialog with the summary
            showSummaryDialog(
                name,
                phone,
                email,
                selectedCourses,
                totalFees,
                discount,
                finalAmount
            )
            textView.text = "Your application has been submitted"
        }


    }

    private fun showSummaryDialog(
        name: String,
        phone: String,
        email: String,
        selectedCourses: List<String>,
        totalFees: Int,
        discount: Double,
        finalAmount: Double
    ) {
        val builder = AlertDialog.Builder(this)

        // Set up the dialog layout
        val dialogView = layoutInflater.inflate(R.layout.dialog_summary, null)
        builder.setView(dialogView)

        val summaryText = dialogView.findViewById<TextView>(R.id.summaryText)
        val submitButton = dialogView.findViewById<Button>(R.id.submitBtn)
        val exitButton = dialogView.findViewById<ImageButton>(R.id.exitBtn) // Exit button
        val dialog = builder.create()
        // Set the dialog background style
        summaryText.setBackgroundColor(Color.parseColor("#060606"))
        summaryText.setTextColor(Color.WHITE)
        summaryText.text = """
            
        Name: $name
        Phone: $phone
        Email: $email 
        
        Courses selected: 
         ${selectedCourses.joinToString(" \n ")}
        
        Total Fees: R$totalFees
        Discount: ${(discount * 100).toInt()}%
        Final Amount: R${"%.2f".format(finalAmount)}
    """.trimIndent()


        submitButton.setBackgroundResource(R.drawable.round_circle)
        submitButton.setTextColor(Color.WHITE)
        submitButton.setPadding(20, 12, 20, 12)
        submitButton.setOnClickListener {
            Toast.makeText(this, "Thank you for your submission press x to exit", Toast.LENGTH_SHORT).show()

        }

        exitButton.setOnClickListener {
            if (dialog.isShowing) {
                dialog.dismiss()
            } else {
                Toast.makeText(this, "Dialog is already closed", Toast.LENGTH_SHORT).show()
            }
        }

        dialog.show()

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }
}
