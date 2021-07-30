package io.github.hendrawd.sameheightitems

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import java.lang.IllegalStateException

class SatuDuaTigaAdapter: ListAdapter<Any, SatuDuaTigaAdapter.ViewHolder>(DiffCallback()) {

    private object ViewTypes{
        const val SATU = 1
        const val DUA =  2
        const val TIGA = 3
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            ViewTypes.SATU -> SatuViewHolder(inflater.inflate(R.layout.item_1, parent, false))
            ViewTypes.DUA -> DuaViewHolder(inflater.inflate(R.layout.item_2, parent, false))
            ViewTypes.TIGA -> TigaViewHolder(inflater.inflate(R.layout.item_3, parent, false))
            else -> throw IllegalStateException("dobol")
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // do nothing
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun getItemViewType(position: Int): Int {
        return when {
            position % 3 == 0 -> ViewTypes.SATU
            position % 3 == 1 -> ViewTypes.DUA
            position % 3 == 2 -> ViewTypes.TIGA
            else -> ViewTypes.SATU
        }
    }

    abstract class ViewHolder(view: View): RecyclerView.ViewHolder(view)

    class SatuViewHolder(view: View): ViewHolder(view)
    class DuaViewHolder(view: View): ViewHolder(view)
    class TigaViewHolder(view: View): ViewHolder(view)

    class DiffCallback : DiffUtil.ItemCallback<Any>() {
        override fun areItemsTheSame(oldItem: Any, newItem: Any) = false
        override fun areContentsTheSame(oldItem: Any, newItem: Any) = false
    }
}