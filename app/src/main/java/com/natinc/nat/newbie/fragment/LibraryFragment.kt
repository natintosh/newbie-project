package com.natinc.nat.newbie.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.natinc.nat.newbie.R
import com.natinc.nat.newbie.adapter.ItemSmallAdapter
import com.natinc.nat.newbie.adapter.MediaMediumTilesAdapter
import com.natinc.nat.newbie.utility.AppTitles
import com.natinc.nat.newbie.utility.LibraryTitles
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_library.*
import kotlinx.android.synthetic.main.nb_toolbar_layout.*

class LibraryFragment : Fragment(), ItemSmallAdapter.SetOnItemSmallAdapterListener {

    private var data: List<LibraryTitles> = LibraryTitles.values().toList()

    override fun onItemSmallClickListener(position: Int) {
        when (position) {
            0 -> NavHostFragment.findNavController(this).navigate(R.id.action_libraryFragment_to_downloadsFragment)
            1 -> NavHostFragment.findNavController(this).navigate(R.id.action_libraryFragment_to_tracksFragment)
            2 -> NavHostFragment.findNavController(this).navigate(R.id.action_libraryFragment_to_artistsFragment)
            3 -> NavHostFragment.findNavController(this).navigate(R.id.action_libraryFragment_to_albumsFragment)
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_library, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val typeface = ResourcesCompat.getFont(context!!, R.font.comfortaa)
        toolbarTitleText.let {
            it.typeface = typeface
            it.text = AppTitles.Library.name
        }


        libraryFragmentLibraryRecyclerView.apply {
            adapter = ItemSmallAdapter(context, data, this@LibraryFragment)
            layoutManager = LinearLayoutManager(context!!, RecyclerView.VERTICAL, false)
            setHasFixedSize(true)
        }

        libraryFragmentRecentlyPlayedRecyclerView.apply {
            adapter = MediaMediumTilesAdapter()
            layoutManager = LinearLayoutManager(context!!, RecyclerView.HORIZONTAL, false)
            setHasFixedSize(true)
        }
    }

    override fun onResume() {
        super.onResume()
        activity!!.main_bottom_navigation_view.visibility = View.VISIBLE
    }

}
