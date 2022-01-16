package com.himawanmasyaid.newsapp.common.extensions

import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestListener
import com.himawanmasyaid.newsapp.R


fun ImageView.loadUrl(
    url: String?,
    placeholderResId: Int? = null,
    errorResId: Int? = null,
    requestListener: RequestListener<Drawable>? = null
) {
    Glide.with(this)
        .load(url)
        .optionalFitCenter()
        .thumbnail(0.1f)
        .error(R.drawable.ic_broken_image)
        .apply {
            placeholderResId?.let { placeholder(it) }
            errorResId?.let { error(it) }
            requestListener?.let { listener(it) }
        }
        .into(this)
}

fun ImageView.loadUrlRounded(
    url: String?,
    cornerRadius: Int = 14,
    placeholderResId: Int? = null,
    errorResId: Int? = null,
    requestListener: RequestListener<Drawable>? = null
) {
    Glide.with(this)
        .load(url)
        .optionalFitCenter()
        .thumbnail(0.1f)
        .error(R.drawable.ic_broken_image)
        .transform(CenterCrop(), RoundedCorners(cornerRadius))
        .apply {
            placeholderResId?.let { placeholder(it) }
            errorResId?.let { kotlin.error(it) }
            requestListener?.let { listener(it) }
        }
        .into(this)
}
