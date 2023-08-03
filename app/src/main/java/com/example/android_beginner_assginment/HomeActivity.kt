package com.example.android_beginner_assginment

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class HomeActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val receivedIntent = intent
        val receivedBundle = receivedIntent.getBundleExtra("bundle")
        val user = receivedBundle?.getSerializable("loginUserInfo") as User

        val name = findViewById<TextView>(R.id.nameInprfile)
        val age = findViewById<TextView>(R.id.ageInprofile)
        val gender = findViewById<TextView>(R.id.genderInprofile)
        val mbti = findViewById<TextView>(R.id.mbtiInprofile)
        val hobby = findViewById<TextView>(R.id.hobbyInprofile)



            name.text = " ${user.name}"
            age.text = "${user.age}"
            gender.text = "${user.gender}"
            mbti.text = "${user.MBTI}"
            hobby.text = "${user.hobby}"

    }


}