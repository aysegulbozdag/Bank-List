package com.example.android.banklistapp.view

import android.view.Window
import android.view.WindowManager
import androidx.core.content.ContextCompat
import com.example.android.banklistapp.R
import com.example.android.banklistapp.databinding.FragmentDetailBankBinding
import com.example.android.banklistapp.util.base.BaseFragment
import com.example.android.banklistapp.viewmodel.BankDetailViewModel


class DetailBankFragment : BaseFragment<FragmentDetailBankBinding, BankDetailViewModel>() {

    override fun getLayoutId(): Int = R.layout.fragment_detail_bank
    override fun getViewModel(): Class<BankDetailViewModel> = BankDetailViewModel::class.java


    override fun onFragmentStarted() {
        val window: Window = requireActivity().window
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(requireActivity(), R.color.navy)
    }


}