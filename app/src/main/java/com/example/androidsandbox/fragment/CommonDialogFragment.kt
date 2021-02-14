package com.example.androidsandbox.fragment

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import java.io.Serializable

class CommonDialogFragment: DialogFragment() {
    private var title: String? = null
    private var message: String? = null
    private var positiveButtonTitle: String? = null
    private var negativeButtonTitle: String? = null
    private var callback: Callback? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let { arguments ->
            title = arguments.getString(TITLE_KEY)
            message = arguments.getString(MESSAGE_KEY)
            positiveButtonTitle = arguments.getString(POSITIVE_BUTTON_TITLE_KEY)
            negativeButtonTitle = arguments.getString(NEGATIVE_BUTTON_TITLE_KEY)
            callback = arguments.getSerializable(CALLBACK_KEY) as? Callback
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
                .setTitle(title)
                .setMessage(message)

        positiveButtonTitle?.let { buttonTitle ->
            builder.setPositiveButton(buttonTitle) { _, _ ->
                callback?.onClickPositiveButton()
            }
        }
        negativeButtonTitle?.let { buttonTitle ->
            builder.setNegativeButton(buttonTitle) { _, _ ->
                callback?.onClickNegativeButton()
            }
        }
        val dialog = builder.create()
        dialog.setCanceledOnTouchOutside(false)
        return dialog
    }

    companion object {
        interface Callback: Serializable {
            fun onClickPositiveButton()
            fun onClickNegativeButton()
        }

        private const val TITLE_KEY = "title"
        private const val MESSAGE_KEY = "message"
        private const val POSITIVE_BUTTON_TITLE_KEY = "positiveButtonTitle"
        private const val NEGATIVE_BUTTON_TITLE_KEY = "negativeButtonTitle"
        private const val CALLBACK_KEY = "callback"

        fun show(manager: FragmentManager, title: String, message: String,
                 positiveButtonTitle: String, negativeButtonTitle: String, callback: Callback) {
            val bundle = Bundle().apply {
                putString(TITLE_KEY, title)
                putString(MESSAGE_KEY, message)
                putString(POSITIVE_BUTTON_TITLE_KEY, positiveButtonTitle)
                putString(NEGATIVE_BUTTON_TITLE_KEY, negativeButtonTitle)
                putSerializable(CALLBACK_KEY, callback)
            }

            CommonDialogFragment().apply {
                arguments = bundle
            }.show(manager.beginTransaction(), CommonDialogFragment::class.java.simpleName)

        }
    }
}