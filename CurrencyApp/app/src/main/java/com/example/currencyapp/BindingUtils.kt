package com.example.currencyapp

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


@BindingAdapter("setText")
fun TextView.setRate(item:String){
    item.let{
        text = item
    }
}

@BindingAdapter("setFlagImage")
@Suppress("SENSELESS_COMPARISON")
fun ImageView.setFlagPics(item:String)
{
    item.let {
        Glide.with(context).load("https:www.countryflags.io/"+item.substring(0,2)+"/flat/64.png")
            .apply(RequestOptions()).into(this)
    }
}


