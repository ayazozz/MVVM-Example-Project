package com.example.currencyapp.welcome


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.example.currencyapp.R
import com.example.currencyapp.databinding.FragmentWelcomeBinding

private lateinit var viewmodel: WelcomeViewmodel
private lateinit var binding: FragmentWelcomeBinding


class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        viewmodel = ViewModelProviders.of(this).get(WelcomeViewmodel::class.java)
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_welcome,
            container,
            false
        )

        binding.welcomeViewModel = viewmodel
        binding.lifecycleOwner = this

        binding.nextBtn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.navigateToCurrencyListAction))

        return binding.root
    }


}
