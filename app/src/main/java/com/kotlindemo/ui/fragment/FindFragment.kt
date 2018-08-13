package com.kotlindemo.ui.fragment

import android.content.Intent
import com.kotlindemo.R
import com.kotlindemo.adapter.FindAdapter
import com.kotlindemo.base.BaseFragment
import com.kotlindemo.mvp.contract.FindContract
import com.kotlindemo.mvp.model.bean.FindBean
import com.kotlindemo.mvp.presenter.FindPresenter
import com.kotlindemo.ui.FindDetailActivity
import kotlinx.android.synthetic.main.find_fragment.*

/**
 * Create By yinwuteng
 * 2018/7/16.
 */
class FindFragment : BaseFragment(), FindContract.View {
    var mPresenter: FindPresenter? = null
    var mAdapter: FindAdapter? = null
    var mList: MutableList<FindBean>? = null

    override fun getLayoutResources(): Int {
        return R.layout.find_fragment
    }

    override fun initView() {
        mPresenter = FindPresenter(context, this)
        mPresenter?.start()
        mAdapter = FindAdapter(context, mList)
        gv_find.adapter = mAdapter
        gv_find.setOnItemClickListener { parent, view, position, id ->
            var bean = mList?.get(position)
            var name = bean?.name
            var intent: Intent = Intent(context, FindDetailActivity::class.java)
            intent.putExtra("name", name)
            startActivity(intent)
        }
    }

    override fun setData(bean: MutableList<FindBean>) {
        mAdapter?.mList = bean
        mList = bean
        mAdapter?.notifyDataSetChanged()
    }
}