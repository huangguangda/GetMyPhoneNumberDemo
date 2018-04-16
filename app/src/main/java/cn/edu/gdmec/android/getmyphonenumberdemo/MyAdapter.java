package cn.edu.gdmec.android.getmyphonenumberdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Jack on 2018/4/16.
 */

public class MyAdapter extends BaseAdapter{
    private List<PhoneInfo> lists;
    private LinearLayout layout;
    private Context context;//承接上下文

    public MyAdapter(List<PhoneInfo> lists,Context context){
        this.lists=lists;
        this.context=context;
    }
    //返回的是集合的数量
    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int position) {
        return lists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //对ListView进行优化
       /* LayoutInflater inflater = LayoutInflater.from(context);
        layout = (LinearLayout) inflater.inflate(R.layout.call,null);
        TextView nametv = layout.findViewById(R.id.name);
        TextView numbertv = layout.findViewById(R.id.number);
        nametv.setText(lists.get(position).getName());
        numbertv.setText(lists.get(position).getNumber());*/
       ViewHolder holder;
       if (convertView == null){
           convertView = LayoutInflater.from(context).inflate(R.layout.call,null);
           holder = new ViewHolder();
           holder.nametv = convertView.findViewById(R.id.name);
           holder.numbertv = convertView.findViewById(R.id.number);
           holder.nametv.setText(lists.get(position).getName());
           holder.numbertv.setText(lists.get(position).getNumber());
           convertView.setTag(holder);
       }else {
           holder = (ViewHolder) convertView.getTag();
       }
        return convertView;//return layout;
    }
    private static class ViewHolder{
        TextView nametv;
        TextView numbertv;
    }
}
