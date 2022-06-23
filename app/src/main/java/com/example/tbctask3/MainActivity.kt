package com.example.tbctask3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var clearBtn: Button
    private lateinit var saveBtn: Button
    private lateinit var profileInfo: TextView
    private lateinit var email: EditText
    private lateinit var username: EditText
    private lateinit var firstName: EditText
    private lateinit var lastName: EditText
    private lateinit var age: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clearBtn = findViewById(R.id.clearBtn)
        saveBtn = findViewById(R.id.saveBtn)
        profileInfo = findViewById(R.id.profileInfo)
        email = findViewById(R.id.email)
        username = findViewById(R.id.username)
        firstName = findViewById(R.id.firstName)
        lastName = findViewById(R.id.lastName)
        age = findViewById(R.id.ageText)

        saveBtn.setOnClickListener {
            if (username.text.length < 10) {
                showToast("username should contain 10 or more symbols ")
                return@setOnClickListener
            }
            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email.text.toString())
                    .matches()
            ) {
                showToast("An invalid email ")
                return@setOnClickListener
            }
            if (email.text.isEmpty() || username.text.isEmpty() || firstName.text.isEmpty() || lastName.text.isEmpty() || age.text.isEmpty()) {
                showToast("please fill in all fields")
                return@setOnClickListener
            }
            if (age.text.toString().contains("-")|| age.text.toString()
                    .contains(".") || age.text.toString().contains(",")
            ) {
                showToast("Age should be positive Integer ")
                return@setOnClickListener
            }
        }

        clearBtn.setOnLongClickListener {
            email.setText("")
            username.setText("")
            firstName.setText("")
            lastName.setText("")
            age.setText("")
            return@setOnLongClickListener true

        }
    }

    private fun showToast(msg: String) {

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }


}

