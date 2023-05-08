package com.edith.movies.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

import com.edith.movies.databinding.ViewMovieItemBinding
import com.edith.movies.uimodel.Movie

class NowPlayingAdapter(private val onClickListener: OnClickListener) :
    ListAdapter<Movie, NowPlayingAdapter.ViewHolder>(DiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ViewMovieItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(getItem(position)) {
                val im = "https://image.tmdb.org/t/p/w500/"
                binding.tvTitle.text = this.title
                com.bumptech.glide.Glide.with(binding.ivMoview)
                    .load(im + this.backdrop_path)
                    .into(binding.ivMoview)

            }
                .view.setOnClickListener {
                    onClickListener.onClick(getItem(position))
                }

        }
    }

    class OnClickListener(val clickListener: (movie: Movie) -> Unit) {
        fun onClick(movie: Movie) = clickListener(movie)
    }

    inner class ViewHolder(val binding: ViewMovieItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    class DiffUtilCallback : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean =
            oldItem.id == newItem.id

    }

}