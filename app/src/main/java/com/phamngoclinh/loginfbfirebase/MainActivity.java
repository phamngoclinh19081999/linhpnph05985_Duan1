package com.phamngoclinh.loginfbfirebase;


import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.phamngoclinh.loginfbfirebase.model.User;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.PicassoProvider;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private static final String TAG ="MainActivity";
    private LoginButton login;
    private CallbackManager callbackManager;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private DatabaseReference mData;
    private Button btnDangki;
    private Button btnDangnhap;
    private EditText edtName,edtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        setContentView(R.layout.activity_main);


        mData = FirebaseDatabase.getInstance().getReference();
        callbackManager = CallbackManager.Factory.create();
        btnDangki = findViewById(R.id.btnDangki);
        btnDangnhap = findViewById(R.id.btnDangnhap);
        edtName = findViewById(R.id.edtUsername);
        edtPass = findViewById(R.id.editPassword);
        mAuth = FirebaseAuth.getInstance();

        btnDangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = edtName.getText().toString().trim();
                final String password = edtPass.getText().toString().trim();
                if (email.equals("")){
                    edtName.setError("Vui lòng nhập email !!!");
                }else if (password.equals("")){
                    edtPass.setError("Vui lòng nhập password !!!");
                } else {
                    DangNhap();

                }

            }
        });
        btnDangki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

    }
    private void DangNhap(){
        final String email = edtName.getText().toString().trim();
        final String password = edtPass.getText().toString().trim();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                            startActivity(intent);
                            Toast.makeText(MainActivity.this, "Đăng nhập thành công !!!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "Thông tin tài khoản hoặc mật khẩu không chính xác !!!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

}
