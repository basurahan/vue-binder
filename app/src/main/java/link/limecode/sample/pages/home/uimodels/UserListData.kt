package link.limecode.sample.pages.home.uimodels

sealed interface UiUserListData {

    data object Empty : UiUserListData

    data class TitleData(
        val letter: Char
    ) : UiUserListData

    data class UserData(
        val firstName: String,
        val lastName: String
    ) : UiUserListData
}