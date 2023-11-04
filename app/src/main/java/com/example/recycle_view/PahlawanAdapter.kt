package com.example.recycle_view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycle_view.databinding.ItemPahlawanBinding

typealias onClickPahlawan = (Pahlawan) -> Unit

class PahlawanAdapter(private val listPahlawan: List<Pahlawan>, private val onClickPahlawan: onClickPahlawan):
    RecyclerView.Adapter<PahlawanAdapter.ItemPahlawanViewHolder>() {

    inner class ItemPahlawanViewHolder(private val binding: ItemPahlawanBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Pahlawan) {
            with(binding) {
                txtNamaPahlawan.text = data.PahlawanName
                txtPeranPahlawan.text = data.PahlawanPeran
                val imgPahlawan = when (data.pahlawanPict){
                    R.drawable.sayutimalik -> R.drawable.sayutimalik
                    R.drawable.soekarno -> R.drawable.soekarno
                    R.drawable.kartini->R.drawable.kartini
                    R.drawable.pattimura->R.drawable.pattimura
                    else -> R.drawable.default_img
                }
                ImgPahlawan.setImageResource(imgPahlawan)
                itemView.setOnClickListener {
                    onClickPahlawan(data)
                }
            }

    }

}

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ):ItemPahlawanViewHolder {
        val binding = ItemPahlawanBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false)
        return ItemPahlawanViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemPahlawanViewHolder, position: Int) {
        holder.bind(listPahlawan[position])
    }

    override fun getItemCount(): Int = listPahlawan.size
}