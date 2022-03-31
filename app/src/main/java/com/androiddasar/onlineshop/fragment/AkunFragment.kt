package com.androiddasar.onlineshop.fragment

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.androiddasar.onlineshop.R
import com.androiddasar.onlineshop.helper.SharedPref

/**
 * A simple [Fragment] subclass.
 * Use the [AkunFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AkunFragment : Fragment() {
    lateinit var s: SharedPref
    lateinit var btnLogout: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_akun, container, false)
        btnLogout = view.findViewById(R.id.btn_logout)

        s = SharedPref(requireActivity())
        mainButton()

        return view
    }

    fun mainButton() {
        btnLogout.setOnClickListener {
            s.setStatusLogin(false)
        }
    }
}


