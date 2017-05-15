package id.sch.smktelkom_mlg.privateassignment.xirpl518.updatingmovie.NewestDB;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.privateassignment.xirpl518.updatingmovie.R;
/**
 * Created by yanda on 15/05/2017.
 */

public class NewestDBAdapter extends RecyclerView.Adapter<NewestDBAdapter.ViewHolder>  {
    private final Context context;
    ArrayList<NewestDBItem> fItem;

    public NewestDBAdapter(ArrayList<NewestDBItem> newestDBItems, Context context) {
        this.fItem = newestDBItems;
        this.context = context;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.favourite_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final NewestDBItem newestDBItem = fItem.get(position);
        holder.textViewHeadfav.setText(newestDBItem.title);
        holder.textViewDescfav.setText(newestDBItem.year);

        Glide
                .with(context)
                .load(newestDBItem.imageUrl)
                .into(holder.imageViewOtoffav);

        holder.buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final NewestDBItem newestDBItem1 = fItem.get(position);
                fItem.remove(position);
                newestDBItem.delete();
                NewestDBAdapter.this.notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return fItem.size();
    }

    public interface INewestDBAdapter {
        void doDelete(int pos);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewHeadfav;
        public TextView textViewDescfav;
        public ImageView imageViewOtoffav;
        public Button buttonDelete;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewHeadfav = (TextView) itemView.findViewById(R.id.textViewHeadFav);
            textViewDescfav = (TextView) itemView.findViewById(R.id.textViewDescFav);
            imageViewOtoffav = (ImageView) itemView.findViewById(R.id.imageViewOtofFav);
            buttonDelete = (Button) itemView.findViewById(R.id.buttonDelete);

        }

    }
}