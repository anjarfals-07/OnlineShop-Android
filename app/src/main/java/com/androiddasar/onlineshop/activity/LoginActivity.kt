package com.androiddasar.onlineshop.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.androiddasar.onlineshop.R
import com.androiddasar.onlineshop.helper.SharedPref
import com.google.android.material.bottomnavigation.BottomNavigationView

class LoginActivity : AppCompatActivity() {
    lateinit var s:SharedPref

    private lateinit var btnLogin: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin = findViewById(R.id.btn_prosesLogin)
        s = SharedPref(this)

        btnLogin.setOnClickListener {
            s.setStatusLogin(true)
        }
    }
}