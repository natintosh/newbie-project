package com.natinc.nat.newbie.utility

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.app.Activity
import android.content.Context
import android.graphics.drawable.Drawable
import android.util.DisplayMetrics
import android.view.MenuItem
import android.view.View
import android.view.animation.Interpolator
import com.natinc.nat.newbie.R

class PlayDrawerIconClickListener constructor(
    private val context: Context,
    private val sheet: View,
    private val interpolator: Interpolator? = null,
    private val openIcon: Drawable? = null,
    private val closeIcon: Drawable? = null
) {


    private val animatorSet = AnimatorSet()
    private val width: Int
    private var backdropShown = false

    init {
        val displayMetrics = DisplayMetrics()
        (context as Activity).windowManager.defaultDisplay.getMetrics(displayMetrics)
        width = displayMetrics.widthPixels
    }

    fun onClick(item: MenuItem) {
        backdropShown = !backdropShown

        // Cancel the existing animations
        animatorSet.removeAllListeners()
        animatorSet.end()
        animatorSet.cancel()

        updateIcon(item)

        val translateX =
            -1 * (width - context.resources.getDimensionPixelSize(R.dimen.nb_player_reveal_width))

        val animator = ObjectAnimator.ofFloat(
            sheet,
            "translationX",
            (if (backdropShown) translateX else 0).toFloat()
        )
        animator.duration = 500
        if (interpolator != null) {
            animator.interpolator = interpolator
        }
        animatorSet.play(animator)
        animator.start()
    }

    private fun updateIcon(item: MenuItem) {
        if (openIcon != null && closeIcon != null) {

            if (backdropShown) {
                item.setIcon(closeIcon)
            } else {
                item.setIcon(openIcon)
            }
        }
    }
}