package com.bipuldevashish.pro_x.ui.fullScreenImage

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.transition.Visibility
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bipuldevashish.pro_x.R
import com.bipuldevashish.pro_x.databinding.FragmentDetailedImageBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*


class DetailedImageFragment : Fragment(R.layout.fragment_detailed_image) {


    private val TAG = "DetailedImageFragment"
    private val args by navArgs<DetailedImageFragmentArgs>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.window?.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
        val navBar: BottomNavigationView = requireActivity().findViewById(R.id.nav_view)
        navBar.visibility = INVISIBLE

        val binding = FragmentDetailedImageBinding.bind(view)

        binding.apply {
            val photo = args.photo

            Glide
                .with(this@DetailedImageFragment)
                .load(photo.src.large2x)
                .error(R.drawable.ic_round_erro_24)
                .listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(
                            e: GlideException?,
                            model: Any?,
                            target: Target<Drawable>?,
                            isFirstResource: Boolean
                    ): Boolean {
                        progressBar.isVisible = false
                        return false
                    }

                    override fun onResourceReady(
                            resource: Drawable?,
                            model: Any?,
                            target: Target<Drawable>?,
                            dataSource: DataSource?,
                            isFirstResource: Boolean
                    ): Boolean {
                        progressBar.isVisible = false
                        return false

                    }

                })

                .into(imageView)

        }
    }

    override fun onDetach() {
        super.onDetach()
        activity?.window?.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
        val navBar: BottomNavigationView = requireActivity().findViewById(R.id.nav_view)
        navBar.visibility = VISIBLE
    }
}