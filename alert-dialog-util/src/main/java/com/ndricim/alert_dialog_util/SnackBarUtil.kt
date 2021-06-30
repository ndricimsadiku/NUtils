package com.ndricim.alert_dialog_util

import android.app.Activity
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.ndricim.alert_dialog_util.databinding.CustomSnackbarBinding

fun createNewSnackBar(
    activity: Activity,
    view: View?,
    gravity: Int,
    rootView: View? = null
): Snackbar {
    val snackBar =
        Snackbar.make(
            rootView ?: activity.findViewById(android.R.id.content),
            "",
            Snackbar.LENGTH_INDEFINITE
        )
    snackBar.duration = 3000

    val layout = snackBar.view as Snackbar.SnackbarLayout
    val textView = layout.findViewById<View>(R.id.snackbar_text) as TextView
    textView.visibility = View.INVISIBLE

    layout.setPadding(0, 0, 0, 0)
    layout.addView(view, 0)

    val view: View = snackBar.view
    val params = view.layoutParams as FrameLayout.LayoutParams
    params.topMargin =
        when (gravity) {
            Gravity.TOP -> getStatusBarHeight(activity)
            Gravity.BOTTOM -> getNavigationBarHeight(activity)
            else -> 0
        }
    params.gravity = gravity
    view.layoutParams = params
    view.setBackgroundColor(
        ContextCompat.getColor(
            activity,
            android.R.color.transparent
        )
    )
    return snackBar
}

fun showSnackBar(
    activity: Activity,
    message: String,
    gravity: Int,
    icon: Int,
    backgroundColor: Int = R.color.colorStone,
    contentColor: Int = R.color.errorTextColor,
    rootView: View? = null
) {
    val snackViewBinding = CustomSnackbarBinding.inflate(activity.layoutInflater)
    snackViewBinding.image.setImageResource(icon)
    snackViewBinding.message.text = message
    snackViewBinding.backgroundColorInt = backgroundColor
    snackViewBinding.contentColor = contentColor

    val snackBar = createNewSnackBar(activity, snackViewBinding.root, gravity, rootView = rootView)
    snackViewBinding.motionLayout.setTransitionListener(getTransitionListener(snackBar))

    snackBar.show()
}

private fun getTransitionListener(snackBar: Snackbar): MotionLayout.TransitionListener {
    return object : MotionLayout.TransitionListener {

        override fun onTransitionStarted(p0: MotionLayout?, startId: Int, endId: Int) {

        }

        override fun onTransitionChange(
            p0: MotionLayout?,
            startId: Int,
            endId: Int,
            progress: Float
        ) {

        }

        override fun onTransitionCompleted(p0: MotionLayout?, currentId: Int) {
            snackBar.dismiss()
        }

        override fun onTransitionTrigger(
            p0: MotionLayout?,
            triggerId: Int,
            positive: Boolean,
            progress: Float
        ) {

        }
    }
}

fun showSuccessSnackBar(activity: Activity, message: String) {
    showSnackBar(
        activity,
        message,
        Gravity.TOP,
        R.drawable.ic_check_circle_white,
        R.color.colorGreen,
        R.color.colorStone
    )
}

fun showErrorSnackBar(activity: Activity, message: String, rootView: View? = null) {
    showSnackBar(
        activity,
        message,
        Gravity.TOP,
        R.drawable.ic_baseline_error_outline_24,
        R.color.colorError,
        R.color.colorStone,
        rootView = rootView
    )
}

fun showTopSnackBar(activity: Activity, message: String, icon: Int? = null) {
    showSnackBar(activity, message, Gravity.TOP, icon ?: R.drawable.ic_baseline_error_outline_24)
}

fun showInternetConnectionSnackBar(activity: Activity) {
    showTopSnackBar(
        activity,
        activity.getString(R.string.no_internet_connection),
        R.drawable.ic_baseline_wifi_off_24
    )
}