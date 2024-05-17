package link.limecode.sample.pages.home.holders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import link.limecode.sample.R
import link.limecode.sample.databinding.ItemUserBinding
import link.limecode.sample.pages.home.uimodels.UiUserListData
import link.limecode.vuebinder.util.adapter.BaseHolder
import link.limecode.vuebinder.util.adapter.HolderFactory

class UserHolder(
    view: View,
    override val viewBinding: ItemUserBinding,
    private val interactor: Interactor
) :
    BaseHolder<UiUserListData.UserData>(view) {

    override fun bind(item: UiUserListData.UserData) {
        with(viewBinding) {
            name.text = getString(R.string.template_name, item.firstName, item.lastName)
            root.setOnClickListener { interactor.onClick() }
        }
    }

    companion object : HolderFactory<UserHolder, Interactor> {

        override fun buildHolder(parent: ViewGroup, interactor: Interactor): UserHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ItemUserBinding.inflate(inflater, parent, false)
            return UserHolder(
                view = binding.root,
                viewBinding = binding,
                interactor = interactor
            )
        }
    }

    interface Interactor {

        fun onClick()
    }
}