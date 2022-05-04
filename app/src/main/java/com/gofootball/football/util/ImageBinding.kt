package com.gofootball.football.util

import android.graphics.drawable.PictureDrawable
import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.github.twocoffeesoneteam.glidetovectoryou.GlideApp
import com.github.twocoffeesoneteam.glidetovectoryou.SvgSoftwareLayerSetter
import com.gofootball.football.R

@BindingAdapter("android:imageUrl")
fun loadImage(imageView: ImageView, url: String) {
    Glide.with(imageView.context).load(url).into(imageView)
}

@BindingAdapter("imgFromUrl")
fun imgFromUrl(view: ImageView, url: String?) {
    Glide.with(view.context.applicationContext)
        .load(url)
        .placeholder(R.drawable.ic_ball)
        .apply(
            RequestOptions.circleCropTransform()
                .error(R.drawable.ic_ball)
        )
        .into(view)
}

