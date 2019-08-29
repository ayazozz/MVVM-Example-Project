package com.example.currencyapp.currencyList


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyapp.R
import com.example.currencyapp.databinding.FragmentCurrencyListBinding


class CurrencyListFragment : Fragment() {

    private lateinit var viewmodel: CurrencyListViewModel

    private lateinit var binding : FragmentCurrencyListBinding

    private lateinit var adapter : CurrencyListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_currency_list
            , container, false)

        var list = listOf<String>()

        viewmodel =
            ViewModelProviders.of(
                this,  CurrencyListViewModelFactory()).get(CurrencyListViewModel::class.java)


        binding.currencyListViewmodel = viewmodel
        binding.lifecycleOwner = this


        println("ONCREATE")

        adapter = CurrencyListAdapter(CurrencyItemClickListener { currency ->
            val paramList = adapter.getCurrentList().toTypedArray()

            val  action =

                CurrencyListFragmentDirections.actionCurrencyListFragmentToCurrencyDetailsFragment(currency,
                    paramList
                )
            NavHostFragment.findNavController(this).navigate(action)
        })

        list = adapter.getCurrentList().toList()
        binding.currencyRcView.adapter = adapter



        viewmodel.currencyRatesList.observe(this, Observer {
            adapter.submitList(it)
            list = it
        })

        viewmodel.getSearchValue.observe(this, Observer { searchValue ->

            val search = searchValue.toUpperCase()
            val searchList = list.filter { search in it }
            adapter.submitList(searchList)

        })

        viewmodel.errorMessage.observe(this, Observer {
            Toast.makeText(context, "OPPS!, Something went wrong!", Toast.LENGTH_SHORT).show()
        })

        onChangeLayoutListener()


        return binding.root

    }


    fun onChangeLayoutListener() {
        binding.currencyRcView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy < 0 )
                    binding.searchEdittext.visibility = View.GONE
                else if (dy > 0)
                    binding.searchEdittext.visibility = View.VISIBLE

            }
        })

    }

    override fun onResume() {
        super.onResume()
        if (!viewmodel.isCreatedFragmentFirst.value!!)
            viewmodel.getList()


    }

}
