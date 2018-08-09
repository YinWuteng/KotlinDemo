package com.kotlindemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.kotlindemo.R
import com.kotlindemo.mvp.model.bean.FindBean
import com.kotlindemo.utils.ImageLoadUtils

/**
 * Create By yinwuteng
 * 2018/8/6.
 */
class FindAdapter(context: Context, list: MutableList<FindBean>?) : BaseAdapter() {
    var mContext: Context? = null
    var mList: MutableList<FindBean>? = null
    var mInflater: LayoutInflater? = null

    init {
        mContext = context
        mList = list
        mInflater = LayoutInflater.from(context)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View
        var holder: FindViewHolder
        if (convertView == null) {
            view = mInflater!!.inflate(R.layout.item_find, parent, false)
            holder = FindViewHolder(view)
            view.tag = holder
        } else {
            view = convertView
            holder = view.tag as FindViewHolder
        }

        ImageLoadUtils.display(mContext!!, holder.iv_photo, mList?.get(position)?.bgPicture!!)
        holder.tv_title?.text = mList?.get(position)!!.name
        return view
    }

    override fun getItem(position: Int): FindBean? {
        return mList?.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        if (mList != null) {
            return mList!!.size
        } else {
            return 0
        }
    }

    class FindViewHolder(itemView: View) {
        var iv_photo: ImageView? = null
        var tv_title: TextView? = null

        init {
            tv_title = itemView.findViewById(R.id.tv_title) as TextView
            iv_photo = itemView.findViewById(R.id.iv_photo) as ImageView
        }
    }
}