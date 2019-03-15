package app.tfkproject.objekwisatabatam;

import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.tfkproject.objekwisatabatam.adapter.ObjekWisataAdapter;
import app.tfkproject.objekwisatabatam.model.ItemObjekWisata;

public class ObjekWisataActivity extends AppCompatActivity {

    private SwipeRefreshLayout mySwipeRefreshLayout;
    private RecyclerView rc;
    private List<ItemObjekWisata> itemList;
    private ObjekWisataAdapter adapter;

    private ProgressDialog pDialog;

    private static String url = "http://203.153.21.11/app/wisata-batam/api/wisata_list.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objek_wisata);

        getSupportActionBar().setTitle("Objek Wisata");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mySwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swiperefresh);

        rc = (RecyclerView) findViewById(R.id.recycler_view);
        itemList = new ArrayList<>();

        //isi disini
        new getData().execute();

        adapter = new ObjekWisataAdapter(ObjekWisataActivity.this, itemList);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        rc.setLayoutManager(mLayoutManager);
        rc.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        rc.setItemAnimator(new DefaultItemAnimator());
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
            pDialog = new ProgressDialog(ObjekWisataActivity.this);
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
                            String id = c.getString("id_wisata");
                            String nama = c.getString("nama_objek");
                            String lokasi = c.getString("lokasi");
                            String deskripsi = c.getString("deskripsi");
                            String gambar = c.getString("foto_cover");
                            String latitude = c.getString("latitude");
                            String longitude = c.getString("longitude");

                            itemList.add(new ItemObjekWisata(id, nama, lokasi, deskripsi, gambar, latitude, longitude));

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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false);

        /////
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                Intent intent = new Intent(ObjekWisataActivity.this, ObjekWisataCariActivity.class);
                intent.putExtra("key_pencarian", query);
                startActivity(intent);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                return true;

            }

        });
        /////


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
