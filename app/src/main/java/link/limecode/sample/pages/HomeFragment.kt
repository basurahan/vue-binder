package link.limecode.sample.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import link.limecode.sample.R
import link.limecode.sample.databinding.FragmentHomeBinding
import link.limecode.vuebinder.FragmentViewBinding

class HomeFragment : FragmentViewBinding<FragmentHomeBinding>() {

    override fun bind(inflater: LayoutInflater, container: ViewGroup?): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.about.setOnClickListener {
            findNavController().navigate(R.id.about)
        }
    }
}