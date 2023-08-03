package com.example.android_beginner_assginment

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat

class SignupActivity : AppCompatActivity() {
    private val id: EditText by lazy {findViewById(R.id.id_create) }
    private val psw: EditText by lazy{findViewById(R.id.psw_create)}
    private val name:EditText by lazy { findViewById(R.id.name_create) }
    private val age:EditText by lazy { findViewById(R.id.age_create) }
    private val gender:EditText by lazy { findViewById(R.id.gender_create) }
    private val mbti:EditText by lazy { findViewById(R.id.mbti_create) }
    private val hobby:EditText by lazy { findViewById(R.id.hobby_create) }



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        textInput(id)
        textInput(psw)
        textInput(name)
        textInput(age)
        textInput(gender)
        textInput(mbti)
        textInput(hobby)

    }

    fun signupfinish(view: View) {

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

    fun textInput(id:EditText){

        id.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                if (id.text.toString().isNotEmpty()){
                    beWhite(id)
                }
            }
        })
    }

}


