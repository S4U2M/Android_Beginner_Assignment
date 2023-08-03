package com.example.android_beginner_assginment

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

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

        val img = findViewById<ImageView>(R.id.gundamImg)
        val imageResources = arrayOf(R.drawable.gundam03, R.drawable.gundam05,R.drawable.gundam01)

        var random = Random.nextInt(imageResources.size)
        val randomImg = imageResources[random]


        img.setImageResource(randomImg)

            name.text = " ${user.name}"
            age.text = "${user.age}"
            gender.text = "${user.gender}"
            mbti.text = "${user.MBTI}"
            hobby.text = "${user.hobby}"

    }


}