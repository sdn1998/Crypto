package com.example.sudindev.crypto;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class JSONParser extends AsyncTask<Void,Void,Boolean>{

    Context c;
    String jsonData;
    ListView lv;

    ProgressDialog pd;
    ArrayList<CryptoCurrency> users=new ArrayList<>();

    public JSONParser(Context c, String jsonData, ListView lv) {
        this.c = c;
        this.jsonData = jsonData;
        this.lv = lv;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        pd=new ProgressDialog(c);
        pd.setTitle("Parse JSON");
        pd.setMessage("Parsing...Please wait");
        pd.show();
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        return parse();
    }

    @Override
    protected void onPostExecute(Boolean isParsed) {
        super.onPostExecute(isParsed);

        pd.dismiss();
        if(isParsed)
        {
            //BIND
            lv.setAdapter(new CustomAdapter(c,users));
        }else
        {
            Toast.makeText(c, "Unable To Parse,Check Your Log output", Toast.LENGTH_SHORT).show();
        }

    }

    private Boolean parse()
    {
        try
        {
            JSONArray ja=new JSONArray(jsonData);
            JSONObject jo;

            users.clear();
            CryptoCurrency user;

            for (int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);

                String name=jo.getString("name");
                String priceusd=jo.getString("price_usd");
                String percent=jo.getString("percent_change_1h");

                user=new CryptoCurrency();

                user.setName(name);
                user.setUsd(priceusd);
                user.setPercent(percent);
                users.add(user);
            }

            return true;

        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

}
