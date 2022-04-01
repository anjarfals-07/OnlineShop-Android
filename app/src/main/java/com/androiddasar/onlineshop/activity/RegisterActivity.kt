package com.androiddasar.onlineshop.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.androiddasar.onlineshop.R
import com.androiddasar.onlineshop.app.ApiConfig
import kotlinx.android.synthetic.main.activity_register.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {

    private lateinit var name: EditText
    private lateinit var email: EditText
    private lateinit var phone: EditText
    private lateinit var password: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        name = findViewById(R.id.edt_nama)
        email = findViewById(R.id.edt_email)
        phone = findViewById(R.id.edt_phone)
        password = findViewById(R.id.edt_password)

        btn_register.setOnClickListener {
            register()
        }

    }

    fun register() {
        if (name.text.isEmpty()) {
            name.error = "Kolom Nama tidak boleh kosong"
            name.requestFocus()
            return
        } else if (email.text.isEmpty()) {
            email.error = "Kolom Email tidak boleh kosong"
            email.requestFocus()
            return
        } else if (phone.text.isEmpty()) {
            phone.error = "Kolom Nomor Telepon tidak boleh kosong"
            phone.requestFocus()
            return
        } else if (password.text.isEmpty()) {
            password.error = "Kolom Password tidak boleh kosong"
            password.requestFocus()
            return
        }

        ApiConfig.instanceRetrofit.register(name.text.toString(), email.text.toString(), password.text.toString()).enqueue(object : Callback<ResponseBody>{
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                // Handel ketika sukses
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                // handel ketika gagal
            }

        })
    }
}