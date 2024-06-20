package com.example.orinugooriworldapp

import android.widget.EditText

class IsEmptyInput {
    fun isEmptyInput(etv: EditText): Boolean {

        return if (etv.text.isEmpty()) {
            true
        } else {
            false
        }

    }

}