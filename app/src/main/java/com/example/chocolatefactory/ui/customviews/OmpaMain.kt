package com.example.chocolatefactory.ui.customviews

import android.content.Context
import android.util.AttributeSet
import androidx.core.text.bold
import androidx.core.text.buildSpannedString
import com.example.chocolatefactory.domain.OmpaWorker
import com.example.chocolatefactory.domain.OmpaWorkerDetails

class OmpaMain @JvmOverloads constructor(
    context: Context,
    attrs : AttributeSet? = null,
    defStyleAttr :Int = 0
): androidx.appcompat.widget.AppCompatTextView(context,attrs,defStyleAttr){

    fun setWorker(ompaWorker: OmpaWorker) = with(ompaWorker){
        text = buildSpannedString {

            bold { append(firstName) }
            append(" ")
            bold { append(lastName) }
        }
    }
}