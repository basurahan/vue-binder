Introducing **VuewBinder**: The Butter on Your Android Toast (But Better)

Tired of boilerplate code that makes view binding feel like wrangling toddlers?  Wish there was a way to bind views with the same ease as, well, butter sliding on toast? Then look no further than VuewBinder, the open-source library that's here to make your life easier (and tastier)!

VuewBinder is like that friend who always knows how to make things fun. It takes the tedious task of view binding and injects a healthy dose of simplicity. No more findViewById woes or findViewById foes (because with VuewBinder, they won't exist!).

Here's what VuewBinder brings to the table:

1. ActivityViewBinding - easily bind your activity views
2. FragmentViewBinding - easiy bind your fragment views

- Less Code, More Playtime: Spend less time writing boilerplate and more time making your app awesome. VuewBinder streamlines the process, letting you focus on the good stuff.

- Easy as Pie (or Butter on Toast): Using VuewBinder is like riding a bike (except maybe easier, because you probably don't need training wheels with this library).

- Open-Source Goodness: Feel free to tinker, tweak, and contribute to VuewBinder. After all, sharing is caring (and it makes the Android development world a better place).

So ditch the findViewById frustration and dive into the world of effortless view binding with VuewBinder!  Your fingers (and your sanity) will thank you.

P.S.  VuewBinder isn't affiliated with any actual butter or toast companies (yet). But hey, if they're reading this, maybe we can work out a sponsorship deal?

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

**Usage**

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