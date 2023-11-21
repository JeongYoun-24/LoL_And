package com.example.lol_lain

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lol_lain.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val intent = Intent(this, MainActivity::class.java)
        binding.btn1.setOnClickListener{startActivity(intent)} // 로그인화면에서 메인 화면으로 전환 

        val intent2 = Intent(this, RegisterActivity::class.java)
        binding.registerBtn.setOnClickListener{startActivity(intent2)} //로그인화면에서 회원가입 화면으로 전환

    }
}