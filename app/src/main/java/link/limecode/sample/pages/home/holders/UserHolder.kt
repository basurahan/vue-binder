package link.limecode.sample.pages.home.holders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import link.limecode.sample.R
import link.limecode.sample.databinding.ItemUserBinding
import link.limecode.sample.pages.home.uimodels.UiUserListData
import link.limecode.vuebinder.util.adapter.BaseHolder
import link.limecode.vuebinder.util.adapter.HolderFactory

class UserHolder(view: View, override val viewBinding: ItemUserBinding) :
    BaseHolder<UiUserListData.UserData>(view) {

    override fun bind(item: UiUserListData.UserData) {
        with(viewBinding) {
            name.text = getString(R.string.template_name, item.firstName, item.lastName)
        }
    }

    companion object : HolderFactory<UserHolder> {

        override fun buildHolder(parent: ViewGroup): UserHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ItemUserBinding.inflate(inflater, parent, false)
            return UserHolder(
                view = binding.root,
                viewBinding = binding
            )
        }
    }
}