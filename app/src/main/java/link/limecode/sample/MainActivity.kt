package link.limecode.sample

import android.view.LayoutInflater
import link.limecode.sample.databinding.ActivityMainBinding
import link.limecode.vuebinder.ActivityViewBinding

class MainActivity : ActivityViewBinding<ActivityMainBinding>() {

    override fun bind(inflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(inflater)
    }
}