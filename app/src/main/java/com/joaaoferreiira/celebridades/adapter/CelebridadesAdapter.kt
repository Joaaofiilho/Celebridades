package com.joaaoferreiira.celebridades.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.joaaoferreiira.celebridades.R
import com.joaaoferreiira.celebridades.database.entity.CelebridadeEntity
import kotlinx.android.synthetic.main.holder_celebridade.view.*
import android.view.animation.AnimationUtils.loadAnimation
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.joaaoferreiira.celebridades.database.entity.Celebridade

class CelebridadesAdapter(val context: Context, val onItemClicked: (itemView: View, id: Int) -> Unit): RecyclerView.Adapter<CelebridadesAdapter.CelebridadeViewHolder>() {
    private val items = mutableListOf<Celebridade>()
    private var lastPosition = -1

    fun atualizar(items: List<Celebridade>) {
        with(this.items) {
            clear()
            addAll(items)
        }
        notifyDataSetChanged()
    }

    private fun getItemAt(position: Int): Celebridade? {
        return if(position < items.size && position >= 0) {
            items[position]
        } else {
            null
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CelebridadeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.holder_celebridade, parent, false)
        return CelebridadeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    //Chamado para parar a animacao quando a view sai da tela
    override fun onViewDetachedFromWindow(holder: CelebridadeViewHolder) {
        super.onViewDetachedFromWindow(holder)
        holder.clearAnimation()
    }

    override fun onBindViewHolder(holder: CelebridadeViewHolder, position: Int) {
        getItemAt(position)?.let { holder.bind(it, onItemClicked) }
        //Anima o item quando ele fica visivel (onBindViewHolder eh chamado quando o item fica visivel)
        setAnimation(holder.itemView, position)
    }

    class CelebridadeViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bind(item: Celebridade, onItemClicked: (itemView: View, id: Int) -> Unit) {
            with(itemView) {
                Glide.with(context)
                    .load(item.celebridade?.imagem)
                    .apply(RequestOptions().dontTransform())
                    .into(imagemCelebridade)
                nomeCelebridade.text = item.celebridade?.nome
                container.setOnClickListener { onItemClicked(itemView, item.celebridade?.id ?: -1) }
            }
        }

        fun clearAnimation() {
            itemView.clearAnimation()
        }
    }

    private fun setAnimation(viewToAnimate: View, position: Int) {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition) {
            val animation = loadAnimation(context, R.anim.item_animation_from_right)
            viewToAnimate.startAnimation(animation)
            lastPosition = position
        }
    }
}