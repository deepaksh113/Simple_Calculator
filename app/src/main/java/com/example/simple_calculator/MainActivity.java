package com.example.simple_calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import com.example.simple_calculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity{

    protected ActivityMainBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        BlankFragment blankFragment= BlankFragment.newInstance(activityMainBinding.fragmentContainer.getId());
        FragmentTransaction blankFragmentTransaction=getSupportFragmentManager().beginTransaction();
        blankFragmentTransaction.replace(activityMainBinding.fragmentContainer.getId(), blankFragment,"BlankFragmentTag").addToBackStack(null).commit();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu1){
        getMenuInflater().inflate(R.menu.menu,menu1);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        if (menuItem.getItemId()==R.id.history){
                Intent intent = new Intent(MainActivity.this,History.class);
                startActivity(intent);throw new IllegalStateException("Unexpected value: " + menuItem.getItemId());
        }
        return true;
    }
}