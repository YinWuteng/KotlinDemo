package com.kotlindemo.ui.fragment

import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.kotlindemo.R
import com.kotlindemo.adapter.HomeAdapter
import com.kotlindemo.base.BaseFragment
import com.kotlindemo.mvp.contract.HomeContract
import com.kotlindemo.mvp.model.bean.HomeBean
import com.kotlindemo.mvp.presenter.HomePresenter
import kotlinx.android.synthetic.main.home_fragment.*
import java.util.regex.Pattern

/**
 * Create By yinwuteng
 * 2018/7/16.
 */
class HomeFragment : BaseFragment(), HomeContract.View, SwipeRefreshLayout.OnRefreshListener {
    var mIsRefresh: Boolean = false
    var mPresenter: HomePresenter? = null
    var mList = ArrayList<HomeBean.IssueListBean.ItemListBean>()
    var mAdapter: HomeAdapter? = null
    var data: String? = null
    override fun getLayoutResources(): Int {
        return R.layout.home_fragment
    }

    override fun initView() {
        mPresenter = HomePresenter(context!!, this)
        mPresenter?.start()
        recyclerView.layoutManager = LinearLayoutManager(context)
        mAdapter = HomeAdapter(context!!, mList)
        recyclerView.adapter = mAdapter
        refreshLayout.setOnRefreshListener(this)
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                var layoutManger: LinearLayoutManager = recyclerView?.layoutManager as LinearLayoutManager
                var lastPosition=layoutManger.findLastVisibleItemPosition()
                if (newState==RecyclerView.SCROLL_STATE_IDLE && lastPosition==mList.size-1){
                    mPresenter?.moreData(data)
                }
            }
        })

    }

    override fun setData(bean: HomeBean) {
        val regEx = "[^0-9]"
        val p = Pattern.compile(regEx)
        val m = p.matcher(bean?.nextPageUrl)
        data = m.replaceAll("").subSequence(1, m.replaceAll("").length - 1).toString()
        if (mIsRefresh) {
            mIsRefresh = false
            refreshLayout.isRefreshing = false
            if (mList.size > 0) {
                mList.clear()
            }
        }
        bean.issueList!!
                .flatMap { it.itemList!! }
                .filter { it.type.equals("video") }
                .forEach { mList.add(it) }
        mAdapter?.notifyDataSetChanged()
    }

    override fun onRefresh() {
       if (!mIsRefresh){
           mIsRefresh=true
           mPresenter?.start()
       }
    }
}