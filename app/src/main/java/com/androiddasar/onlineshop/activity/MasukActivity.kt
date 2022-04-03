package com.androiddasar.onlineshop.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.androiddasar.onlineshop.R
import com.androiddasar.onlineshop.helper.SharedPref

class MasukActivity : AppCompatActivity() {
    lateinit var s: SharedPref

    private lateinit var btnRegister: Button
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_masuk)

        btnRegister = findViewById(R.id.btn_register)
        s = SharedPref(this)

        btnLogin = findViewById(R.id.btn_prosesLogin)
        s = SharedPref(this)

        mainButton()
    }

    fun mainButton() {
    btnLogin.setOnClickListener{
        startActivity(Intent(this, LoginActivity::class.java))
    }
    btnRegister.setOnClickListener{
       startActivity(Intent(this, RegisterActivity::class.java))
    }
}
}