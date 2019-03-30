package com.natinc.nat.newbie.fragment

import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.palette.graphics.Palette
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.natinc.nat.newbie.R
import com.natinc.nat.newbie.adapter.MediaSmallTilesAdapter
import com.natinc.nat.newbie.utility.BlurTransformation
import com.natinc.nat.newbie.utility.GlideApp
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_playlist.*

class PlaylistFragment : Fragment() {

    fun createPaletteSync(bitmap: Bitmap): Palette = Palette.from(bitmap).generate()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        activity!!.main_bottom_navigation_view.visibility = View.GONE
        return inflater.inflate(R.layout.fragment_playlist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Toolbar>(R.id.toolbar).apply {
            title = "Cardi B"
            val activity: AppCompatActivity = activity as AppCompatActivity
            activity.setSupportActionBar(toolbar)
            navigationIcon = AppCompatResources.getDrawable(context!!, R.drawable.ic_chevron_left_black_48dp)
            setNavigationOnClickListener {
                it.findNavController().navigateUp()
            }


            val blurTransformation = BlurTransformation(context!!)
            val bluImageView = blurimage
            val imageBitmap = (bluImageView.drawable as BitmapDrawable).bitmap
            val palette = createPaletteSync(imageBitmap)
            val vibrantColorSwatch = palette.vibrantSwatch
            val textColor = vibrantColorSwatch!!.titleTextColor

            setTitleTextColor(textColor)

            GlideApp.with(this)
                .asBitmap()
                .load(R.drawable.img_tiles_bg)
                .transform(blurTransformation)
                .into(bluImageView)
        }

        playlistFragmentPlaylistRecyclerView.apply {
            adapter = MediaSmallTilesAdapter()
            val linearLayoutManager = LinearLayoutManager(context!!, RecyclerView.VERTICAL, false)
            layoutManager = linearLayoutManager
            setHasFixedSize(true)
        }
    }
}
