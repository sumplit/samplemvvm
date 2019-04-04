package id.gits.gitsmvvmkotlin.mvvm.maindetail

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import id.gits.gitsmvvmkotlin.data.model.Movie
import id.gits.gitsmvvmkotlin.data.source.GitsDataSource
import id.gits.gitsmvvmkotlin.data.source.GitsRepository
import id.gits.gitsmvvmkotlin.util.SingleLiveEvent

class MainDetailViewModel(context: Application, private val gitsRepository: GitsRepository) : AndroidViewModel(context) {

    var errorMessageToast = SingleLiveEvent<String>()
    val movieTitle = SingleLiveEvent<String>()
    var movieRating = SingleLiveEvent<String>()
    var movieDateRelease = SingleLiveEvent<String>()
    var movieDescription = SingleLiveEvent<String>()
    var movieImageBackdropUrl = SingleLiveEvent<String>()

    fun getMovieById(movieId: Int){
        gitsRepository.getMovieById(movieId, object : GitsDataSource.GetMoviesByIdCallback{
            override fun onMovieLoaded(movie: Movie) {
                movieTitle.value = movie.title
                movieRating.value = movie.vote_average.toString()
                movieDescription.value = movie.overview
                movieDateRelease.value = movie.release_date
                movieImageBackdropUrl.value = "http://image.tmdb.org/t/p/w500${movie.backdrop_path}"
            }

            override fun onError(errorMessage: String?) {
                errorMessageToast.value = errorMessage
            }

        })
    }
}
