package com.example.sudindev.crypto;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
public class CustomAdapter extends BaseAdapter{

    Context c;
    ArrayList<CryptoCurrency> users;

    public CustomAdapter(Context c, ArrayList<CryptoCurrency> users) {
        this.c = c;
        this.users = users;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int i) {
        return users.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null)
        {
            view=LayoutInflater.from(c).inflate(R.layout.model,viewGroup,false);
        }

        TextView nameTxt=view.findViewById(R.id.nameTxt);
        TextView usernameTxt=view.findViewById(R.id.usernameTxt);
        TextView emailTxt=view.findViewById(R.id.emailTxt);
        TextView g=view.findViewById(R.id.textView2);
        CryptoCurrency user= (CryptoCurrency) this.getItem(i);

        nameTxt.setText(user.getName());
        emailTxt.setText("USD Rate  : "+user.getUsd());
        usernameTxt.setText("Percentage Change in 1 Hour  : "+user.getPercent());
        g.setText("   "+user.getName().charAt(0)+"  ");
        return view;
    }
}