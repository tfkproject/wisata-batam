package app.tfkproject.objekwisatabatam;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
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

import app.tfkproject.objekwisatabatam.model.ItemProfil;

public class ProfilActivity extends AppCompatActivity {

    private List<ItemProfil> itemList;
    private ProgressDialog pDialog;
    private static String url = "http://203.153.21.11/app/wisata-batam/api/profil_list.php";

    private TextView txtVisi, txtMisi, txtWeb, txtKontak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        getSupportActionBar().setTitle("Profil");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtVisi     = (TextView) findViewById(R.id.txt_visi);
        txtMisi     = (TextView) findViewById(R.id.txt_misi);
        txtWeb      = (TextView) findViewById(R.id.txt_web);
        txtKontak   = (TextView) findViewById(R.id.txt_kontak);

        itemList = new ArrayList<>();
        new getData().execute();
    }

    private class getData extends AsyncTask<Void,Void,String> {

        //variabel untuk tangkap data
        private int scs = 0;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(ProfilActivity.this);
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
                            String id = c.getString("id_profil");
                            String nama = c.getString("nama");
                            String konten = c.getString("konten");

                            itemList.add(new ItemProfil(id, nama, konten));

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
            pDialog.dismiss();
            txtVisi.setText(itemList.get(0).getKonten());
            txtMisi.setText(itemList.get(1).getKonten());
            txtWeb.setText("  "+itemList.get(2).getKonten());
            txtKontak.setText("  "+itemList.get(3).getKonten());
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
