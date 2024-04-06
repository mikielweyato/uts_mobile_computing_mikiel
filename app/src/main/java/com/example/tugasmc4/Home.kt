package com.example.tugasmc4

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Home : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var harga: Array<String>
    private lateinit var judul: Array<String>

    //    private lateinit var Bgambar : Arrayt<Int>
    private lateinit var gambar: Array<Int>
    private lateinit var ulasan: Array<String>
    private lateinit var deskripsi: Array<String>
    private lateinit var listBacaan: ArrayList<ItemData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_home)


        gambar = arrayOf(
            R.drawable.gambar3,
            R.drawable.gambar1,
            R.drawable.gambar7,
            R.drawable.gambar3,
            R.drawable.gambar1,
            R.drawable.gambar7
        )

        judul = arrayOf(
            "Nike SB Dunk",
            "New Balance 550",
            "Nike Air Jordan",
            "Nike SB Dunk",
            "New balance 550",
            "Nike Air Jordan",
            "Nike SB Dunk"
        )

        harga = arrayOf(
            "Rp1.990.000",
            "Rp2.990.000",
            "Rp3.000.000",
            "Rp1.990.000",
            "Rp2.990.000",
            "Rp3.0000.000",
            "Rp1.990.000"
        )
        ulasan = arrayOf(
            getString(R.string.u_1),
            getString(R.string.u_2),
            getString(R.string.u_3),
            getString(R.string.u_4),
            getString(R.string.u_5),
            getString(R.string.u_6)
        )
        deskripsi = arrayOf(
            getString(R.string.d_1),
            getString(R.string.d_2),
            getString(R.string.d_3),
            getString(R.string.d_4),
            getString(R.string.d_5),
            getString(R.string.d_6)
        )
        newRecyclerView = findViewById(R.id.hasil)
        newRecyclerView.layoutManager = LinearLayoutManager(this)

        listBacaan = arrayListOf<ItemData>()
        getShop()


    }

    private fun getShop() {
        for (i in gambar.indices) {
            val dataBacaan = ItemData(gambar[i], judul[i], harga[i])
//            listBacaan.add(dataBacaan)
            listBacaan.add(dataBacaan)
        }
        var adapter = MyAdapter(listBacaan)
        newRecyclerView.adapter = adapter

        adapter.setOnItemClickListener(object : MyAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                val intent = Intent(this@Home, Detail::class.java)
                intent.putExtra("gbr", listBacaan[position].gambar)
                intent.putExtra("jdl", listBacaan[position].judul)
                intent.putExtra("hrg", listBacaan[position].hrg)
                intent.putExtra("uls", ulasan[position])
                intent.putExtra("desk", deskripsi[position])

                startActivity(intent)


            }

        })

    }
}