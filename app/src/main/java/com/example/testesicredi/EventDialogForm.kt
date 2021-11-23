package com.example.testesicredi

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import java.lang.IllegalStateException

class EventDialogForm: DialogFragment() {


//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        getDialog()!!.getWindow()?.setBackgroundDrawableResource(R.drawable.round_corner);
//        return inflater.inflate(R.layout.layout_form, container, false)
//        val btnCancel: Button = findViewById(R.id.btnCancel)
//        btnCancel.setText("DEUCERTO")
//    }
//
//    override fun onStart() {
//        super.onStart()
//        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
//        val height = (resources.displayMetrics.heightPixels * 0.40).toInt()
//        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
//
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView: View = inflater.inflate(R.layout.layout_form, container, false)


        return rootView
    }


}