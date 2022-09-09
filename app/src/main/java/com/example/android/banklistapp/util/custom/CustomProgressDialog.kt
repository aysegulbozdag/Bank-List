package com.example.android.banklistapp.util.custom

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDialogFragment
import com.example.android.banklistapp.databinding.CustomProgressLayoutBinding


class CustomProgressDialog() : AppCompatDialogFragment() {

    private lateinit var binding: CustomProgressLayoutBinding

    private var mProgressContentText: String = ""
    private var mIsProgressCancelable: Boolean = false

    constructor(progressContentText: String, isDialogCancelable: Boolean) : this() {
        this.mProgressContentText = progressContentText
        this.mIsProgressCancelable = isDialogCancelable
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder: AlertDialog.Builder = AlertDialog.Builder(it)
            binding = CustomProgressLayoutBinding.inflate(LayoutInflater.from(context))

            val alertDialog = builder
                .setView(binding.root)
                .create()

            alertDialog.setCanceledOnTouchOutside(mIsProgressCancelable)
            alertDialog.show()
            alertDialog
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    override fun onResume() {
        super.onResume()
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }
}