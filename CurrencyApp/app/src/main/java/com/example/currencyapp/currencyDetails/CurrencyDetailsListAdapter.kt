package com.example.currencyapp.currencyDetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyapp.databinding.CurrencyDetailListItemBinding

class CurrencyDetailsListAdapter() : ListAdapter<String, CurrencyDetailsListAdapter.CurrencyDetailsListViewHolder>(
    ListCurrencyDetailsListDetailsDiffCallBack()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyDetailsListViewHolder {
        return CurrencyDetailsListViewHolder.from(
            parent
        )
    }

    override fun onBindViewHolder(holder: CurrencyDetailsListViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }


    class CurrencyDetailsListViewHolder private constructor(val binding: CurrencyDetailListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: String) {
            binding.currencyDetailListItem = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): CurrencyDetailsListViewHolder {
                val layoutInflate = LayoutInflater.from(parent.context)
                val binding = CurrencyDetailListItemBinding.inflate(layoutInflate, parent, false)
                return CurrencyDetailsListViewHolder(binding)
            }
        }
    }
}

class ListCurrencyDetailsListDetailsDiffCallBack : DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }
}

