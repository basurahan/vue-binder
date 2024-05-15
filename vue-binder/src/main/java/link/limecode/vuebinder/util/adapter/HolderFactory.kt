package link.limecode.vuebinder.util.adapter

import android.view.ViewGroup

interface HolderFactory<T> {

    fun buildHolder(parent: ViewGroup): T
}