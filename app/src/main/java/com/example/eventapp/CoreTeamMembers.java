package com.example.eventapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class CoreTeamMembers extends AppCompatActivity {
    public static final String TAG="CoreTeamMembers";
    RecyclerView recyclerView;
    private TextView MemberHeading, NoMemberStatus;
    private Boolean data_available=true;
    int Value;
    String s1[],s2[];
    int image[]={};
    int amtc_memimg[]={
            R.drawable.profileicon, R.drawable.profileicon, R.drawable.profileicon, R.drawable.profileicon,
            R.drawable.profileicon, R.drawable.profileicon, R.drawable.profileicon, R.drawable.profileicon,
            R.drawable.profileicon, R.drawable.profileicon
    };
    int alfaazcoremem[]={
            R.drawable.profileicon, R.drawable.profileicon, R.drawable.profileicon,
            R.drawable.profileicon
    };
    int dummyimg[]={
            R.drawable.profileicon, R.drawable.profileicon, R.drawable.profileicon, R.drawable.profileicon,
            R.drawable.profileicon, R.drawable.profileicon, R.drawable.profileicon, R.drawable.profileicon,
            R.drawable.profileicon, R.drawable.profileicon
    };
    int teacherdummyimg[]={R.drawable.profileicon, R.drawable.profileicon,R.drawable.profileicon};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_core_team_member);
        MemberHeading=findViewById(R.id.mem_head);
        NoMemberStatus=findViewById(R.id.nomemtxt);
        Bundle bundle = getIntent().getExtras();
        Log.i(TAG, "bundle++_+_+" +bundle);
        if (bundle != null) {
            Value = bundle.getInt("value");
            Log.i(TAG, "value+++++++ " +Value);
        }
        int second=Value%10;
        Log.i(TAG, "value+++++++++: " +second);
        if(second==1)  MemberHeading.setText("Core Team Members");
        else if (second==2) MemberHeading.setText("General Members");
        else if (second==3) MemberHeading.setText("Faculy Coordinators");

        switch (Value)
        {
            case 1131:s1=getResources().getStringArray(R.array.programming_languages);
                s2=getResources().getStringArray(R.array.description);
                image=amtc_memimg;
                break;
            case 1231:
            case 2131:
            case 3131:
            case 4131:
            case 5131:s1=getResources().getStringArray(R.array.DummyNames);
                s2=getResources().getStringArray(R.array.DummySeniorDesignation);
                image=dummyimg;
                break;
            case 6131:s1=getResources().getStringArray(R.array.Alfaaz_Core_Members);
                s2=getResources().getStringArray(R.array.Alfaaz_CoreMem_Desg);
                image=alfaazcoremem;
                break;
            //Below is for gen members button
            case 1132:
            case  1232:
            case 2132:
            case 3132:
            case 4132:
            case 5132:
            case 6132: s1=getResources().getStringArray(R.array.DummyNames);
                s2=getResources().getStringArray(R.array.DummyJuniorDesignation);
                image=dummyimg;
                break;
            case 1133:
            case 1233:
            case 2133:
            case 3133:
            case 4133:
            case 5133:
            case 6133:  s1=getResources().getStringArray(R.array.TeacherDummyNames);
                s2=getResources().getStringArray(R.array.TeacherDummyDesig);
                image=teacherdummyimg;
                break;
            default:
                NoMemberStatus.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.GONE);
                data_available=false;
        }



        if(data_available==true) {
            MyAdapter myAdapter = new  MyAdapter(this, s1, s2, image);
            recyclerView.setAdapter(myAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }
    }
    }
