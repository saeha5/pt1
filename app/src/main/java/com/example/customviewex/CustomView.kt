package com.example.customviewex

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.view_my_custom.view.*


@TargetApi(Build.VERSION_CODES.LOLLIPOP)
class CustomView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet?= null,
    defStyle: Int = 0,
    defStyleRes: Int = 0
) : LinearLayout(context,attrs,defStyle,defStyleRes){
    init {
        LayoutInflater.from(context).inflate(R.layout.view_my_custom, this,true)
        orientation = VERTICAL

        attrs?.let {

            val typedArray = context.obtainStyledAttributes(
                it,
                R.styleable.CustomView,
                0,
                0
            )
            val title = resources.getText(typedArray
                .getResourceId(
                    R.styleable.CustomView_my_custom_title,
                    R.string.view_title1
                ))

            my_title.text = title
            my_edit.hint = resources.getString(R.string.hint_text)

            typedArray.recycle()
        }
    }
}