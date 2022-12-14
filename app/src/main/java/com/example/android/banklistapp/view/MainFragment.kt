package com.example.android.banklistapp.view

import android.util.Log
import androidx.lifecycle.*
import androidx.navigation.Navigation
import com.example.android.banklistapp.R
import com.example.android.banklistapp.Result
import com.example.android.banklistapp.util.base.BaseDiffUtilItemCallback
import com.example.android.banklistapp.util.base.BaseFragment
import com.example.android.banklistapp.databinding.FragmentMainBinding
import com.example.android.banklistapp.model.Bank
import com.example.android.banklistapp.viewmodel.BankListViewModel

class MainFragment : BaseFragment<FragmentMainBinding, BankListViewModel>() {

    private val adapter by lazy {
        GenericAdapter(
           viewModel,
            R.layout.item_bank_list,
            BaseDiffUtilItemCallback<Bank>()
        ) {
            onClick { _ ->
                Navigation.findNavController(requireView()).navigate(R.id.detailBankFragment)
            }
        }
    }


    override fun onFragmentStarted() {
        getDataBinding().rvBank.adapter =adapter
       viewModel.bankList.observe(this, Observer {
            when(it.status){
                Result.Status.SUCCESS ->{
                    hideProgress()
                    adapter.submitList(it.data)
                }
                Result.Status.ERROR -> {
                    it.message?.let {
                        Log.e("ERROR : " , it)
                    }
                    hideProgress()
                }
                Result.Status.LOADING -> showProgress()
            }

        })
    }

    override fun getLayoutId(): Int = R.layout.fragment_main
    override fun getViewModel(): Class<BankListViewModel> = BankListViewModel::class.java


}