package app.tfkproject.objekwisatabatam.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import app.tfkproject.objekwisatabatam.ObjekDetailActivity;
import app.tfkproject.objekwisatabatam.R;
import app.tfkproject.objekwisatabatam.model.ItemObjekWisata;

/**
 * Created by taufik on 21/04/18.
 */

public class ObjekWisataAdapter extends RecyclerView.Adapter<ObjekWisataAdapter.ViewHolder>{

    List<ItemObjekWisata> items;
    Context context;

    public ObjekWisataAdapter(Context context, List<ItemObjekWisata> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public ObjekWisataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_objek_wisata, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Glide.with(context).load(items.get(position).getGambar()).into(holder.img);
        //holder.imgProduct.setImageResource(items.get(position).getImg());
        holder.txtId.setText(items.get(position).getId());
        holder.txtNama.setText(items.get(position).getNama());
        holder.txtLokasi.setText(items.get(position).getLokasi());
        holder.cardItemMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ObjekDetailActivity.class);
                intent.putExtra("key_id", items.get(position).getId());
                intent.putExtra("key_nama", items.get(position).getNama());
                intent.putExtra("key_gambar", items.get(position).getGambar());
                intent.putExtra("key_deskripsi", items.get(position).getDeskripsi());
                intent.putExtra("key_lokasi", items.get(position).getLokasi());
                intent.putExtra("key_lat", items.get(position).getLatitude());
                intent.putExtra("key_long", items.get(position).getLongitude());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        CardView cardItemMenu;
        TextView txtId;
        ImageView img;
        TextView txtNama, txtLokasi;

        public ViewHolder(View itemView) {
            super(itemView);
            cardItemMenu = (CardView) itemView.findViewById(R.id.card_item_menu);
            txtId = (TextView) itemView.findViewById(R.id.txt_id);
            img = (ImageView) itemView.findViewById(R.id.img);
            txtNama = (TextView) itemView.findViewById(R.id.txt_nama);
            txtLokasi = (TextView) itemView.findViewById(R.id.txt_lokasi);
        }
    }

}
