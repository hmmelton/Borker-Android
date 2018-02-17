package com.hmmelton.rescue.changehandlers

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.changehandler.AnimatorChangeHandler

/**
 * Created by harrisonmelton on 2/15/18.
 * [AnimatorChangeHandler] that slides views from left to right
 */
class LeftToRightChangeHandler : AnimatorChangeHandler() {
    override fun getAnimator(
        container: ViewGroup,
        from: View?,
        to: View?,
        isPush: Boolean,
        toAddedToContainer: Boolean
    ): Animator {
        val animatorSet = AnimatorSet()

        // Controller is being pushed on to the backstack
        if (isPush) {
            if (from != null) {
                animatorSet.play(
                    ObjectAnimator.ofFloat(
                        from,
                        View.TRANSLATION_X,
                        from.width.toFloat()
                    )
                )
            }
            if (to != null) {
                animatorSet.play(
                    ObjectAnimator.ofFloat(
                        to,
                        View.TRANSLATION_X,
                        -to.width.toFloat(),
                        0f
                    )
                )
            }
        } else {
            // Controller is being popped from backstack
            if (from != null) {
                animatorSet.play(
                    ObjectAnimator.ofFloat(
                        from,
                        View.TRANSLATION_X,
                        -from.width.toFloat()
                    )
                )
            }
            if (to != null) {
                // Allow this to have a nice transition when coming off an aborted push animation
                val fromLeft = from?.translationX ?: 0f
                animatorSet.play(
                    ObjectAnimator.ofFloat<View>(
                        to,
                        View.TRANSLATION_X,
                        to.width.toFloat() + fromLeft,
                        0f
                    )
                )
            }
        }

        return animatorSet
    }

    override fun resetFromView(from: View) {
        from.translationX = from.width.toFloat()
    }
}