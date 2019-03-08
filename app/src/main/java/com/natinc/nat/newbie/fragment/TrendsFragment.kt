package com.natinc.nat.newbie.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.natinc.nat.newbie.R
import com.natinc.nat.newbie.adapter.ArtistsMediumTilesAdapter
import com.natinc.nat.newbie.adapter.MediaMediumTilesAdapter
import com.natinc.nat.newbie.utility.AppTitles
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.nb_toolbar_layout.*
import kotlinx.android.synthetic.main.nb_trends_albums_list.*
import kotlinx.android.synthetic.main.nb_trends_artists_list.*
import kotlinx.android.synthetic.main.nb_trends_songs_list.*

class TrendsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trends, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val typeface = ResourcesCompat.getFont(context!!, R.font.comfortaa)
        toolbarTitleText.let {
            it.typeface = typeface
            it.text = AppTitles.Trends.name
        }


        trendsFragmentSongsRecyclerView.apply {
            adapter = MediaMediumTilesAdapter()
            layoutManager = LinearLayoutManager(context!!, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
        }

        trendsFragmentArtistRecyclerView.apply {
            adapter = ArtistsMediumTilesAdapter()
            layoutManager = LinearLayoutManager(context!!, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
        }

        trendsFragmentAlbumsRecyclerView.apply {
            adapter = MediaMediumTilesAdapter()
            layoutManager = LinearLayoutManager(context!!, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
        }
    }

    override fun onResume() {
        super.onResume()
        activity!!.main_bottom_navigation_view.visibility = View.VISIBLE
    }

}
