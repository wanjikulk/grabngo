package com.example.e_commerce

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var EmailLogin: EditText
    private lateinit var LoginPassword: EditText
    private lateinit var LoginFinish: Button
    private lateinit var progressDialog: ProgressDialog

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mAuth = FirebaseAuth.getInstance()

        EmailLogin = findViewById(R.id.mEmailLogin)
        LoginPassword = findViewById(R.id.mLoginPassword)
        LoginFinish = findViewById(R.id.mLoginFinish)

        progressDialog = ProgressDialog(this)
        progressDialog.setCancelable(false)
        progressDialog.setMessage("G 'n' G is getting things ready...")

        LoginFinish.setOnClickListener {
            val nameOrEmail = EmailLogin.text.toString()
            val password = LoginPassword.text.toString()

            if (nameOrEmail.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else {
                progressDialog.show()
                val isValidEmail = nameOrEmail.length >= 8 // Check if email is at least 8 characters long
                val signInTask = if (isValidEmail) {
                    // Sign in with email
                    mAuth.signInWithEmailAndPassword(nameOrEmail, password)
                } else {
                    // Sign in with username
                    mAuth.signInWithEmailAndPassword("$nameOrEmail@example.com", password)
                }

                signInTask.addOnCompleteListener { task ->
                    progressDialog.dismiss()
                    if (task.isSuccessful) {
                        // Start the HomeActivity after login is successful
                        val intent = Intent(this, HomeActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        progressDialog.dismiss()
                        Toast.makeText(this, "Wrong password", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}