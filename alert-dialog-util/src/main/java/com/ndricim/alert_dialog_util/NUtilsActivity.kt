package com.ndricim.alert_dialog_util

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ndricim.alert_dialog_util.databinding.ActivityNutilsBinding

class NUtilsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNutilsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNutilsBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        binding.button.setOnClickListener {
            onBackPressed()
        }
    }
}