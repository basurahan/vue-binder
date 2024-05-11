package link.limecode.vuebinder.util.adapter

import android.view.ViewGroup

typealias HolderPredicate<T> = (item: T) -> Boolean
typealias HolderGenerator<T> = (ViewGroup) -> BaseHolder<out T>