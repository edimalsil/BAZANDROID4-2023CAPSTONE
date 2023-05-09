package com.edith.movies.view.viewmodel


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.edith.movies.domain.GetMoviesUseCase
import com.edith.movies.domain.MoviesDbRepository
import com.edith.movies.uimodel.Movie
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule

import org.junit.Test

class MoviesViewModelTest {

    @RelaxedMockK
    private lateinit var getMoviesUseCase: GetMoviesUseCase
    @RelaxedMockK
    private lateinit var repository: MoviesDbRepository


    private lateinit var model: MoviesViewModel

    @get: Rule
    var rule: InstantTaskExecutorRule = InstantTaskExecutorRule()
    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        model = MoviesViewModel(getMoviesUseCase, repository)

        Dispatchers.setMain(Dispatchers.Unconfined)

    }
    @After
    fun onAfter(){
        Dispatchers.resetMain()
    }

    @Test
    fun `get all list of movies` () = runTest {

        // Given
        val listMovies = listOf(Movie(1, "/ovM06PdF3M8wvKb06i4sjW3xoww.jpg", "Winnie the Pooh", "/ovM06PdF3M8wvKb06i4sjW3xoww.jpg", "Winnie the Pooh"))
        coEvery { getMoviesUseCase() } returns listMovies

        //When

        model.getNowPlayingMovies()

        // Then

        assert(model.moviesModel.value == listMovies)


    }
}