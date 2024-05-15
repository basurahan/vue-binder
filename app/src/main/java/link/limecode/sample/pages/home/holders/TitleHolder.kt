package link.limecode.sample.pages.home.holders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import link.limecode.sample.databinding.ItemTitleBinding
import link.limecode.sample.pages.home.uimodels.UiUserListData
import link.limecode.vuebinder.util.adapter.BaseHolder
import link.limecode.vuebinder.util.adapter.HolderFactory

class TitleHolder(view: View, override val viewBinding: ItemTitleBinding) :
    BaseHolder<UiUserListData.TitleData>(view) {

    override fun bind(item: UiUserListData.TitleData) {
        with(viewBinding) {

        }
    }

    companion object : HolderFactory<TitleHolder> {

        override fun buildHolder(parent: ViewGroup): TitleHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ItemTitleBinding.inflate(inflater, parent, false)
            return TitleHolder(
                view = binding.root,
                viewBinding = binding
            )
        }
    }
}