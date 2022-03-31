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
    lateinit var rvTerlaris :RecyclerView
    lateinit var rvElektronik :RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)
//Slider
        vpSlider = view.findViewById(R.id.vp_slider)
//Produk
        rvProduk = view.findViewById(R.id.rv_produk)
        rvTerlaris = view.findViewById(R.id.rv_terlaris)
        rvElektronik = view.findViewById(R.id.rv_elektronik)


        val arrSlider = ArrayList<Int>()
        arrSlider.add(R.drawable.slider1)
        arrSlider.add(R.drawable.slider2)
        arrSlider.add(R.drawable.slider3)
        arrSlider.add(R.drawable.slider4)
        arrSlider.add(R.drawable.slider5)
        arrSlider.add(R.drawable.slider6)
        arrSlider.add(R.drawable.slider7)

        val adapterSlider = AdapterSlider(arrSlider, activity)
        vpSlider.adapter = adapterSlider

        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL

        val layoutManagerTerlaris = LinearLayoutManager(activity)
        layoutManagerTerlaris.orientation = LinearLayoutManager.HORIZONTAL

        val layoutManagerElektronik = LinearLayoutManager(activity)
        layoutManagerElektronik.orientation = LinearLayoutManager.HORIZONTAL

        rvProduk.adapter = AdapterProduk(arrProduk)
        rvProduk.layoutManager = layoutManager

        rvTerlaris.adapter = AdapterProduk(arrTerlaris)
        rvTerlaris.layoutManager = layoutManagerTerlaris

        rvElektronik.adapter = AdapterProduk(arrElektronik)
        rvElektronik.layoutManager = layoutManagerElektronik

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
        produk3.nama = "Laptop Vivobox Clip "
        produk3.harga = "Rp. 12.000.000"
        produk3.gambar = R.drawable.asuslipat

        val produk4 = Produk()
        produk4.nama = "Laptop Acer Aspire 5"
        produk4.harga = "Rp. 15.000.000"
        produk4.gambar = R.drawable.aceraspire5


        val produk5 = Produk()
        produk5.nama = "Laptop Acer Aspire 3"
        produk5.harga = "Rp. 11.000.000"
        produk5.gambar = R.drawable.acceraspire3

        val produk6 = Produk()
        produk6.nama = "Laptop Lenovo Ideapad"
        produk6.harga = "Rp. 11.900.000"
        produk6.gambar = R.drawable.lenovoideapad

        val produk7 = Produk()
        produk7.nama = "Laptop Lenovo Thinkpad"
        produk7.harga = "Rp. 11.200.000"
        produk7.gambar = R.drawable.lenovothinkpad

        val produk8 = Produk()
        produk8.nama = "Laptop Macboox Pro"
        produk8.harga = "Rp. 17.000.000"
        produk8.gambar = R.drawable.macbooxpro

        val produk9 = Produk()
        produk9.nama = "Laptop Macboox"
        produk9.harga = "Rp. 15.900.000"
        produk9.gambar = R.drawable.macbook

        val produk10 = Produk()
        produk10.nama = "Laptop HP"
        produk10.harga = "Rp. 10.900.000"
        produk10.gambar = R.drawable.hp

        arr.add(produk1)
        arr.add(produk2)
        arr.add(produk3)
        arr.add(produk4)
        arr.add(produk5)
        arr.add(produk6)
        arr.add(produk7)
        arr.add(produk8)
        arr.add(produk9)
        arr.add(produk10)

        return  arr
    }
    val arrTerlaris:ArrayList<Produk>get(){
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
        produk3.nama = "Laptop Vivobox Clip "
        produk3.harga = "Rp. 12.000.000"
        produk3.gambar = R.drawable.asuslipat

        val produk4 = Produk()
        produk4.nama = "Laptop Acer Aspire 5"
        produk4.harga = "Rp. 15.000.000"
        produk4.gambar = R.drawable.aceraspire5


        val produk5 = Produk()
        produk5.nama = "Laptop Acer Aspire 3"
        produk5.harga = "Rp. 11.000.000"
        produk5.gambar = R.drawable.acceraspire3

        val produk6 = Produk()
        produk6.nama = "Laptop Lenovo Ideapad"
        produk6.harga = "Rp. 11.900.000"
        produk6.gambar = R.drawable.lenovoideapad

        val produk7 = Produk()
        produk7.nama = "Laptop Lenovo Thinkpad"
        produk7.harga = "Rp. 11.200.000"
        produk7.gambar = R.drawable.lenovothinkpad

        val produk8 = Produk()
        produk8.nama = "Laptop Macboox Pro"
        produk8.harga = "Rp. 17.000.000"
        produk8.gambar = R.drawable.macbooxpro

        val produk9 = Produk()
        produk9.nama = "Laptop Macboox"
        produk9.harga = "Rp. 15.900.000"
        produk9.gambar = R.drawable.macbook

        val produk10 = Produk()
        produk10.nama = "Laptop HP"
        produk10.harga = "Rp. 10.900.000"
        produk10.gambar = R.drawable.hp

        arr.add(produk1)
        arr.add(produk2)
        arr.add(produk3)
        arr.add(produk4)
        arr.add(produk5)
        arr.add(produk6)
        arr.add(produk7)
        arr.add(produk8)
        arr.add(produk9)
        arr.add(produk10)

        return  arr
    }
    val arrElektronik:ArrayList<Produk>get(){
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
        produk3.nama = "Laptop Vivobox Clip "
        produk3.harga = "Rp. 12.000.000"
        produk3.gambar = R.drawable.asuslipat

        val produk4 = Produk()
        produk4.nama = "Laptop Acer Aspire 5"
        produk4.harga = "Rp. 15.000.000"
        produk4.gambar = R.drawable.aceraspire5


        val produk5 = Produk()
        produk5.nama = "Laptop Acer Aspire 3"
        produk5.harga = "Rp. 11.000.000"
        produk5.gambar = R.drawable.acceraspire3

        val produk6 = Produk()
        produk6.nama = "Laptop Lenovo Ideapad"
        produk6.harga = "Rp. 11.900.000"
        produk6.gambar = R.drawable.lenovoideapad

        val produk7 = Produk()
        produk7.nama = "Laptop Lenovo Thinkpad"
        produk7.harga = "Rp. 11.200.000"
        produk7.gambar = R.drawable.lenovothinkpad

        val produk8 = Produk()
        produk8.nama = "Laptop Macboox Pro"
        produk8.harga = "Rp. 17.000.000"
        produk8.gambar = R.drawable.macbooxpro

        val produk9 = Produk()
        produk9.nama = "Laptop Macboox"
        produk9.harga = "Rp. 15.900.000"
        produk9.gambar = R.drawable.macbook

        val produk10 = Produk()
        produk10.nama = "Laptop HP"
        produk10.harga = "Rp. 10.900.000"
        produk10.gambar = R.drawable.hp

        arr.add(produk1)
        arr.add(produk2)
        arr.add(produk3)
        arr.add(produk4)
        arr.add(produk5)
        arr.add(produk6)
        arr.add(produk7)
        arr.add(produk8)
        arr.add(produk9)
        arr.add(produk10)

        return  arr
    }



}