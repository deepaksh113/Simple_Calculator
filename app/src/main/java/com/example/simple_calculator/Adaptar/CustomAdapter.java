package com.example.simple_calculator.Adaptar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.simple_calculator.Database.Data;
import com.example.simple_calculator.R;

import java.util.List;

public class CustomAdapter extends BaseAdapter {
    private List<Data> data;
    private Context context;
    private LayoutInflater layoutInflater;
    public CustomAdapter(Context context, List<Data> data){
        LayoutInflater layoutInflater= LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if (convertView== null){
            convertView=layoutInflater.inflate(R.layout.fragment_history,null);
            viewHolder= new ViewHolder();
            viewHolder.firstVariable=(TextView) convertView.findViewById(R.id.firstVariable);
            viewHolder.operator=(TextView) convertView.findViewById(R.id.operator);
            viewHolder.secondVariable=(TextView) convertView.findViewById(R.id.secondVariable);
            viewHolder.result=(TextView) convertView.findViewById(R.id.result);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder=(ViewHolder) convertView.getTag();
        }
        Data data= (Data) getItem(pos);
        viewHolder.firstVariable.setText((int)data.getFirstVariable());
        viewHolder.firstVariable.setText(data.getOperator());
        viewHolder.firstVariable.setText((int)data.getSecondVariable());
        viewHolder.firstVariable.setText((int)data.getResult());

        return convertView;
    }
    public class ViewHolder{
        TextView firstVariable,operator,secondVariable,result;
    }
}
