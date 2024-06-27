package com.example.orinugooriworldapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val name: String,
    val id: String,
    val password: String,
    val age: Int,
    val sns: String
) : Parcelable