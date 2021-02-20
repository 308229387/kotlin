/*
 * Copyright (C) 2011 Patrik Akerfeldt
 * Copyright (C) 2011 Jake Wharton
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yidian.subway.newscontent.ui.comment.indicator

import androidx.viewpager.widget.ViewPager
import com.example.kotlin.views.indicator.CirclePageIndicator

interface PageIndicator : ViewPager.OnPageChangeListener {
    fun setViewPager(view: ViewPager?)
    fun setViewPager(view: ViewPager?, initialPosition: Int)
    fun setCurrentItem(item: Int)
    fun setOnPageChangeListener(listener: ViewPager.OnPageChangeListener?)
    fun notifyDataSetChanged()
    fun onRestoreInstanceState(state: CirclePageIndicator.SavedState)
}