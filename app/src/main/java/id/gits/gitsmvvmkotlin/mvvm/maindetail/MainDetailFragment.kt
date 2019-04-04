package id.gits.gitsmvvmkotlin.mvvm.maindetail

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.gits.gitsmvvmkotlin.base.BaseFragment
import id.gits.gitsmvvmkotlin.databinding.MainDetailFragmentBinding

class MainDetailFragment : BaseFragment() {

    private lateinit var viewBinding: MainDetailFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        viewBinding = MainDetailFragmentBinding.inflate(inflater, container, false).apply {
            viewModel = (activity as MainDetailActivity).obtainViewModel()
        }

        return viewBinding.root
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.viewModel?.apply {
            errorMessageToast.observe(this@MainDetailFragment, Observer {
                if (it!=null) {

                }
            })
        }

        val movieId = arguments.getInt("movieId")
        viewBinding.viewModel?.getMovieById(movieId)
    }

    companion object {
        fun newInstance(movieId: Int): MainDetailFragment {
            val args = Bundle()

            args.putInt("movieId", movieId)

            val fragment = MainDetailFragment()

            fragment.arguments = args

            return fragment
        }
    }

}
