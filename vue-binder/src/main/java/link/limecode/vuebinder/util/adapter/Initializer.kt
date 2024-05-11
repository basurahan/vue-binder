package link.limecode.vuebinder.util.adapter

fun interface Initializer<T> {
    operator fun invoke(_this: VueAdapter<T>)
}