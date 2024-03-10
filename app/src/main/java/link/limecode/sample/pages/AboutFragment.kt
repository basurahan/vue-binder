package link.limecode.sample.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import link.limecode.sample.databinding.FragmentAboutBinding
import link.limecode.vuebinder.FragmentViewBinding

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