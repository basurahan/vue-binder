Introducing **VueBinder**: The Butter on Your Android Toast (But Better)

Tired of boilerplate code that makes view binding feel like wrangling toddlers?  Wish there was a way to bind views with the same ease as, well, butter sliding on toast? Then look no further than VueBinder, the open-source library that's here to make your life easier (and tastier)!

VueBinder is like that friend who always knows how to make things fun. It takes the tedious task of view binding and injects a healthy dose of simplicity. No more findViewById woes or findViewById foes (because with VueBinder, they won't exist!).

Here's what VueBinder brings to the table:

1. ActivityViewBinding - easily bind your activity views
2. FragmentViewBinding - easiy bind your fragment views
3. BaseHolder - easily bind your recyclerview holder
4. VueAdapter - easily create multi type view list

- Less Code, More Playtime: Spend less time writing boilerplate and more time making your app awesome. VueBinder streamlines the process, letting you focus on the good stuff.

- Easy as Pie (or Butter on Toast): Using VueBinder is like riding a bike (except maybe easier, because you probably don't need training wheels with this library).

- Open-Source Goodness: Feel free to tinker, tweak, and contribute to VueBinder. After all, sharing is caring (and it makes the Android development world a better place).

So ditch the findViewById frustration and dive into the world of effortless view binding with VueBinder!  Your fingers (and your sanity) will thank you.

P.S.  VueBinder isn't affiliated with any actual butter or toast companies (yet). But hey, if they're reading this, maybe we can work out a sponsorship deal?

**Adding to your project**
1. Make sure you have the jitpack repository in your settings.gradle

    kotlin dsl
    ```
    maven { setUrl("https://jitpack.io") }
    ```

    groovy
    ```
    maven { url 'https://jitpack.io' }
    ```

2. Add the library
    ```
    dependencies {
        implementation 'com.github.basurahan:vue-binder:$version'
    }
    ```

**Usage (See example on :app module for more information)**

Fragment
```
class AboutFragment : FragmentViewBinding<FragmentAboutBinding>() {

    override fun bind(inflater: LayoutInflater, container: ViewGroup?): FragmentAboutBinding {
        return FragmentAboutBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.goBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}
```
Activity
```
package link.limecode.sample

import android.view.LayoutInflater
import link.limecode.sample.databinding.ActivityMainBinding
import link.limecode.vuebinder.ActivityViewBinding

class MainActivity : ActivityViewBinding<ActivityMainBinding>() {

    override fun bind(inflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(inflater)
    }
}
```
RecylerView - Holder
```
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
```
RecyclerView - Adapter
```
class HomeFragment : FragmentViewBinding<FragmentHomeBinding>() {

    private lateinit var adapter: VueAdapter<UiUserListData>

    override fun bind(inflater: LayoutInflater, container: ViewGroup?): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = VueAdapter(initializer = { adapter ->

            adapter.diffUtilCallback = UserListDiffUtilCallbackImpl()

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

        with(viewBinding) {
            userList.adapter = adapter

            adapter.setItems(
                listOf(
                    UiUserListData.TitleData('A'),
                    UiUserListData.UserData(
                        firstName = "Abigail",
                        lastName = "Nadine"
                    )
                )
            )
        }
    }
}
```