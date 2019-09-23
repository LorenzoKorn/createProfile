package com.example.userprofile

import android.net.Uri
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Profile(
    val firstname: String,
    val secondname: String,
    val description: String,
    val imageUri: Uri? // can be null
) : Parcelable