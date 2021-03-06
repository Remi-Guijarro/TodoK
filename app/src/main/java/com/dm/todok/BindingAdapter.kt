package com.dm.todok

import android.widget.ImageView
import androidx.core.view.updatePaddingRelative
import androidx.databinding.BindingAdapter
import coil.load
import coil.metadata
import coil.size.Size
import coil.transform.CircleCropTransformation

@BindingAdapter("app:avatar")
fun setAvatar(imageView: ImageView, avatarUrl: String?) {
    imageView.load(avatarUrl) {
        size(1000)
    }
}

@BindingAdapter("app:avatar_thumbnail")
fun setAvatarThumbnail(imageView: ImageView, avatarUrl: String?) {
    imageView.load(avatarUrl) {
        transformations(CircleCropTransformation())
        size(350)
    }
}
