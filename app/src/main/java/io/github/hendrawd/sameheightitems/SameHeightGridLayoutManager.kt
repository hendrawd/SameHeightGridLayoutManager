package io.github.hendrawd.sameheightitems

import android.content.Context
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager

class SameHeightGridLayoutManager(context: Context, spanCount: Int) :
    GridLayoutManager(context, spanCount) {

    var heightestHeight = 0

    override fun getDecoratedMeasuredHeight(child: View): Int {
        val height = super.getDecoratedMeasuredHeight(child)
        heightestHeight = if (height > heightestHeight) {
            height
        } else {
            heightestHeight
        }
        Log.e("hendrawd", "getDecoratedMeasuredHeight: $heightestHeight")
        return heightestHeight

    }
}