package com.example.fragmentpro2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button addA,removeA,replaceA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addA=findViewById(R.id.adda);
        removeA=findViewById(R.id.remove);
        replaceA=findViewById(R.id.replace);

        addA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              FragmentOne fragmentOne=new FragmentOne();
              FragmentManager manager=getSupportFragmentManager();
              FragmentTransaction transaction=manager.beginTransaction();
             transaction.add(R.id.linear,fragmentOne,"a");
             transaction.commit();
            }
        });
        removeA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager=getSupportFragmentManager();
                FragmentTransaction transaction=manager.beginTransaction();
                FragmentOne fragmentOne= (FragmentOne) manager.findFragmentByTag("a");
                if(fragmentOne!=null){
                    transaction.remove(fragmentOne);
                    transaction.commit();
                }else{
                    Toast.makeText(MainActivity.this,"please add fragment a first",Toast.LENGTH_LONG).show();
                }
            }
        });
        replaceA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTwo fragmentTwo=new FragmentTwo();
                FragmentManager manager=getSupportFragmentManager();
                FragmentTransaction transaction=manager.beginTransaction();
                FragmentOne fragmentOne= (FragmentOne) manager.findFragmentByTag("a");
                if (fragmentOne!=null){
                    transaction.replace(R.id.linear,fragmentTwo,"r");
                    transaction.commit();
                }
                else{
                    Toast.makeText(MainActivity.this,"please add fragment a first",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
