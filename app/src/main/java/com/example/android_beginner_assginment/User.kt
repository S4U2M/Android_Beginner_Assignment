package com.example.android_beginner_assginment

import java.io.Serializable

data class User(val id:String, val password:String, val name:String,val age:String, var gender:String, var MBTI:String,var hobby:String) :
    Serializable
