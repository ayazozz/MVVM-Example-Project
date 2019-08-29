package com.example.currencyapp.currencyList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyapp.databinding.CurrencyItemLayoutBinding

class CurrencyListAdapter(val clickListener: CurrencyItemClickListener) :
    ListAdapter<String, CurrencyListAdapter.CurrencyItemViewHolder>(
    ListCurrencyDiffCallBack()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyItemViewHolder {
        return CurrencyItemViewHolder.from(
            parent
        )
    }

    override fun onBindViewHolder(holder: CurrencyItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(clickListener,item)
    }

    class CurrencyItemViewHolder private constructor(val binding: CurrencyItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(clickListener: CurrencyItemClickListener, item: String) {
            binding.currency = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): CurrencyItemViewHolder {
                val layoutInflate = LayoutInflater.from(parent.context)
                val binding = CurrencyItemLayoutBinding.inflate(layoutInflate, parent, false)
                return CurrencyItemViewHolder(binding)
            }
        }
    }

}

class ListCurrencyDiffCallBack : DiffUtil.ItemCallback<String>()
{
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }
}

class CurrencyItemClickListener(val clickListener: (currency: String) -> Unit) {

    fun onClick(currency: String) = clickListener(currency)
}
