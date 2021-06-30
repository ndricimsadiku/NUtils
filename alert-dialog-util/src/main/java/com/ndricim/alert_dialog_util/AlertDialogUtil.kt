package com.ndricim.alert_dialog_util

import android.app.Activity
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.ndricim.alert_dialog_util.databinding.AlertErrorBinding

private fun getNewAlertDialog(
    activity: Activity,
    isCancelable: Boolean,
    view: View? = null
): AlertDialog {
    val alertDialog: AlertDialog
    val builder =
        AlertDialog.Builder(activity)
    builder.setCancelable(isCancelable)
    if (view != null) {
        builder.setView(view)
    }
    alertDialog = builder.create()
    val window = alertDialog.window
    window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    return alertDialog
}

fun showErrorDialog(activity: Activity, errors: String) {
    val alertValidationErrorBinding =
        AlertErrorBinding.inflate(activity.layoutInflater)
    val alertDialog = getNewAlertDialog(activity, true, alertValidationErrorBinding.root)

    alertValidationErrorBinding.alertMessage.text = errors
    alertValidationErrorBinding.okButton.setOnClickListener {
        alertDialog.cancel()
    }

    alertDialog.show()

}