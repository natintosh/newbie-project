package com.natinc.nat.newbie.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.natinc.nat.newbie.R
import com.natinc.nat.newbie.adapter.ItemSmallTilesAdapter
import com.natinc.nat.newbie.adapter.MediaLargeTilesAdapter
import com.natinc.nat.newbie.adapter.MediaMediumTilesAdapter
import com.natinc.nat.newbie.utility.AppTitles
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.nb_explore_browse_list.*
import kotlinx.android.synthetic.main.nb_explore_new_content_list.*
import kotlinx.android.synthetic.main.nb_explore_popular_list.*
import kotlinx.android.synthetic.main.nb_toolbar_layout.*

class ExploreFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_explore, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val typeface = ResourcesCompat.getFont(context!!, R.font.comfortaa)
        toolbarTitleText.apply {
            setTypeface(typeface)
            text = AppTitles.Explore.name
        }

        browseFragmentBrowseRecyclerView.apply {
            adapter = ItemSmallTilesAdapter()
            layoutManager = LinearLayoutManager(context!!, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
        }

        browseFragmentNewReleaseRecyclerView.apply {
            adapter = MediaLargeTilesAdapter()
            layoutManager = LinearLayoutManager(context!!, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
        }

        browseFragmentPopularRecyclerView.apply {
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
