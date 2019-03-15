package app.tfkproject.objekwisatabatam;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.tfkproject.objekwisatabatam.adapter.EventAdapter;
import app.tfkproject.objekwisatabatam.model.ItemEvent;
import app.tfkproject.objekwisatabatam.model.ItemProfil;

public class EventActivity extends AppCompatActivity {

    private SwipeRefreshLayout mySwipeRefreshLayout;
    private RecyclerView rc;
    private List<ItemEvent> itemList;
    private EventAdapter adapter;
    private ProgressDialog pDialog;
    private static String url = "http://203.153.21.11/app/wisata-batam/api/event_list.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        getSupportActionBar().setTitle("Event");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mySwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swiperefresh);

        rc = (RecyclerView) findViewById(R.id.recycler_view);
        itemList = new ArrayList<>();

        //isi disini
        new getData().execute();

        adapter = new EventAdapter(EventActivity.this, itemList);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(EventActivity.this);
        rc.setLayoutManager(mLayoutManager);
        rc.setAdapter(adapter);

        mySwipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        itemList.clear();
                        new getData().execute();
                    }
                }
        );
    }

    private class getData extends AsyncTask<Void,Void,String> {

        //variabel untuk tangkap data
        private int scs = 0;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(EventActivity.this);
            pDialog.setMessage("Memuat data...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        protected String doInBackground(Void... params) {

            try{
                //susun parameter
                HashMap<String,String> detail = new HashMap<>();

                try {
                    //convert this HashMap to encodedUrl to send to php file
                    String dataToSend = hashMapToUrl(detail);
                    //make a Http request and send data to php file
                    String response = Request.post(url,dataToSend);

                    //dapatkan respon
                    Log.e("Respon", response);

                    JSONObject ob = new JSONObject(response);
                    scs = ob.getInt("success");

                    if (scs == 1) {
                        JSONArray products = ob.getJSONArray("field");

                        for (int i = 0; i < products.length(); i++) {
                            JSONObject c = products.getJSONObject(i);

                            // Storing each json item in variable
                            String id = c.getString("id_event");
                            String no = c.getString("no");
                            String tgl = c.getString("tanggal");
                            String event = c.getString("event");

                            itemList.add(new ItemEvent(id, no, tgl, event));

                        }
                    } else {
                        // no data found

                    }

                } catch (JSONException e){
                    e.printStackTrace();
                }

            } catch (Exception e){
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            adapter.notifyDataSetChanged();
            pDialog.dismiss();
            mySwipeRefreshLayout.setRefreshing(false);
        }

    }

    private String hashMapToUrl(HashMap<String, String> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for(Map.Entry<String, String> entry : params.entrySet()){
            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
        }

        return result.toString();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
