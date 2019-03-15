package app.tfkproject.objekwisatabatam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.shashank.sony.fancyaboutpagelib.FancyAboutPage;

public class TentangActivity extends AppCompatActivity {

    FancyAboutPage fancyAboutPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang);

        getSupportActionBar().setTitle("Tentang");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fancyAboutPage = (FancyAboutPage) findViewById(R.id.fancyaboutpage);
        //fancyAboutPage.setCoverTintColor(Color.GREEN);  //Optional
        fancyAboutPage.setCover(R.drawable.wisata_batam_cover); //Pass your cover image
        fancyAboutPage.setName("Pemerintah Kota batam");
        fancyAboutPage.setDescription("https://batam.go.id");
        fancyAboutPage.setAppIcon(R.mipmap.ic_launcher); //Pass your app icon image
        fancyAboutPage.setAppName("Objek Wisata Kota Batam");
        fancyAboutPage.setVersionNameAsAppSubTitle("1.0.0");
        fancyAboutPage.setAppDescription("Sektor pariwisata merupakan salah satu sektor andalan kegiatan perekonomian yang berorientasi pada perluasan lapangan kerja dan kesempatan kerja. Selajan dengan usaha pemerintah dalam mencapai sasaran pembangunan. Pengembangan sektor pariwisata saat ini mendapat perhatian serius karena selain untuk menciptakan lapangan kerja, pembangunan pariwisata mampu menggalakkan kegiatan ekonomi lainnya, termasuk pendapatan daerah dan negara serta penerimaan devisa.");

        fancyAboutPage.addEmailLink("kota@batam.go.id");     //Add your email id
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
