package com.edith.movies.domain

import com.edith.movies.uimodel.Movie
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test


class GetMoviesUseCaseTest{

    @RelaxedMockK
    private lateinit var repository: MoviesDbRepository
    lateinit var getMoviesUseCase: GetMoviesUseCase

    @Before
    fun onBefore(){
       MockKAnnotations.init(this)
        getMoviesUseCase = GetMoviesUseCase(repository)
    }

    @Test
    fun `when the api doesnt return anything then get values from database`()= runBlocking{

        // Given
        coEvery { repository.getAllNowPlayingMoviesApi() } returns emptyList()

        // When
        getMoviesUseCase()

        // Then
        coVerify(exactly = 1) { repository.getAllNowPlayingMoviesDb()  }

    }

    @Test
    fun `when the api return something then get values from api`() = runBlocking {

        // Given
        val listMovies = listOf(Movie(1, "/ovM06PdF3M8wvKb06i4sjW3xoww.jpg", "Winnie the Pooh", "/ovM06PdF3M8wvKb06i4sjW3xoww.jpg", "Winnie the Pooh"))
        coEvery { repository.getAllNowPlayingMoviesApi() } returns listMovies

        // When
        val response = getMoviesUseCase()

        //Then
        coVerify(exactly = 1) {repository.clearMovies()}
        coVerify(exactly = 1) {repository.insertMovies(any()) }
        coVerify(exactly = 0) { repository.getAllNowPlayingMoviesDb() }
        assert(response == listMovies)
    }
}