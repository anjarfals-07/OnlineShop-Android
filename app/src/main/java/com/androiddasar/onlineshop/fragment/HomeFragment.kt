package com.androiddasar.onlineshop.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.androiddasar.onlineshop.R
import com.androiddasar.onlineshop.adapter.AdapterProduk
import com.androiddasar.onlineshop.adapter.AdapterSlider
import com.androiddasar.onlineshop.model.Produk

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    lateinit var vpSlider :ViewPager
    lateinit var rvProduk :RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        vpSlider = view.findViewById(R.id.vp_slider)
        rvProduk = view.findViewById(R.id.rv_produk)

        val arrSlider = ArrayList<Int>()
        arrSlider.add(R.drawable.slider1)
        arrSlider.add(R.drawable.slider2)
        arrSlider.add(R.drawable.slider3)

        val adapterSlider = AdapterSlider(arrSlider, activity)
        vpSlider.adapter = adapterSlider

        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL

        rvProduk.adapter = AdapterProduk(arrProduk)
        rvProduk.layoutManager = layoutManager

        return view
    }

    val arrProduk:ArrayList<Produk>get(){
        //Tampung ke dalam array
        val arr = ArrayList<Produk>()
        val produk1 = Produk()
        produk1.nama = "Laptop Asus ROG"
        produk1.harga = "Rp. 17.000.000"
        produk1.gambar = R.drawable.asusrog

        val produk2 = Produk()
        produk2.nama = "Laptop Asus Vivobox"
        produk2.harga = "Rp. 11.000.000"
        produk2.gambar = R.drawable.asusvivobox

        val produk3 = Produk()
        produk3.nama = "Laptop Acer Aspire 5"
        produk3.harga = "Rp. 15.000.000"
        produk3.gambar = R.drawable.aceraspire5

        arr.add(produk1)
        arr.add(produk2)
        arr.add(produk3)

        return  arr
    }


}