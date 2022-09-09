package com.example.android.banklistapp.util.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.banklistapp.util.custom.CustomProgressDialog

abstract class BaseFragment<DataBinding : ViewDataBinding, V: ViewModel> : Fragment() {

    private lateinit var dataBinding: DataBinding
    private lateinit var progressDialog : CustomProgressDialog
    protected lateinit var viewModel: V

    abstract fun getLayoutId(): Int
    abstract fun onFragmentStarted()
    abstract fun getViewModel() : Class<V>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        viewModel = ViewModelProvider(this).get(getViewModel())
        progressDialog = CustomProgressDialog()
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onFragmentStarted()
    }

    fun getDataBinding() = dataBinding

    fun showProgress() {
        progressDialog.show(requireActivity().supportFragmentManager, CustomProgressDialog::class.java.name)
    }

    fun hideProgress() {
        try {
            progressDialog.dismiss()
        } catch (e: Exception) {
           Log.e("Error: " , e.message.toString())
        }
    }

}