package com.androiddasar.onlineshop.fragment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.androiddasar.onlineshop.MainActivity
import com.androiddasar.onlineshop.R
import com.androiddasar.onlineshop.activity.LoginActivity
import com.androiddasar.onlineshop.helper.SharedPref

/**
 * A simple [Fragment] subclass.
 * Use the [AkunFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AkunFragment : Fragment() {
    lateinit var s: SharedPref
    lateinit var btnLogout: TextView
    lateinit var tvNama: TextView
    lateinit var tvEmail: TextView
    lateinit var tvPhone: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_akun, container, false)
        btnLogout = view.findViewById(R.id.btn_logout)

        init(view)

        s = SharedPref(requireActivity())
        mainButton()
        setData()
        return view
    }

    fun mainButton() {
        btnLogout.setOnClickListener {
            s.setStatusLogin(false)
        }
    }



    //mengambilkan data
    fun setData() {

        if (s.getUser() == null){
        val intent = Intent(activity, LoginActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        return
    }

    val user = s.getUser()!!

    tvNama.text = user.name
    tvPhone.text =user.phone
    tvEmail.text = user.email
}

private fun init(view: View) {
    btnLogout = view.findViewById(R.id.btn_logout)
    tvNama = view.findViewById(R.id.tv_nama)
    tvPhone = view.findViewById(R.id.tv_phone)
    tvEmail = view.findViewById(R.id.tv_email)
}
}


