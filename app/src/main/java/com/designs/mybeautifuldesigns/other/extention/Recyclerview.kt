package com.designs.mybeautifuldesigns.other.extention

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

/**
 * Created by Saidmurod Turdiyev (S.M.T) on 19/08/2022.
 */
class ExperimentalRecyclerViewAdapter(var list: List<Any>, var binding: ViewBinding, var onBindItem: (Any) -> Unit, var onClickItem: (Int) -> Unit={}) :
    RecyclerView.Adapter<ExperimentalRecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                onClickItem.invoke(absoluteAdapterPosition)
            }
        }

        fun bind(item: Any) {
            onBindItem.invoke(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(list[position])

    override fun getItemCount(): Int = list.size
}