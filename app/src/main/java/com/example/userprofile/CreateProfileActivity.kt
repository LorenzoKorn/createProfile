package com.example.userprofile

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_create_profile.*

class CreateProfileActivity : AppCompatActivity() {

    private var profileImageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_profile)

        initButtons()
    }

    private fun initButtons() {
        gallary_btn.setOnClickListener {
            onGalleryClick()
        }

        confirm_btn.setOnClickListener {
            // save your profile
        }
    }

    private fun onGalleryClick() {
        // creates an 'envelope' that only accept images
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, GALLERY_REQUEST_CODE)
    }

    @SuppressLint("MissingSuperCall")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                GALLERY_REQUEST_CODE -> {
                    // set the image from gallery in the image view
                    profileImageUri = data?.data
                    profile_image.setImageURI(profileImageUri)
                }
            }
        }
    }
}
