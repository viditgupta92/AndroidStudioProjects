/*
 * Copyright (C) 2016 The Android Open Source Project
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
package com.example.android.portfolio;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Provides the appropriate {@link Fragment} for a view pager.
 */
public class CategoryAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 6;

    private Context mContext;

    private String tabTitles[] = new String[] { "About", "Education", "Skills", "WorkExp", "Projects", "Achievements" };

    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new AboutFragment();
        } else if (position == 1){
            return new EducationFragment();
        } else if (position == 2) {
            return new SkillsFragment();
        } else if (position == 3) {
            return new WorkExpFragment();
        } else if (position == 4) {
            return new ProjectsFragment();
        } else {
            return new AchievementsFragment();
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        if (position == 0) {
            return mContext.getString(R.string.category_about);
        } else if (position == 1){
            return mContext.getString(R.string.category_education);
        } else if (position == 2) {
            return mContext.getString(R.string.category_skills);
        } else if (position == 3) {
            return mContext.getString(R.string.category_workexp);
        }else if (position == 4) {
            return mContext.getString(R.string.category_projects);
        }else {
            return mContext.getString(R.string.category_achievements);
        }
    }
}
