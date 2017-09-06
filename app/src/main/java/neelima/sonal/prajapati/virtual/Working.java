package neelima.sonal.prajapati.virtual;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by DALEJAN1 on 2/25/2017.
 */

public class Working extends Activity implements AdapterView.OnItemClickListener {
    String header;
    WebView webView;
    String result;

    ArrayList<String> lstData = new ArrayList<String>();
    public static final String SERVER_ADDRESS = "http://sonalneelima.esy.es/fetch.php";
    String sem = "";
    String data;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datalist);
        listView = (ListView) findViewById(R.id.datalist);
        Intent i1 = getIntent();
        header = i1.getStringExtra("header");
        sem = i1.getStringExtra("sem");
        Asynctask.header=i1.getStringExtra("header");
        Asynctask.sem=i1.getStringExtra("sem");
        try {
            result=new Asynctask().execute(SERVER_ADDRESS).get();

            Log.d("kayahhsbdbch",result);
            if(result!=null) {
                JSONArray jsonArray = new JSONArray(result);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String data = jsonObject.getString("video_name");
                    lstData.add(data);
                }
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, lstData);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(this);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String itemValue =listView.getItemAtPosition(position).toString();
            Intent i2 = new Intent(Working.this, VideoViewActivity.class);
        i2.putExtra("header",header);
            i2.putExtra("value", itemValue);
            startActivity(i2);

    }
}
