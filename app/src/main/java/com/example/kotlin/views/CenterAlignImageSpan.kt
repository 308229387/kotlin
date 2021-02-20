package com.example.kotlin.views

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.text.style.ImageSpan

class CenterAlignImageSpan(d: Drawable?) : ImageSpan(d!!) {
    override fun draw(
        canvas: Canvas,
        text: CharSequence,
        start: Int,
        end: Int,
        x: Float,
        top: Int,
        y: Int,
        bottom: Int,
        paint: Paint
    ) {
        val b = drawable
        val extraOffsetY = 9
        var transY = y - b.bounds.bottom + extraOffsetY
        val maxTransY = bottom - b.bounds.bottom
        if (transY > maxTransY) {
            transY = maxTransY
        }
        canvas.save()
        canvas.translate(x, transY.toFloat())
        b.draw(canvas)
        canvas.restore()
    }

    companion object {
        const val SCALE_BOUNDS = 1f //0.9f;
        const val DRAWABLE_PADDING = 3
    }
}