package com.natinc.nat.newbie.fragment


import android.app.Activity
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.palette.graphics.Palette
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition
import com.natinc.nat.newbie.R
import com.natinc.nat.newbie.adapter.PlaylistAdapter
import com.natinc.nat.newbie.ui.PlayerActionView
import com.natinc.nat.newbie.utility.BlurTransformation
import com.natinc.nat.newbie.utility.GlideApp
import com.natinc.nat.newbie.utility.PlayDrawerIconClickListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_play.*


class PlayFragment : Fragment(), PlayerActionView.PlayerActionListener {

    fun createPaletteSync(bitmap: Bitmap): Palette = Palette.from(bitmap).generate()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        activity!!.main_bottom_navigation_view.visibility = View.GONE
        PlayerActionView.setPlayerActionListener(this)
        return inflater.inflate(R.layout.fragment_play, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val blurTransformation = BlurTransformation(context!!)
        val blurLayout = linearLayout


        val imageBitmap = (context!!.getDrawable(R.drawable.img_tiles_bg) as BitmapDrawable).bitmap
        val palette = createPaletteSync(imageBitmap)
        val vibrantColorSwatch = palette.vibrantSwatch
        val rgbColor = vibrantColorSwatch!!.rgb
        playFragmentDrawerLayout.setBackgroundColor(rgbColor)

        val displayMetrics = DisplayMetrics()
        (context as Activity).windowManager.defaultDisplay.getMetrics(displayMetrics)
        val deviceWidth = displayMetrics.widthPixels

        val translateX =
           (deviceWidth - context!!.resources.getDimensionPixelSize(R.dimen.nb_player_reveal_width))


        playFragmentPlaylistRecyclerView.apply {
            layoutParams.width = translateX
            adapter = PlaylistAdapter()
            layoutManager = LinearLayoutManager(context!!, RecyclerView.VERTICAL, false)
            setHasFixedSize(true)
        }
        val drawerAction = PlayDrawerIconClickListener(
            activity!!,
            linearLayout,
            AccelerateDecelerateInterpolator(),
            context!!.getDrawable(R.drawable.ic_chevron_left_black_24dp),
            context!!.getDrawable(R.drawable.ic_chevron_right_black_24dp)
        )

        toolbar.apply {
            setNavigationOnClickListener {
                it.findNavController().navigateUp()
            }
            setOnMenuItemClickListener {

                when (it.itemId) {
                    R.id.action_play_drawer -> {
                        it.setIcon(R.drawable.ic_chevron_right_black_24dp)
                        drawerAction.onClick(it)
                    }
                }
                return@setOnMenuItemClickListener true
            }
        }

        GlideApp.with(this)
            .asDrawable()
            .centerCrop()
            .load(R.drawable.img_tiles_bg)
            .transform(blurTransformation)
            .into(object : SimpleTarget<Drawable>() {
                override fun onResourceReady(
                    resource: Drawable,
                    transition: Transition<in Drawable>?
                ) {
                    blurLayout!!.background = resource
                }

            })
    }

    override fun onPlayClick() {

    }

    override fun onPauseClick() {

    }

    override fun onSkipPrevious() {

    }

    override fun onSkipNext() {

    }


}
