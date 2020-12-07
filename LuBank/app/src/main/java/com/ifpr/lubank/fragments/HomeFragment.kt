package com.ifpr.lubank.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ifpr.lubank.R
import com.ifpr.lubank.adapters.RecordAdapter
import com.ifpr.lubank.dao.RecordDAO
import com.ifpr.lubank.dao.UserDAO
import com.ifpr.lubank.models.Record
import com.ifpr.lubank.models.User
import com.ifpr.lubank.util.Util
import kotlinx.android.synthetic.main.fragment_home.view.*


class HomeFragment : Fragment() {

    lateinit var adapter: RecordAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        var view = inflater.inflate(R.layout.fragment_home, container, false)

        adapter = RecordAdapter(requireContext())

        val dao = RecordDAO()
        view.txtSearch.addTextChangedListener {
            if (it.toString() != "") {


                Util.user.id?.let { id ->
                    dao.get(id, it.toString()) { list ->

                        if(list.isEmpty()){
                            adapter.attData(listOf<Record>(), false)
                        }else{
                            adapter.attData(list, true)
                            Log.i("logg", it.toString())
                        }
                    }
                }


            } else {
                adapter.attData(listOf<Record>(), false)
            }
        }

        view.recyclerView.adapter = adapter

        view.recyclerView.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
//
//        val focusLayoutManager = FocusLayoutManager.Builder()
//            .layerPadding(dp2px(activity, 14f))
//            .normalViewGap(dp2px(activity, 14f))
//            .focusOrientation(FocusLayoutManager.FOCUS_BOTTOM)
//            .isAutoSelect(true)
//            .maxLayerCount(3)
//            .setOnFocusChangeListener { focusdPosition, lastFocusdPosition -> }
//            .build()
//        view.recyclerView.layoutManager = focusLayoutManager

        return view
    }
}
