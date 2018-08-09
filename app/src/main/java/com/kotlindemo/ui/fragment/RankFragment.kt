package com.kotlindemo.ui.fragment

import android.support.v7.widget.LinearLayoutManager
import com.kotlindemo.R
import com.kotlindemo.adapter.RankAdapter
import com.kotlindemo.base.BaseFragment
import com.kotlindemo.mvp.contract.HotContract
import com.kotlindemo.mvp.model.bean.HotBean
import com.kotlindemo.mvp.presenter.HotPresenter
import kotlinx.android.synthetic.main.home_fragment.*

/**
 * Create By yinwuteng
 * 2018/8/6.
 */
class RankFragment : BaseFragment(), HotContract.View {

    lateinit var mPresenter: HotPresenter
    lateinit var mStrategy: String
    lateinit var mAdapter: RankAdapter
    var mList: ArrayList<HotBean.ItemListBean.DataBean> = ArrayList()
    override fun getLayoutResources(): Int {
        return R.layout.rank_fragment
    }

    override fun initView() {
        recyclerView.layoutManager = LinearLayoutManager(context)
        mAdapter = RankAdapter(context, mList)
        recyclerView.adapter = mAdapter
        if (arguments != null) {
            mStrategy = arguments.getString("strategy")
            mPresenter = HotPresenter(context, this)
            mPresenter.requesData(mStrategy)
        }
    }

    override fun setData(bean: HotBean) {
        if (mList.size > 0) {
            mList.clear()
        }
        bean.itemList?.forEach {
            it.data?.let { it1 -> mList.add(it1) }
        }
        mAdapter.notifyDataSetChanged()
    }
}