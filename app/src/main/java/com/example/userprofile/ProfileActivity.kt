package com.example.userprofile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_profile.*

// a constant here can't be used by other classes!

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        initView()
    }

    private fun initView() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.your_profile)

        val profile = intent.getParcelableExtra<Profile>(PROFILE_EXTRA)

        if (profile != null) {
            full_name.text = getString(R.string.full_name, profile.firstname, profile.secondname)
            description.text = profile.description

            if (profile.imageUri != null) {
                profile_image.setImageURI(profile.imageUri)
            }
        }
    }

    //
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }


    // creates a static constant (this can be used by other classes as well)
    companion object {
        const val PROFILE_EXTRA = "PROFILE_EXTRA"
    }
}
