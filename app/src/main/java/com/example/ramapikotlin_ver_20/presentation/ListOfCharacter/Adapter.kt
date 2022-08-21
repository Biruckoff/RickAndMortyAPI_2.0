package com.example.ramapikotlin_ver_20

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.ramapikotlin_ver_20.databinding.LocRecyclerViewItemBinding
import com.example.ramapikotlin_ver_20.domain.models.RAMCharacter
import com.squareup.picasso.Picasso


class Adapter(val listener: Listener) : PagingDataAdapter<RAMCharacter, Holder>(MovieDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
    val inflater = LayoutInflater.from(parent.context)
        val binding = LocRecyclerViewItemBinding.inflate(inflater,parent,false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
    val character = getItem(position)?:return
        with(holder.binding){
            textView.text = character.name
            Picasso.get().load(character.image).into(imageView)
            holder.itemView.setOnClickListener{
               listener.onClick(character)
            }
        }
    }
}

class MovieDiffCallBack : DiffUtil.ItemCallback<RAMCharacter>() {
    override fun areItemsTheSame(oldItem: RAMCharacter, newItem: RAMCharacter): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: RAMCharacter, newItem: RAMCharacter): Boolean {
        return oldItem == newItem
    }
}

class Holder(
val binding: LocRecyclerViewItemBinding
) : RecyclerView.ViewHolder(binding.root) {


}
interface Listener{
    fun onClick(result: RAMCharacter)
}