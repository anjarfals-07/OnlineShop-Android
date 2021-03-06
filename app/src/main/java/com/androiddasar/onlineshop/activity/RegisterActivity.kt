package com.androiddasar.onlineshop.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.androiddasar.onlineshop.MainActivity
import com.androiddasar.onlineshop.R
import com.androiddasar.onlineshop.app.ApiConfig
import com.androiddasar.onlineshop.helper.SharedPref
import com.androiddasar.onlineshop.model.ResponseModel
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.edt_email
import kotlinx.android.synthetic.main.activity_register.edt_password
import kotlinx.android.synthetic.main.activity_register.progress_bar
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
    lateinit var s: SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        s = SharedPref(this)

        btn_register.setOnClickListener {
            register()
        }

        btn_google.setOnClickListener {
            dataDummy()
        }
    }

    fun dataDummy(){
        edt_nama.setText("Muhammad Anjar")
        edt_email.setText("anjarfals07@gmail.com")
        edt_phone.setText("081294176339")
        edt_password.setText("admin12345")

    }

    fun register() {

        if (edt_nama.text.isEmpty()) {
            edt_nama.error = "Kolom Nama tidak boleh kosong"
            edt_nama.requestFocus()
            return
        } else if (edt_email.text.isEmpty()) {
            edt_email.error = "Kolom Email tidak boleh kosong"
            edt_email.requestFocus()
            return
        } else if (edt_phone.text.isEmpty()) {
            edt_phone.error = "Kolom Nomor Telepon tidak boleh kosong"
            edt_phone.requestFocus()
            return
        } else if (edt_password.text.isEmpty()) {
            edt_password.error = "Kolom Password tidak boleh kosong"
            edt_password.requestFocus()
            return
        }

        progress_bar.visibility = View.VISIBLE

        ApiConfig.instanceRetrofit.register(edt_nama.text.toString(), edt_email.text.toString(),edt_phone.text.toString(), edt_password.text.toString()).enqueue(object : Callback<ResponseModel>{

            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                //progressbar berhenti
                progress_bar.visibility = View.GONE
                Toast.makeText(this@RegisterActivity, "error:"+t.message, Toast.LENGTH_SHORT).show()
            }

               override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
                   //progressbar berhenti
                   progress_bar.visibility = View.GONE
                   val respons = response.body()!!
                if (respons.success == 200){

                    s.setStatusLogin(true)
                    val intent = Intent(this@RegisterActivity, MainActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)
                    finish()

                    Toast.makeText(this@RegisterActivity, "Success : " + respons.message+"\n Selamat Datang : "+respons.user.name, Toast.LENGTH_SHORT).show()
                }else {
                    Toast.makeText(this@RegisterActivity, "Error:" + respons.message, Toast.LENGTH_SHORT).show()
                }
            }

        })
    }
}