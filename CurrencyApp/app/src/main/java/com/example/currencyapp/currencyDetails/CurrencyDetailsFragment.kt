package com.example.currencyapp.currencyDetails


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager2.widget.ViewPager2
import com.example.currencyapp.R
import com.example.currencyapp.databinding.FragmentCurrencyDetailsBinding
import com.google.android.material.tabs.TabLayout

private lateinit var viewmodel: CurrencyDetailsViewModel

private lateinit var binding : FragmentCurrencyDetailsBinding
class CurrencyDetailsFragment : Fragment() {

    protected lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var args: CurrencyDetailsFragmentArgs
    private var adapter = CurrencyDetailsAdapter()
    private  var selectedCurrency : String=""
    private lateinit var tabList : Array<String>

    var list = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_currency_details
            , container, false)



        args  = CurrencyDetailsFragmentArgs.fromBundle(arguments!!)

        viewmodel =
            ViewModelProviders.of(
                this,  CurrencyDetailsViewModelFactory()
            ).get(CurrencyDetailsViewModel::class.java)


        selectedCurrency = viewmodel.tabValue.value ?: args.currency
        tabList = args.tabList


        binding.detailViewmodel = viewmodel
        binding.lifecycleOwner = this

        viewPager = binding.viewPager2
        tabLayout = binding.tabs
        viewPager.adapter = adapter


        for (item in tabList) {
            tabLayout.addTab(tabLayout.newTab().setText(item))

        }

        /*  TabLayoutMediator(tabLayout, viewPager) { tab, position ->

              tab.text =tabList.get(position)

          }.attach()*/

        viewmodel.getDetails(selectedCurrency).observe(this, Observer {
            adapter.submitList(it.rates.map { it1 -> selectedCurrency + " / " + it1.key + "     " + it1.value })
            viewPager.currentItem = tabList.indexOf(selectedCurrency)
        })

        viewmodel.errorMessage.observe(this, Observer {
            Toast.makeText(context, "OPPS!, Something went wrong!", Toast.LENGTH_SHORT).show()
        })


        val tabIndex = tabList.indexOf(selectedCurrency)
        val selectedTab = tabLayout.getTabAt(tabIndex)

        tabLayout.selectTab(selectedTab);
        viewPager.currentItem = tabIndex

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab?) {
                selectedCurrency = tab!!.text.toString()
                viewmodel.getDetails(selectedCurrency)
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
        })


        return binding.root

    }




}


