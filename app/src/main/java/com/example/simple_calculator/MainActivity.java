package com.example.simple_calculator;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.simple_calculator.Fragments.CalculatorFragment;
import com.example.simple_calculator.Fragments.HistoryFragment;
import com.example.simple_calculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity{

    protected ActivityMainBinding activityMainBinding;
    private CalculatorFragment calculatorFragment;
    protected FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        calculatorFragment=CalculatorFragment.newInstance(activityMainBinding.fragmentContainer.getId());
        fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(activityMainBinding.fragmentContainer.getId(), calculatorFragment,"BlankFragmentTag").addToBackStack(null).commit();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu1){
        getMenuInflater().inflate(R.menu.menu,menu1);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        HistoryFragment historyFragment =null;
        if (menuItem.getItemId()==R.id.history){
            //blankFragment.onDestroyView();
            historyFragment = HistoryFragment.newInstance(activityMainBinding.fragmentContainer.getId());
            fragmentTransaction=getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(activityMainBinding.fragmentContainer.getId(), historyFragment,"BlankFragment2Tag").addToBackStack(null).commit();
        }
        return true;
    }
}