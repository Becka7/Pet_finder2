package com.moringaschool.petfinder.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.moringaschool.petfinder.R;
import com.moringaschool.petfinder.modules.PetSearchResponse;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DogDetail extends Fragment {

    @BindView(R.id.DogImageView) ImageView mDogImage;
    @BindView(R.id.DogInfoTextView) ImageView mDogInfo;
    @BindView(R.id.websiteTextView) TextView mWebsiteLabel;
    @BindView(R.id.phoneTextView) TextView mPhoneLabel;
    @BindView(R.id.addressTextView) TextView mAddressLabel;
    @BindView(R.id.saveDogButton) ImageView mSaveDog;

    private PetSearchResponse mDogs;


    public DogDetail() {

    }


    public static DogDetail newInstance(PetSearchResponse dog) {

        DogDetail fragment = new DogDetail();
        Bundle args = new Bundle();
        args.putParcelable("dog", Parcels.wrap(dog));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mDogs = Parcels.unwrap(getArguments().getParcelable("dog"));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_dog_detail, container, false);
        ButterKnife.bind(this, view);
        Picasso.get().load(mDogs.getImage()).into(mDogImage);


        return view;

    }



}
