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
import app.tfkproject.objekwisatabatam.model.ItemEvent;

/**
 * Created by taufik on 21/04/18.
 */

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder>{

    List<ItemEvent> items;
    Context context;

    public EventAdapter(Context context, List<ItemEvent> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public EventAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.txtNo.setText(items.get(position).getNo());
        holder.txtTgl.setText(items.get(position).getTanggal());
        holder.txtEvent.setText(items.get(position).getEvent());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtNo, txtTgl, txtEvent;

        public ViewHolder(View itemView) {
            super(itemView);
            txtNo = (TextView) itemView.findViewById(R.id.text_no);
            txtTgl = (TextView) itemView.findViewById(R.id.text_tanggal);
            txtEvent = (TextView) itemView.findViewById(R.id.text_evnt);
        }
    }

}
