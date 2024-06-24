package com.example.orinugooriworldapp

import java.io.Serializable

//패럴라이저블..

data class User(val name : String, val id : String, val password : String,val age : Int,val sns : String) : Serializable