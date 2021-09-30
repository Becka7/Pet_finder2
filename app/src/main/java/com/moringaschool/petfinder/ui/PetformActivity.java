package com.moringaschool.petfinder.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.moringaschool.petfinder.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PetformActivity extends AppCompatActivity implements View.OnClickListener {

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private String mRecentName;

    public static final String TAG = PetformActivity.class.getSimpleName();
    @BindView(R.id.checkout)
    Button mCheckout;
    @BindView(R.id.nameEditText)
    EditText mNameEditText;
    @BindView(R.id.email)
    EditText mEmail;
    @BindView(R.id.location)
    EditText mLocation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petform);
        ButterKnife.bind(this);


//        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//        mEditor = mSharedPreferences.edit();
//        mRecentName = mSharedPreferences.getString(Constants.FIREBASE_CHILD_NAME, null);
//        Log.d("Shared Pref Name",mRecentName);

        mCheckout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (mNameEditText.length() == 0) {
            mNameEditText.setError("This field is required");
        }

        if (mEmail.length() == 0) {
            mEmail.setError("Email is required");
        }

        if (mLocation.length() == 0) {
            mLocation.setError("This field is required");
        } else {

            String name = mNameEditText.getText().toString();
            Intent intent = new Intent(PetformActivity.this, DogActivity.class);
            intent.putExtra("name", name);
//            addToSharedPreferences(name);
            startActivity(intent);


        }

    }

//        private void addToSharedPreferences (String name){
//            mEditor.putString(Constants.FIREBASE_CHILD_NAME, name).apply();
//
//        }

}
