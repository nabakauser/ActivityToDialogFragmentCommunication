package com.example.activitytodialogfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment


class DialogFrag : DialogFragment() {
    private var uiTvText: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.dialog_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpUi(view)
    }

    private fun setUpUi(view: View) {
        val bundle = arguments
        uiTvText= view.findViewById(R.id.uiTvText)
        uiTvText?.text = bundle?.getString(Constants.TEXT)
    }

    fun updateText(data: String?) {
        uiTvText?.text = data
    }
}