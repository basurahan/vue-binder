package link.limecode.vuebinder.util.adapter

import android.content.Context
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.FontRes
import androidx.annotation.LayoutRes
import androidx.annotation.PluralsRes
import androidx.annotation.StringRes
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView

abstract class BaseHolder<T> : RecyclerView.ViewHolder {

    @Suppress("MemberVisibilityCanBePrivate")
    protected val context: Context
        get() = itemView.context

    constructor(v: View) : super(v)

    constructor(
        @LayoutRes layoutRes: Int,
        parent: ViewGroup
    ) : super(LayoutInflater.from(parent.context).inflate(layoutRes, parent, false))

    fun bind(item: T) {}

    fun bind(itemCount: Int, item: T) {}

    fun updateWithPayloads(pos: Int, itemCount: Int, item: T, payloads: List<Any>) {}

    protected fun getFont(@FontRes fontId: Int): Typeface {
        return requireNotNull(ResourcesCompat.getFont(context, fontId))
    }

    protected fun getDrawable(@DrawableRes resId: Int): Drawable {
        return requireNotNull(ResourcesCompat.getDrawable(context.resources, resId, null))
    }

    @ColorInt
    protected fun getColor(@ColorRes resId: Int): Int {
        return ResourcesCompat.getColor(context.resources, resId, null)
    }

    protected fun getString(@StringRes resId: Int, vararg params: Any): String {
        return context.getString(resId, *params)
    }

    protected fun getPluralBy(@PluralsRes resId: Int, count: Int): String {
        return context.resources.getQuantityString(resId, count)
    }
}