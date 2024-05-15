package link.limecode.sample.pages.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import link.limecode.sample.R
import link.limecode.sample.databinding.FragmentHomeBinding
import link.limecode.sample.pages.home.holders.EmptyHolder
import link.limecode.sample.pages.home.holders.TitleHolder
import link.limecode.sample.pages.home.holders.UserHolder
import link.limecode.sample.pages.home.uimodels.UiUserListData
import link.limecode.vuebinder.FragmentViewBinding
import link.limecode.vuebinder.util.adapter.VueAdapter

class HomeFragment : FragmentViewBinding<FragmentHomeBinding>() {

    private lateinit var adapter: VueAdapter<UiUserListData>

    override fun bind(inflater: LayoutInflater, container: ViewGroup?): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = VueAdapter(initializer = { adapter ->

            adapter.holder {
                viewType = R.layout.item_title
                predicate = { it is UiUserListData.TitleData }
                generator = { TitleHolder.buildHolder(it) }
            }

            adapter.holder {
                viewType = R.layout.item_user
                predicate = { it is UiUserListData.UserData }
                generator = { UserHolder.buildHolder(it) }
            }

            adapter.holder {
                viewType = R.layout.item_empty
                predicate = { it is UiUserListData.Empty }
                generator = { EmptyHolder.buildHolder(it) }
            }
        })
    }
}