package com.natinc.nat.newbie.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.natinc.nat.newbie.R
import kotlinx.android.synthetic.main.activity_main.*


class PlayFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        activity!!.main_bottom_navigation_view.visibility = View.GONE
        return inflater.inflate(R.layout.fragment_play, container, false)
    }


}
