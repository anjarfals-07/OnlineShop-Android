package com.androiddasar.onlineshop.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.androiddasar.onlineshop.MainActivity
import com.androiddasar.onlineshop.R
import com.androiddasar.onlineshop.app.ApiConfig
import com.androiddasar.onlineshop.helper.SharedPref
import com.androiddasar.onlineshop.model.ResponseModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    lateinit var s: SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        s = SharedPref(this)

        btn_login.setOnClickListener {
            login()
        }
    }

    fun login() {
        if (edt_email.text.isEmpty()) {
            edt_email.error = "Kolom Email tidak boleh kosong"
            edt_email.requestFocus()
            return
        } else if (edt_password.text.isEmpty()) {
            edt_email.error = "Kolom Password tidak boleh kosong"
            edt_email.requestFocus()
            return
        }

        // progress bar
        progress_bar.visibility = View.VISIBLE

        ApiConfig.instanceRetrofit.login(edt_email.text.toString(), edt_password.text.toString()).enqueue(object : Callback<ResponseModel> {

            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                //progressbar berhenti
                progress_bar.visibility = View.GONE
                Toast.makeText(this@LoginActivity, "error:" + t.message, Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
                progress_bar.visibility = View.GONE
                val respon = response.body()!!
                if (respon.success == 200) {

                    s.setStatusLogin(true)
                    s.setUser(respon.user)
//                    s.setString(s.nama, respon.user.name)
//                    s.setString(s.phone, respon.user.phone)
//                    s.setString(s.email, respon.user.email)

                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)
                    finish()

                    Toast.makeText(
                        this@LoginActivity,
                        "Success : " + respon.message + "\n Selamat Datang : " + respon.user.name,
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        this@LoginActivity,
                        "Error:" + respon.message,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

        })
    }
}