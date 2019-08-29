package com.example.currencyapp.currencyDetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyapp.databinding.CurrencyDetailLayoutBinding

class CurrencyDetailsAdapter():ListAdapter<String, CurrencyDetailsAdapter.CurrencyDetailViewHolder>(
ListDetailsDiffCallBack()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyDetailViewHolder {
        return CurrencyDetailViewHolder.from(
            parent
        )
    }


    override fun onBindViewHolder(holder: CurrencyDetailViewHolder, position: Int) {
        holder.bind(currentList)
    }


    class CurrencyDetailViewHolder private constructor(val binding: CurrencyDetailLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(items: MutableList<String>) {
            val adapter = CurrencyDetailsListAdapter()
            binding.currencyDetailRcView.adapter = adapter
            adapter.submitList(items)
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): CurrencyDetailViewHolder {
                val layoutInflate = LayoutInflater.from(parent.context)
                val binding = CurrencyDetailLayoutBinding.inflate(layoutInflate,parent,false)
                return CurrencyDetailViewHolder(binding)
            }
        }
    }

}
class ListDetailsDiffCallBack : DiffUtil.ItemCallback<String>()
{
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }
}


