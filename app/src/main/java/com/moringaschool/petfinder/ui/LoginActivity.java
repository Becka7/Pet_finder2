package com.moringaschool.petfinder.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.moringaschool.petfinder.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private DatabaseReference mPetTypeReference;

    private ValueEventListener mPetTypeReferenceListener;

    private static final String TAG = DogActivity.class.getSimpleName();
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;



    @BindView(R.id.registerTextView)
    TextView mRegisterTextView;
    @BindView(R.id.passwordLoginButton)
    Button mPasswordLoginButton;
    @BindView(R.id.emailEditText)
    EditText Memail;
    @BindView(R.id.passwordEditText)
    EditText Mpassword;
    @BindView(R.id.firebaseProgressBar)
    ProgressBar mSignInProgressBar;
    @BindView(R.id.loadingTextView) TextView mLoadingSignUp;
    @BindView(R.id.pettype) EditText mType;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mPetTypeReference = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(Constants.FIREBASE_CHILD_PETTYPE);

        mPetTypeReference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot petTypeSnapshot : dataSnapshot.getChildren()) {
                    String petType = petTypeSnapshot.getValue().toString();
                    Log.d("petType updated", "petType: " + petType);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }


        });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);


        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }
            }
        };


        mRegisterTextView.setOnClickListener(this);
        mPasswordLoginButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if (view == mRegisterTextView) {

            Intent intent = new Intent(LoginActivity.this, CreateAccount.class);
            String email = Memail.getText().toString();
            Log.d("email", email);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_up,R.anim.slide_down);
            finish();
        }
        String petType = mType.getText().toString();
        if (view == mPasswordLoginButton)


            saveTypeToFirebase(petType);

            loginWithPassword();
            showProgressBar();

            }

    private void showProgressBar() {
        mSignInProgressBar.setVisibility(View.VISIBLE);
        mLoadingSignUp.setVisibility(View.VISIBLE);
//        mAuthProgressDialog.setMessage("Authenticating with Firebase...");
        mLoadingSignUp.setText("Log in you in");
    }

    private void hideProgressBar() {
        mSignInProgressBar.setVisibility(View.GONE);
        mLoadingSignUp.setVisibility(View.GONE);
    }


    private void loginWithPassword() {
        String email = Memail.getText().toString().trim();
        String password = Mpassword.getText().toString().trim();
        if (password.equals("")) {
            Mpassword.setError("Password cannot be blank");
            return;
        }


        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        hideProgressBar();
                        Log.d(TAG, "signInWithEmail:onComplete:" + task.isSuccessful());
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                        }else

                            Log.w(TAG, "signInWithEmail", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                });

    }
    public void  saveTypeToFirebase(String  petType) {
        mPetTypeReference.push().setValue( petType);
    }
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        mPetTypeReference.removeEventListener( mPetTypeReferenceListener);
//    }

}





//        @Override
//    protected void onResume() {
//        super.onResume();
//
//        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
//
//        String s1 = sh.getString("email","");
//
//        Memail.setText(s1);
////        Log.d(TAG, "onResume: email");
//        Log.d("Email", "email" + Memail);
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//
//        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
//        SharedPreferences.Editor myEdit = sharedPreferences.edit();
//
//        myEdit.putString("name", Memail.getText().toString());
//
//        myEdit.apply();
//    }
//
//
//}
