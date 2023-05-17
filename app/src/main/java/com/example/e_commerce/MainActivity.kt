package com.example.e_commerce

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.coroutines.flow.SharingStarted

class MainActivity : AppCompatActivity() {
    lateinit var btnGetStarted:Button
    lateinit var progressDialog: ProgressDialog
    lateinit var btnUpload : Button
    lateinit var btnPizzas : Button
    lateinit var btnOthers : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnGetStarted = findViewById(R.id.mBtnGetStarted)
        btnUpload = findViewById(R.id.mBtnUpload)
        btnPizzas = findViewById(R.id.mBtnPizzas)
        btnOthers = findViewById(R.id.mBtnOthers)

        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Starting")
        progressDialog.setMessage("Kindly wait...")


        btnGetStarted.setOnClickListener {
            var tembea = Intent(this, RegisterActivity::class.java)
            startActivity(tembea)
        }
        btnUpload.setOnClickListener {
            var tembea = Intent(this, StorageActivity::class.java)
            startActivity(tembea)
        }
        btnPizzas.setOnClickListener {
            var tembea = Intent(this, StoragePizzaActivity::class.java)
            startActivity(tembea)
        }
        btnOthers.setOnClickListener {
            var tembea = Intent(this, StorageOthersActivity::class.java)
            startActivity(tembea)
        }

    }
}