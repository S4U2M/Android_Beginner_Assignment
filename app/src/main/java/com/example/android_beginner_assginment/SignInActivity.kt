package com.example.android_beginner_assginment

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignInActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign)
        val signB = findViewById<Button>(R.id.sign)

        signB.setOnClickListener {
            val moveToSign = Intent(this, SignupActivity::class.java)
            startActivity(moveToSign)
        }
    }

    fun login(view: View) {
        val id = findViewById<EditText>(R.id.id_Edit)
        val psw = findViewById<EditText>(R.id.psw_Edit)

        val inputId = id.text.toString()
        val inputPsw = psw.text.toString()

        val userFindInfo = UserManager.userList.find { it.id == inputId && it.password == inputPsw }

        if (userFindInfo != null) {

            val moveToHome = Intent(this, HomeActivity::class.java)
            Toast.makeText(this, "로그인이 성공하였습니다", Toast.LENGTH_SHORT).show()

            val bundle = Bundle()

            bundle.putSerializable("loginUserInfo",userFindInfo)
            moveToHome.putExtra("bundle",bundle)

            startActivity(moveToHome)

        } else {
            Toast.makeText(
                this,
                "로그인에 실패하였습니다.\n" +
                        "아이디와 비밀번호를 확인해주세요.", Toast.LENGTH_LONG
            ).show()
        }
    }

}

