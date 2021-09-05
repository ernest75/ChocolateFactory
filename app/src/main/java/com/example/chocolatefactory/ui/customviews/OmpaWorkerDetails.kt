package com.example.chocolatefactory.ui.customviews

import android.content.Context
import android.util.AttributeSet
import androidx.core.text.bold
import androidx.core.text.buildSpannedString
import com.example.chocolatefactory.common.formatHtml
import com.example.chocolatefactory.domain.OmpaWorkerDetails

class OmpaWorkerDetailsView @JvmOverloads constructor(
    context: Context,
    attrs : AttributeSet? = null,
    defStyleAttr :Int = 0
): androidx.appcompat.widget.AppCompatTextView(context,attrs,defStyleAttr){

    fun setWorkerDetails(ompaWorkerDetails: OmpaWorkerDetails) = with(ompaWorkerDetails){
        text = buildSpannedString {

            bold { append("First name: ") }
            appendLine(firstName)

            bold { append("LastName: ") }
            appendLine(lastName)

            bold { append("Age: ") }
            appendLine(age.toString())

            bold { append("Gender: ") }
            appendLine(gender)

            bold { append("Country: ") }
            appendLine(country)

            bold { append("Profession: ") }
            appendLine(profession)

            bold { append("Height: ") }
            appendLine(height.toString())

            bold { append("Email: ") }
            appendLine(email)

            bold { append("Favorite color: ") }
            appendLine(favorite.color)

            bold { append("Favorite food: ") }
            appendLine(favorite.food)

            bold { append("Quota: ") }
            appendLine(quota)

            bold { append("Description: ") }
            appendLine(description.formatHtml())

            bold { append("Song: ") }
            appendLine(favorite.song)

            bold { append("Random string: ") }
            appendLine(favorite.song)

        }
    }
}