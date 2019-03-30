package com.natinc.nat.newbie.ui

import android.content.Context
import android.graphics.drawable.AnimatedVectorDrawable
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.LinearLayout
import com.natinc.nat.newbie.R


class PlayerActionView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    init {
        init(context)
    }

    interface PlayerActionListener {
        fun onPlayClick()
        fun onPauseClick()
        fun onSkipPrevious()
        fun onSkipNext()
    }

    var playerActionCallback: PlayerActionListener? = PlayerActionView.callback

    private var mCurrentDrawable = 0

    private val animDRAWABLES =
        intArrayOf(R.drawable.anim_vect_ic_pausetoplay, R.drawable.anim_vect_ic_playtopause)

    private lateinit var playPauseButton: ImageView
    private lateinit var skipPreviousButton: ImageView
    private lateinit var skipNextButton: ImageView

    private fun init(context: Context) {

        orientation = HORIZONTAL
        inflate(context, R.layout.content_play_layout, this)

        playPauseButton = findViewById(R.id.playPauseButton)
        skipPreviousButton = findViewById(R.id.skipPreviousButton)
        skipNextButton = findViewById(R.id.skipNextButton)

        playPauseButton.setOnClickListener {
            performPlayPauseAction(it as ImageView)
        }

        skipNextButton.setOnClickListener {
            performSkipNextAction()
        }

        skipPreviousButton.setOnClickListener {
            performSkipPreviousAction()
        }

    }

    private fun performSkipPreviousAction() {
        playerActionCallback?.onSkipPrevious()
    }

    private fun performSkipNextAction() {
        playerActionCallback?.onSkipNext()
    }


    private fun performPlayPauseAction(view: ImageView) {
        mCurrentDrawable = (mCurrentDrawable + 1) % animDRAWABLES.size
        val drawableCompat =
            context.getDrawable(animDRAWABLES[mCurrentDrawable]) as AnimatedVectorDrawable
        view.setImageDrawable(drawableCompat)
        drawableCompat.start()

        if (mCurrentDrawable != 0) {
            playerActionCallback?.onPauseClick()
            return
        }
        playerActionCallback?.onPlayClick()
    }

    companion object {

        lateinit var callback: PlayerActionListener

        fun setPlayerActionListener(playerActionListener: PlayerActionListener) {
            callback = playerActionListener
        }

    }

}