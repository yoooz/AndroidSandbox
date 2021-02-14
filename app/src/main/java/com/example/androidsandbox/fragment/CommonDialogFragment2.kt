package com.example.androidsandbox.fragment

import android.content.Context
import androidx.appcompat.app.AlertDialog

class CommonDialogFragmentBuilder(context: Context): AlertDialog.Builder(context) {

    override fun create(): AlertDialog {
        val dialog = super.create();
        dialog.setCanceledOnTouchOutside(false)
        return dialog
    }
}