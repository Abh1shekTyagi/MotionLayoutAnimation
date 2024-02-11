/*
 *   Copyright (C) 2019 The Android Open Source Project
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.example.motionlayoutanimation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.motionlayoutanimation.databinding.ActivityStep8Binding
import com.google.android.material.appbar.AppBarLayout

class Step8Activity : AppCompatActivity() {

    private lateinit var binding: ActivityStep8Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStep8Binding.inflate(layoutInflater)
        setContentView(binding.root)

        coordinateMotion()
    }

    private fun coordinateMotion() {
        val appBarLayout = binding.appbarLayout
        val motionLayout = binding.motionLayout

        val listener = AppBarLayout.OnOffsetChangedListener { _, verticalOffset ->
            val seekPosition = -verticalOffset / appBarLayout.totalScrollRange.toFloat()
            motionLayout.progress = seekPosition
        }

        binding.appbarLayout.addOnOffsetChangedListener(listener)
    }
}
