package com.example.android_beginner_assginment

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat

class SignupActivity : AppCompatActivity() {
    private val id: EditText by lazy { findViewById(R.id.id_create) }
    private val psw: EditText by lazy { findViewById(R.id.psw_create) }
    private val name: EditText by lazy { findViewById(R.id.name_create) }
    private val age: EditText by lazy { findViewById(R.id.age_create) }
    private val gender: EditText by lazy { findViewById(R.id.gender_create) }
    private val mbti: EditText by lazy { findViewById(R.id.mbti_create) }
    private val hobby: EditText by lazy { findViewById(R.id.hobby_create) }

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

            Changingcolors(id, inputId)
            Changingcolors(psw, inputpsw)
            Changingcolors(name, inputname)
            Changingcolors(age, inputage)
            Changingcolors(gender, inputgender)
            Changingcolors(mbti, inputmbti)
            Changingcolors(hobby, inputhobby)

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

                val intent = Intent(this, SignInActivity::class.java)
                intent.putExtra("id", inputId)
                intent.putExtra("psw", inputpsw)
                setResult(Activity.RESULT_OK, intent)
                finish()

            } else {
                beRed(id)
                Toast.makeText(this, "중복된 아이디는 생성할 수 없습니다.\n 다시 입력해주세요", Toast.LENGTH_SHORT)
                    .show()
            }

        }
    }

    fun Changingcolors(id: View, inputId: String){
        if (inputId.isEmpty()) {
            beRed(id)
        }
    }

    fun beRed(id: View) {
        id.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_red_light))
    }

    fun beWhite(id: View) {
        id.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white))
    }

    fun textInput(id: EditText) {

        id.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                if (id.text.toString().isNotEmpty()) {
                    beWhite(id)
                }
            }
        })
    }

}


