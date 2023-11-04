package com.example.recycle_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycle_view.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapterPahlawan = PahlawanAdapter(generateDummy()) {Pahlawan ->
            Toast.makeText(this@MainActivity,"${Pahlawan.PahlawanName} Sang ${Pahlawan.PahlawanPeran}", Toast.LENGTH_SHORT).show()
        }
        with(binding) {
            rvPahlawan.apply {
                adapter = adapterPahlawan
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
    }

    private fun generateDummy(): List<Pahlawan> {
        return listOf(
            Pahlawan(R.drawable.soekarno, "I.R Soekarno", "Bapak Proklamasi"),
            Pahlawan(R.drawable.sayutimalik, "Sayuti Malik", "Pengetik Teks Proklamasi"),
            Pahlawan(R.drawable.kartini, "R.A Kartini","Pejuang Emansipasi Wanita"),
            Pahlawan(R.drawable.pattimura, "Thomas Matulessy", "Panglima Perang"),
        )
    }
}