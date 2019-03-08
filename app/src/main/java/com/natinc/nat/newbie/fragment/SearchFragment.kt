package com.natinc.nat.newbie.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.natinc.nat.newbie.R
import com.natinc.nat.newbie.adapter.ArtistsSmallTilesAdapter
import com.natinc.nat.newbie.adapter.MediaSmallTilesAdapter
import com.natinc.nat.newbie.utility.AppTitles
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.nb_search_albums_list.*
import kotlinx.android.synthetic.main.nb_search_artists_list.*
import kotlinx.android.synthetic.main.nb_search_history_list.*
import kotlinx.android.synthetic.main.nb_search_top_result_list.*
import kotlinx.android.synthetic.main.nb_search_tracks_list.*
import kotlinx.android.synthetic.main.nb_toolbar_layout.*

class SearchFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val typeface = ResourcesCompat.getFont(context!!, R.font.comfortaa)
        toolbarTitleText.let {
            it.typeface = typeface
            it.text = AppTitles.Search.name
        }

        searchFragmentTopResultRecyclerView.apply {
            adapter = MediaSmallTilesAdapter()
            layoutManager = LinearLayoutManager(context!!, RecyclerView.VERTICAL, false)
            setHasFixedSize(true)
        }


        searchFragmentArtistsRecyclerView.apply {
            adapter = ArtistsSmallTilesAdapter()
            layoutManager = LinearLayoutManager(context!!, RecyclerView.VERTICAL, false)
            setHasFixedSize(true)
        }


        searchFragmentTracksRecyclerView.apply {
            adapter = MediaSmallTilesAdapter()
            layoutManager = LinearLayoutManager(context!!, RecyclerView.VERTICAL, false)
            setHasFixedSize(true)
        }


        searchFragmentAlbumsRecyclerView.apply {
            adapter = MediaSmallTilesAdapter()
            layoutManager = LinearLayoutManager(context!!, RecyclerView.VERTICAL, false)
            setHasFixedSize(true)
        }

        searchFragmentHistoryRecyclerView.apply {
            adapter = MediaSmallTilesAdapter()
            layoutManager = LinearLayoutManager(context!!, RecyclerView.VERTICAL, false)
            setHasFixedSize(true)
        }

    }

    override fun onResume() {
        super.onResume()
        activity!!.main_bottom_navigation_view.visibility = View.VISIBLE
    }

}
