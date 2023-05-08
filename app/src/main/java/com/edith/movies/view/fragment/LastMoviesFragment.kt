package com.edith.movies.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.edith.movies.databinding.FragmentLastMoviesBinding
import com.edith.movies.view.adapter.MoviesAdapter
import com.edith.movies.view.viewmodel.MoviesViewModel
import com.edith.remote.model.MovieDb
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LastMoviesFragment : Fragment() {
    private var _binding: FragmentLastMoviesBinding? = null
    private val binding get() = _binding!!
    private val moviesViewModel: MoviesViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLastMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObservers()
        moviesViewModel.getMovies()
    }

    private fun setupObservers() {
        moviesViewModel.movies.observe(viewLifecycleOwner) {
            renderList(it)
        }
    }

    private fun renderList(list: List<MovieDb>) {
        val moviesAdapter = MoviesAdapter()
        moviesAdapter.submitList(list)

        binding.rvMoviesLast.apply {
            context?.let { ctx ->
                layoutManager = GridLayoutManager(ctx, 3)
                setHasFixedSize(true)
                adapter = moviesAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}