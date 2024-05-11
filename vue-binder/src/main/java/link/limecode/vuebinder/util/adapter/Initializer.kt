package link.limecode.vuebinder.util.adapter

fun interface Initializer<T> {
    operator fun invoke(adapter: VueAdapter<T>)
}