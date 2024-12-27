package com.example.afinal;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPageAdap extends FragmentStateAdapter {
    public ViewPageAdap(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new StartFragment();
            case 1:
                return new DetailsFragment();
            case 2:
                return new ListeFragment();
            default:
                return new StartFragment();
        }
    }
    @Override
    public int getItemCount() {
        return 3;
    }
}
