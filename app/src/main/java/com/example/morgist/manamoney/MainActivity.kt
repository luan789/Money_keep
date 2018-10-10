package com.example.morgist.manamoney

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.GestureDetector
import android.view.GestureDetector.OnGestureListener
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import com.example.morgist.library3th.OnSwipeTouchListener
import com.example.morgist.manamoney.Fragment.FragmentBudget
import com.example.morgist.manamoney.Fragment.FragmentSaveFund
import com.example.morgist.manamoney.Fragment.OverviewFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val overviewFragment = OverviewFragment()
    val fragmentBudget = FragmentBudget()
    val fragmentSaveFund = FragmentSaveFund()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        floatingActionButton.setOnClickListener {
            switchFragment(overviewFragment)
        }
        menu_bot_budget.setOnClickListener {
            switchFragment(fragmentBudget)
        }
        menu_bot_account.setOnClickListener {
            switchFragment(fragmentSaveFund)
        }
        main_main_container.setOnTouchListener(object : OnSwipeTouchListener(this) {
            override fun onSwipeRight() {
                if (fragmentBudget.isVisible) {
                    Log.d("TTTT", "co")
                    switchAnimation(fragmentSaveFund, R.anim.exit_to_left, R.anim.enter_from_left)
                    return
                }


            }

            override fun onSwipeLeft() {
                supportFragmentManager
                        .beginTransaction()
                        .setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right)
                        .replace(R.id.main_main_container, fragmentBudget)
                        .commit()
            }
        })
    }

    fun switchAnimation(fragmet: Fragment, a: Int, b: Int) {
        supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(a, b)
                .replace(R.id.main_main_container, fragmet)
                .commit()
    }

    fun switchFragment(fragmet: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_main_container, fragmet)
                .commit()
    }
}


