package com.example.e_commerce

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.io.IOException
import java.util.UUID

class StorageOthersActivity : AppCompatActivity() {

    private val PICK_IMAGE_REQUEST = 71
    private var filePath: Uri? = null
    private var firebaseStore: FirebaseStorage? = null
    private var storageReference: StorageReference? = null
    lateinit var imagePreview: ImageView
    lateinit var btn_choose_image: Button
    lateinit var btn_upload_image: Button
    lateinit var progress: ProgressDialog
    lateinit var edtName: EditText
    lateinit var edtDesc: EditText
    lateinit var edtSize: EditText
    lateinit var edtPrice: EditText




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_storage)
        btn_choose_image = findViewById(R.id.btn_choose_image)
        btn_upload_image = findViewById(R.id.btn_upload_image)
        imagePreview = findViewById(R.id.image_preview)
        edtName = findViewById(R.id.mEdtBName)
        edtDesc = findViewById(R.id.mEdtBDesc)
        edtSize = findViewById(R.id.mEdtBSize)
        edtPrice = findViewById(R.id.mEdtPrice)


        firebaseStore = FirebaseStorage.getInstance()
        storageReference = FirebaseStorage.getInstance().reference
        progress = ProgressDialog(this)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")

        btn_choose_image.setOnClickListener { launchGallery() }
        btn_upload_image.setOnClickListener { uploadImage() }
    }

    private fun launchGallery() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK) {
            if(data == null || data.data == null){
                return
            }

            filePath = data.data
            try {
                val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, filePath)
                imagePreview.setImageBitmap(bitmap)
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    private fun uploadImage() {

        var name = edtName.text.toString().trim()
        var description = edtDesc.text.toString().trim()
        var size = edtSize.text.toString().trim()
        var price = edtPrice.text.toString().trim()
        var id = System.currentTimeMillis().toString()
        if (name.isEmpty()){
            edtName.setError("Please fill this input")
            edtName.requestFocus()
        }else if (description.isEmpty()){
            edtDesc.setError("Please fill this input")
            edtDesc.requestFocus()
        }else if (size.isEmpty()){
            edtSize.setError("Please fill this input")
            edtSize.requestFocus()
        }else if (price.isEmpty()){
            edtPrice.setError("Please fill this input")
            edtPrice.requestFocus()
        }else{
            if(filePath != null){

                val ref = storageReference?.child("Others/" + UUID.randomUUID().toString())
                progress.show()
                val uploadTask = ref?.putFile(filePath!!)!!.addOnCompleteListener{
                    progress.dismiss()
                    if (it.isSuccessful){
                        ref.downloadUrl.addOnSuccessListener {
                            var carData = Upload(name,description,size,price,it.toString(),id)
                            var ref = FirebaseDatabase.getInstance().getReference().child("Others/$id")
                            ref.setValue(carData)
                            Toast.makeText(this, "Photo submitted successfully", Toast.LENGTH_SHORT).show()
                        }
                    }else{
                        Toast.makeText(this, "Photo submission failed", Toast.LENGTH_SHORT).show()
                    }
                }


            }else{
                Toast.makeText(this, "Kindly Upload an Image", Toast.LENGTH_SHORT).show()
            }


        }

    }

}