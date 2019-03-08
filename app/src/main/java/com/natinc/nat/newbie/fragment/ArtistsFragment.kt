package com.natinc.nat.newbie.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.natinc.nat.newbie.R
import com.natinc.nat.newbie.adapter.ArtistsSmallTilesAdapter
import com.natinc.nat.newbie.utility.LibraryTitles
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_artists.*
import kotlinx.android.synthetic.main.nb_toolbar_layout.*
import kotlinx.android.synthetic.main.nb_toolbar_layout.view.*


class ArtistsFragment : Fragment(), ArtistsSmallTilesAdapter.SetOnArtistSmallAdapterListener {

    override fun onArtistItemClick(position: Int) {
        NavHostFragment.findNavController(this).navigate(R.id.action_artistsFragment_to_playlistFragment)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        activity!!.main_bottom_navigation_view.visibility = GONE
        return inflater.inflate(R.layout.fragment_artists, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val typeface = ResourcesCompat.getFont(context!!, R.font.comfortaa)

        toolbar.apply {
            navigationIcon = AppCompatResources.getDrawable(context!!, R.drawable.ic_chevron_left_black_24dp)
            setNavigationOnClickListener {
                it.findNavController().navigateUp()
            }
            toolbarTitleText.let {
                it.typeface = typeface
                it.text = LibraryTitles.Artists.name
            }
        }

        artistsFragmentArtistsRecyclerView.apply {
            adapter = ArtistsSmallTilesAdapter(this@ArtistsFragment)
            layoutManager = LinearLayoutManager(context!!, RecyclerView.VERTICAL, false)
            setHasFixedSize(true)
        }

        artistsFragmentSearchFilter.setOnClickListener {
            Toast.makeText(context!!, "Toast", Toast.LENGTH_SHORT).show()
        }
    }

}
