package id.gits.gitsmvvmkotlin.data.source.remote

import id.gits.gitsmvvmkotlin.base.BaseApiModel
import id.gits.gitsmvvmkotlin.data.model.Movie
import id.gits.gitsmvvmkotlin.data.source.GitsDataSource
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by irfanirawansukirman on 26/01/18.
 */

object GitsRemoteDataSource : GitsDataSource {
    private val apiService = GitsApiService.create()

    override fun getMovies(callback: GitsDataSource.GetMoviesCallback) {
        apiService.getMovies()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ result ->

                    run {
                        if (result.results!!.isNotEmpty()) {
                            callback.onMoviesLoaded(result.results)
                        } else {
                            callback.onDataNotAvailable()
                        }
                    }

                }, { error ->
                    callback.onError(error.message)
                })
    }

    override fun getMovieById(movieId: Int, callback: GitsDataSource.GetMoviesByIdCallback) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun saveMovie(movie: Movie) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun remoteMovie(isRemote: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
