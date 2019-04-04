package id.gits.gitsmvvmkotlin.mvvm.main

import android.arch.lifecycle.MutableLiveData
import android.databinding.BindingAdapter
import android.databinding.ObservableList
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.google.gson.Gson
import id.gits.gitsmvvmkotlin.data.model.Movie

/**
 * Created by irfanirawansukirman on 26/01/18.
 */

object MainBindings {

    @BindingAdapter("movieList")
    @JvmStatic
    fun setListMovie(recyclerView: RecyclerView, data: List<Movie>?){
        with(recyclerView.adapter as MainAdapter){
            replaceData(data)
        }
    }

}