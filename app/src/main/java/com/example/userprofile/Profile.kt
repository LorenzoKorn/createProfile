package com.example.userprofile

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Profile(
    var firstname: String,
    var secondname: String,
    var description: String
) : Parcelable