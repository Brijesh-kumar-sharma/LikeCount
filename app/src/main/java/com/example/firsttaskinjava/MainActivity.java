package com.example.firsttaskinjava;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Button button;
    FirebaseFirestore firebaseFirestore;
    TextView likescount,liketype;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.btn);
        likescount=findViewById(R.id.likecount);
        liketype=findViewById(R.id.liketype);
        FirebaseApp.initializeApp(this);
        firebaseFirestore=FirebaseFirestore.getInstance();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DocumentReference documentReference=firebaseFirestore.collection("likes").document("mylikes");

                Map<String ,Object> like= new HashMap<>();
                documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if(task.isSuccessful())
                        {
                            DocumentSnapshot documentSnapshot=task.getResult();
                            if(documentSnapshot!=null)
                            {

                                String count=(String) documentSnapshot.get("count");

                                // String count="0";
                                Log.d("TAG",""+count);
                                if(count.equals("1"))
                                {
                                    like.put("type","No Like");
                                    like.put("count","0");
                                    liketype.setText("No Like");
                                    likescount.setText("0");
                                    documentReference.set(like).addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void unused) {
                                            Toast.makeText(getApplicationContext(),"Removed",Toast.LENGTH_SHORT).show();
                                        }
                                    }).addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(getApplicationContext(),"Failed To Add",Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }
                            }
                        }

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });


            }
        });

        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                DocumentReference documentReference=firebaseFirestore.collection("likes").document("mylikes");

                Map<String ,Object> like= new HashMap<>();

                    Dialog dialog = new Dialog(MainActivity.this);
                    dialog.setContentView(R.layout.custom_dialog);
                    dialog.show();

                    ImageView face1, face2, face3, face4;

                    face1 = dialog.findViewById(R.id.face1);
                    face2 = dialog.findViewById(R.id.face2);
                    face3 = dialog.findViewById(R.id.face3);
                    face4 = dialog.findViewById(R.id.face4);

                    face1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(getApplicationContext(),"Face 1",Toast.LENGTH_SHORT).show();

                            like.put("type","face1");
                            like.put("count","1");
                            liketype.setText("face1");
                            likescount.setText("1");
                            documentReference.set(like).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast.makeText(getApplicationContext(),"Added",Toast.LENGTH_SHORT).show();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(getApplicationContext(),"Failed To Add",Toast.LENGTH_SHORT).show();
                                }
                            });
                            dialog.dismiss();

                        }
                    });

                face2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(),"Face 2",Toast.LENGTH_SHORT).show();



                        like.put("type","face2");
                        like.put("count","1");
                        liketype.setText("face2");
                        likescount.setText("1");
                        documentReference.set(like).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(getApplicationContext(),"Added",Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getApplicationContext(),"Failed To Add",Toast.LENGTH_SHORT).show();
                            }
                        });
                        dialog.dismiss();

                    }
                });


                face3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(),"Face 3",Toast.LENGTH_SHORT).show();
                        like.put("type","face3");
                        like.put("count","1");
                        liketype.setText("face3");
                        likescount.setText("1");
                        documentReference.set(like).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(getApplicationContext(),"Added",Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getApplicationContext(),"Failed To Add",Toast.LENGTH_SHORT).show();
                            }
                        });



                        dialog.dismiss();

                    }
                });


                face4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(),"Face 4",Toast.LENGTH_SHORT).show();
                        like.put("type","face4");
                        like.put("count","1");
                        liketype.setText("face4");
                        likescount.setText("1");
                        documentReference.set(like).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(getApplicationContext(),"Added",Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getApplicationContext(),"Failed To Add",Toast.LENGTH_SHORT).show();
                            }
                        });

                        dialog.dismiss();

                    }
                });



                return false;
            }
        });
    }
}