package com.moringaschool.petfinder.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.moringaschool.petfinder.R;
import com.moringaschool.petfinder.adapters.PetPagerAdapter;
import com.moringaschool.petfinder.modules.PetSearchResponse;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;

public class DogDetailActivity extends AppCompatActivity {
    @BindView(R.id.viewPager) ViewPager mViewPager;
    private PetPagerAdapter adapterViewPager;
    private List<PetSearchResponse> images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_detail);

        images = Parcels.unwrap(getIntent().getParcelableExtra("pets"));
        int startingPosition = getIntent().getIntExtra("position", 0);


//        adapterViewPager = new PetPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, images);
//        mViewPager.setAdapter(adapterViewPager);
//        mViewPager.setCurrentItem(startingPosition);

    }
}