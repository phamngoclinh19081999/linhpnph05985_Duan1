package com.phamngoclinh.loginfbfirebase;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.phamngoclinh.loginfbfirebase.model.User;

public class RegisterActivity extends AppCompatActivity {

    private Button btnSave;
    private EditText edtMail,edtName,edtPhone,edtPass;
    private DatabaseReference mData;
    private FirebaseAuth mAuth;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnSave = findViewById(R.id.btnSave);
        edtMail = findViewById(R.id.edtMail);
        edtName = findViewById(R.id.edtName);
        edtPass = findViewById(R.id.edtPass);
        edtPhone = findViewById(R.id.edtPhone);
        mAuth = FirebaseAuth.getInstance();
        mData = FirebaseDatabase.getInstance().getReference();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = edtMail.getText().toString().trim();
                final String name = edtName.getText().toString().trim();
                final String phone = edtPhone.getText().toString().trim();
                final String password = edtPass.getText().toString().trim();
                if (email.equals("")){
                    edtMail.setError("Vui lòng không để trống !!!");
                }else if (password.equals("")){
                    edtPass.setError("Vui lòng không để trống !!!");
                }else if (name.equals("")){
                    edtName.setError("Vui lòng không để trống !!!");
                }else if (phone.equals("")){
                    edtPhone.setError("Vui lòng không để trống !!!");
                }else {
                    DangKy();
                }

            }
        });
    }
    private void DangKy(){
        final String email = edtMail.getText().toString().trim();
        final String name = edtName.getText().toString().trim();
        final String phone = edtPhone.getText().toString().trim();
        final String password = edtPass.getText().toString().trim();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            user = new User(email,name,phone,password);
                            mData.child("User").push().setValue(user);
                            Toast.makeText(RegisterActivity.this, "Đăng ký tài khoản thành công !!!", Toast.LENGTH_SHORT).show();
                        }else {
                            edtMail.setError("Tài khoản đã tồn tại hoặc email không đúng !!!");
                            edtPass.setError("Mật khẩu phải lớn hơn 6 kí tự !!!");
                            return;
                        }
                    }
                });
    }
}
