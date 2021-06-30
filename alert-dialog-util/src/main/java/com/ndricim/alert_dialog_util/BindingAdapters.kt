package com.ndricim.alert_dialog_util

import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.google.android.material.card.MaterialCardView

@BindingAdapter("customTextColor")
fun customTextColor(
    textView: TextView,
    color: Int
) {
    textView.setTextColor(ContextCompat.getColor(textView.context, color))
}

@BindingAdapter("cardBackgroundColor")
fun cardBackgroundColor(
    card: MaterialCardView,
    backgroundColor: Int
) {
    try {
        card.setCardBackgroundColor(ContextCompat.getColor(card.context, backgroundColor))
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

@BindingAdapter("customTintColor")
fun tintColor(
    appCompatImageView: AppCompatImageView,
    tintColor: Int
) {
    appCompatImageView.setColorFilter(
        ContextCompat.getColor(appCompatImageView.context, tintColor),
        android.graphics.PorterDuff.Mode.MULTIPLY
    )
}