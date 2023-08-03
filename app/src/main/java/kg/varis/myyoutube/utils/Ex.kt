package kg.varis.myyoutube

import android.annotation.SuppressLint
import android.widget.ImageView
import com.bumptech.glide.Glide

@SuppressLint("CheckResult")
fun ImageView.loadImage(text: String) {
    Glide.with(this).load(text).into(this)
}