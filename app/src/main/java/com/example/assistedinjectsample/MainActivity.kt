package com.example.assistedinjectsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        takeIf { savedInstanceState == null }
            ?.let {
                supportFragmentManager.commit {
                    add(R.id.container, BlankFragment.newInstance(4830923))
                }
            }
    }
}