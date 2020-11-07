package com.example.simple_calculator.Fragments;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.example.simple_calculator.Adaptar.CustomAdapter;
import com.example.simple_calculator.Database.Data;
import com.example.simple_calculator.Remote.DataCallBack;
import com.example.simple_calculator.Remote.DataManager;
import com.example.simple_calculator.databinding.ActivityMainBinding;
import com.example.simple_calculator.databinding.FragmentHistoryBinding;
import java.util.List;

public class HistoryFragment extends Fragment implements DataCallBack {

    protected FragmentHistoryBinding fragmentHistoryBinding;
    private ListView listView;
    private CustomAdapter customAdapter;
    private DataManager dataManager;
    Context context=null;
    public int containerId;
    private CalculatorFragment calculatorFragment;
    private ActivityMainBinding activityMainBinding;

    public HistoryFragment() {
        // Required empty public constructor
    }

    public static HistoryFragment newInstance(int containerId) {
        HistoryFragment fragment = new HistoryFragment();
        Bundle args= new Bundle();
        args.putInt("ContainerId",containerId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            containerId = getArguments().getInt("ContainerId");
        }
        dataManager=new DataManager(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        try {
            fragmentHistoryBinding = FragmentHistoryBinding.inflate(inflater, container, false);
            dataManager.loadData(HistoryFragment.this);
            fragmentHistoryBinding.exit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    calculatorFragment=CalculatorFragment.newInstance(activityMainBinding.fragmentContainer.getId());
                    FragmentManager fragmentManager=getFragmentManager();
                    FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                    fragmentTransaction.replace(activityMainBinding.fragmentContainer.getId(), calculatorFragment,"BlankFragmentTag").addToBackStack(null).commit();
                }
            });
//        }
//        catch (Exception e){
//            Log.e(TAG,"onCreateView BlankFragment2",e);
//        }
        return fragmentHistoryBinding.getRoot();
    }

    @Override
    public void dataError() {

    }

    @Override
    public void loadData(List<Data> dataList) {
        customAdapter= new CustomAdapter(context,dataList);
        listView.setAdapter(customAdapter);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        fragmentHistoryBinding = null;
    }
    @Override
    public void onDetach() {
        super.onDetach();
        context=null;
    }
}