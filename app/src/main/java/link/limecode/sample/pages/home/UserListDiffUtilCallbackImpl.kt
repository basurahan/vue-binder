package link.limecode.sample.pages.home

import link.limecode.sample.pages.home.uimodels.UiUserListData
import link.limecode.vuebinder.util.adapter.VueDiffUtil

class UserListDiffUtilCallbackImpl : VueDiffUtil<UiUserListData>() {

    override fun areItemsTheSame(oldItem: UiUserListData, newItem: UiUserListData): Boolean {
        return oldItem is UiUserListData.UserData && newItem is UiUserListData.UserData ||
                oldItem is UiUserListData.TitleData && newItem is UiUserListData.TitleData ||
                oldItem is UiUserListData.Empty && newItem is UiUserListData.Empty
    }

    override fun areContentsTheSame(oldItem: UiUserListData, newItem: UiUserListData): Boolean {
        return oldItem == newItem
    }
}