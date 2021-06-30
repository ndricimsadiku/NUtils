package com.ndricim.alert_dialog_util

import android.content.Context

private const val STATUS_BAR_HEIGHT = "status_bar_height"
private const val NAVIGATION_BAR_HEIGHT = "navigation_bar_height"

fun getSystemRelatedDimen(context: Context, key: String): Int {
    val resources = context.resources
    val resourceId = resources.getIdentifier(key, "dimen", "android")
    return if (resourceId > 0) {
        resources.getDimensionPixelSize(resourceId)
    } else 0
}

fun getStatusBarHeight(context: Context): Int {
    return getSystemRelatedDimen(context, STATUS_BAR_HEIGHT)
}

fun getNavigationBarHeight(context: Context): Int {
    return getSystemRelatedDimen(
        context,
        NAVIGATION_BAR_HEIGHT
    )
}