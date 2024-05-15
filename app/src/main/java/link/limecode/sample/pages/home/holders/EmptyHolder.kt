package link.limecode.sample.pages.home.holders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import link.limecode.sample.databinding.ItemEmptyBinding
import link.limecode.sample.pages.home.uimodels.UiUserListData
import link.limecode.vuebinder.util.adapter.BaseHolder
import link.limecode.vuebinder.util.adapter.HolderFactory

class EmptyHolder(view: View, override val viewBinding: ItemEmptyBinding) :
    BaseHolder<UiUserListData.Empty>(view) {

    companion object : HolderFactory<EmptyHolder> {

        override fun buildHolder(parent: ViewGroup): EmptyHolder {
            val inflater = LayoutInflater.from(parent.context)
            val bind = ItemEmptyBinding.inflate(inflater, parent, false)
            return EmptyHolder(
                view = bind.root,
                viewBinding = bind
            )
        }
    }
}