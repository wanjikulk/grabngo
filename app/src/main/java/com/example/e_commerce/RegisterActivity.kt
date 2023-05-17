package com.example.e_commerce

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import android.app.ProgressDialog
import android.widget.TextView

class RegisterActivity : AppCompatActivity() {
    private lateinit var edtName: EditText
    private lateinit var edtEmail: EditText
    private lateinit var edtPhone: EditText
    private lateinit var edtPassword1: EditText
    private lateinit var edtPassword2: EditText
    private lateinit var btnRegister: Button
    private lateinit var tvQuestion2: TextView
    private lateinit var mAuth: FirebaseAuth
    private lateinit var mProgressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mAuth = FirebaseAuth.getInstance()
        mProgressDialog = ProgressDialog(this)
        mProgressDialog.setMessage("Saving data...")
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER)

        edtName = findViewById(R.id.mEdtName)
        edtEmail = findViewById(R.id.mEmailLogin)
        edtPhone = findViewById(R.id.mEdtPhone)
        edtPassword1 = findViewById(R.id.mLoginPassword)
        edtPassword2 = findViewById(R.id.mEdtPassword2)
        btnRegister = findViewById(R.id.mBtnRegister)
        tvQuestion2 = findViewById(R.id.mTvQuestion2)

        btnRegister.setOnClickListener {
            val name = edtName.text.toString()
            val email = edtEmail.text.toString()
            val phone = edtPhone.text.toString()
            val password1 =edtPassword1.text.toString()
            val password2 =edtPassword2.text.toString()

            if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || password1.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else if (password1 != password2) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
            } else if (password1.length < 8) {
                Toast.makeText(
                    this,
                    "Password must be at least 8 characters long",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                mProgressDialog.show()
                mAuth.createUserWithEmailAndPassword(email, password1)
                    .addOnCompleteListener { task ->
                        mProgressDialog.dismiss()
                        if (task.isSuccessful) {
                            val user = mAuth.currentUser
                            Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT)
                                .show()
                            // Start LoginActivity and close this activity
                            val intent = Intent(this, LoginActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            Toast.makeText(
                                this,
                                "Registration failed: ${task.exception?.message}",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
            }
        }
        tvQuestion2.setOnClickListener {
            var tembea = Intent(this, LoginActivity::class.java)
            startActivity(tembea)
            finish()
        }
    }
}


