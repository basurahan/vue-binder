package link.limecode.vuebinder.util.adapter

import android.view.ViewGroup

interface HolderFactory<T, I> {

    fun buildHolder(parent: ViewGroup, interactor: I): T
}