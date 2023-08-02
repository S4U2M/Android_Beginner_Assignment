package com.example.android_beginner_assginment

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat

class SignupActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

    }

    fun signupfinish(view: View) {

        val id = findViewById<EditText>(R.id.id_create)
        val psw = findViewById<EditText>(R.id.psw_create)
        val name = findViewById<EditText>(R.id.name_create)
        val age = findViewById<EditText>(R.id.age_create)
        val gender = findViewById<EditText>(R.id.gender_create)
        val mbti = findViewById<EditText>(R.id.mbti_create)
        val hobby = findViewById<EditText>(R.id.hobby_create)

        val inputId = id.text.toString()
        val inputpsw = psw.text.toString()
        val inputname = name.text.toString()
        val inputage = age.text.toString()
        val inputgender = gender.text.toString()
        val inputmbti = mbti.text.toString()
        val inputhobby = hobby.text.toString()

        if (inputId.isEmpty() || inputpsw.isEmpty() || inputname.isEmpty()
            || inputId.isEmpty() || inputgender.isEmpty() || inputmbti.isEmpty() || inputhobby.isEmpty()
        ) {

            Toast.makeText(this, "공백을 채워주세요", Toast.LENGTH_SHORT).show()
            Changingcolors(
                id = id,
                inputId = inputId,
                psw = psw,
                inputpsw = inputpsw,
                name = name,
                inputname = inputname,
                inputage = inputage,
                age = age,
                inputgender = inputgender,
                gender = gender,
                inputmbti = inputmbti,
                mbti = mbti,
                inpuhobby = inputhobby,
                hobby = hobby
            )

        } else {

            if (UserManager.userList.find { it.id == inputId } == null) {

                UserManager.userList.add(
                    User(
                        inputId,
                        inputpsw,
                        inputname,
                        inputage,
                        inputgender,
                        inputmbti,
                        inputhobby
                    )
                )
                finish()

            } else {

                beRed(id)
                beWhite(psw)
                beWhite(name)
                beWhite(age)
                beWhite(gender)
                beWhite(mbti)
                beWhite(hobby)

                Toast.makeText(this, "중복된 아이디는 생성할 수 없습니다.\n 다시 입력해주세요", Toast.LENGTH_SHORT)
                    .show()
            }

        }
    }

    fun Changingcolors(
        inputId: String, id: View,
        inputpsw: String, psw: View,
        inputname: String, name: View,
        inputage: String, age: View,
        inputgender: String, gender: View,
        inputmbti: String, mbti: View,
        inpuhobby: String, hobby: View
    ) {

        if (inputId.isEmpty()) {
            beRed(id)
        } else {
            beWhite(id)
        }

        if (inputpsw.isEmpty()) {
            beRed(psw)
        } else {
            beWhite(psw)
        }

        if (inputname.isEmpty()) {
            beRed(name)
        } else {
            beWhite(name)
        }

        if (inputage.isEmpty()) {
            beRed(age)
        } else {
            beWhite(age)
        }

        if (inputgender.isEmpty()) {
            beRed(gender)
        } else {
            beWhite(gender)
        }

        if (inputmbti.isEmpty()) {
            beRed(mbti)
        } else {
            beWhite(mbti)
        }

        if (inpuhobby.isEmpty()) {
            beRed(hobby)
        } else {
            beWhite(hobby)
        }
    }

    fun beRed(id: View) {
        id.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_red_light))
    }

    fun beWhite(id: View) {
        id.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white))
    }

}


