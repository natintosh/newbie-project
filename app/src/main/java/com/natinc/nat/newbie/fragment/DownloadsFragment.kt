package com.natinc.nat.newbie.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.natinc.nat.newbie.R
import com.natinc.nat.newbie.adapter.MediaMediumTilesAdapter
import com.natinc.nat.newbie.adapter.MediaSmallTilesAdapter
import com.natinc.nat.newbie.utility.LibraryTitles
import kotlinx.android.synthetic.main.fragment_downloads.*
import kotlinx.android.synthetic.main.nb_toolbar_layout.*
import kotlinx.android.synthetic.main.nb_toolbar_layout.view.*

class DownloadsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_downloads, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val typeface = ResourcesCompat.getFont(context!!, R.font.comfortaa)

        toolbar.apply {
            navigationIcon = AppCompatResources.getDrawable(context!!, R.drawable.ic_chevron_left_black_48dp)
            setNavigationOnClickListener {
                it.findNavController().navigateUp()
            }
            toolbarTitleText.let {
                it.typeface = typeface
                it.text = LibraryTitles.Artists.name
            }
        }

        downloadsFragmentRecentlyDownloadedRecyclerView.apply {
            adapter = MediaMediumTilesAdapter()
            layoutManager = LinearLayoutManager(context!!, RecyclerView.HORIZONTAL, false)
            setHasFixedSize(true)
        }

        downloadsFragmentDownloadsRecyclerView.apply {
            adapter = MediaSmallTilesAdapter()
            val linearLayoutManager = LinearLayoutManager(context!!, RecyclerView.VERTICAL, false)
            layoutManager = linearLayoutManager
            setHasFixedSize(true)
        }

    }
}
