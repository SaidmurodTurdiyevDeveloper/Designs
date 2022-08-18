package com.designs.mybeautifuldesigns.designs.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.designs.mybeautifuldesigns.designs.model.FragmentItem
import dagger.hilt.android.qualifiers.ApplicationContext
import designs.mybeautifuldesigns.databinding.ItemDesignBinding
import javax.inject.Inject

/**
 * Created by Saidmurod Turdiyev (S.M.T) on 15/08/2022.
 */
class FragmentAdapter @Inject constructor(@ApplicationContext private var context: Context) : RecyclerView.Adapter<FragmentAdapter.ViewHolder>() {
    var differList = AsyncListDiffer(this, ITEM_DIFF)
        private set

    private companion object {
        private val ITEM_DIFF = object : DiffUtil.ItemCallback<FragmentItem>() {
            override fun areItemsTheSame(oldItem: FragmentItem, newItem: FragmentItem): Boolean =
                oldItem.name == newItem.name

            override fun areContentsTheSame(oldItem: FragmentItem, newItem: FragmentItem): Boolean =
                oldItem == newItem
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemDesignBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(differList.currentList[position])

    override fun getItemCount(): Int = differList.currentList.size

    inner class ViewHolder(private var binding: ItemDesignBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.itemBackground.setOnClickListener {
                differList.currentList[absoluteAdapterPosition].openFragment.invoke()
            }
        }

        fun bind(item: FragmentItem) {
            binding.itemBackground.setBackgroundColor(item.backgroundColor)
            binding.tvItem.text = item.name
            binding.tvItem.setTextColor(item.textColor)
        }
    }
}