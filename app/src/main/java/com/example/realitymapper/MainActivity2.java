
package com.example.realitymapper;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class MainActivity2 extends AppCompatActivity {

    private TextView textView;
    private EditText editText,editText2;
    private Button button;
    
    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference conditionRef = mRootRef.child("Data");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        button = (Button) findViewById(R.id.button);

        DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();

        readUser();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getUserName = editText.getText().toString();
                String getUserEmail = editText2.getText().toString();

                //hashmap 만들기
                HashMap result = new HashMap<>();
                result.put("name", getUserName);
                result.put("email", getUserEmail);

                writeNewUser("1",getUserName,getUserEmail);

            }
        });
    }
    private void writeNewUser(String userId, String name, String email) {
        User user = new User(name, email);

        mRootRef.child("users").child(userId).setValue(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        // Write was successful!
                        Toast.makeText(MainActivity2.this, "저장을 완료했습니다.", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Write failed
                        Toast.makeText(MainActivity2.this, "저장을 실패했습니다.", Toast.LENGTH_SHORT).show();
                    }
                });

    }

    private void readUser(){
        mRootRef.child("users").child("1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                if(dataSnapshot.getValue(User.class) != null){
                    User post = dataSnapshot.getValue(User.class);
                    Log.w("FireBaseData", "getData" + post.toString());
                } else {
                    Toast.makeText(MainActivity2.this, "데이터 없음...", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w("FireBaseData", "loadPost:onCancelled", databaseError.toException());
            }
        });
    }
}
