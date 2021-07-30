package io.github.hendrawd.sameheightitems

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.GridView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rv = findViewById<RecyclerView>(R.id.rv)
        val gv = findViewById<GridView>(R.id.gv)
        val gridLayoutManager = GridLayoutManager(this, 2)
        val sameHeightGridLayoutManager = SameHeightGridLayoutManager(this, 2)
        val flexboxLayoutManager = FlexboxLayoutManager(this)
        flexboxLayoutManager.setFlexDirection(FlexDirection.COLUMN);
        flexboxLayoutManager.setJustifyContent(JustifyContent.FLEX_END);
        val staggeredGridLayoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
//        staggeredGridLayoutManager.gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_NONE
        rv.layoutManager = sameHeightGridLayoutManager
        rv.setHasFixedSize(true)
        val decoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        rv.addItemDecoration(decoration)
        rv.adapter = SatuDuaTigaAdapter()
    }
}