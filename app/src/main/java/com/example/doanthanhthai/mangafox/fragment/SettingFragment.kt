package com.example.doanthanhthai.mangafox.fragment

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import android.os.AsyncTask
import android.os.Bundle
import android.os.Handler
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.core.util.Pair
import androidx.core.widget.NestedScrollView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.RelativeLayout
import android.widget.Toast
import com.example.doanthanhthai.mangafox.DetailActivity
import com.example.doanthanhthai.mangafox.R
import com.example.doanthanhthai.mangafox.adapter.LatestEpisodeAdapter
import com.example.doanthanhthai.mangafox.manager.AnimeDataManager
import com.example.doanthanhthai.mangafox.model.Anime
import com.example.doanthanhthai.mangafox.model.Category
import com.example.doanthanhthai.mangafox.repository.AnimeRepository
import com.example.doanthanhthai.mangafox.share.Constant
import com.example.doanthanhthai.mangafox.share.DynamicColumnHelper
import com.example.doanthanhthai.mangafox.share.PreferenceHelper
import com.example.doanthanhthai.mangafox.share.Utils
import kotlinx.android.synthetic.main.fragment_setting.*
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.io.IOException

/**
 * Created by ThaiDT1 on 8/20/2018.
 */
class SettingFragment : Fragment(), View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        PreferenceHelper.getInstance(activity).saveNightMode(isChecked)
        if (isChecked) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
        activity!!.recreate()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.toolbar_back_btn -> {
                val fm: FragmentManager? = activity?.supportFragmentManager
                fm?.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
            }
        }
    }

    companion object {
        @JvmField
        val TAG = SettingFragment::class.java.simpleName
    }

    private var mTaskHandler: Handler? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_setting, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar_back_btn.setOnClickListener(this)
        mTaskHandler = Handler();

        night_mode_switch.isChecked = PreferenceHelper.getInstance(activity).nightMode
        night_mode_switch.setOnCheckedChangeListener(this)
    }


}