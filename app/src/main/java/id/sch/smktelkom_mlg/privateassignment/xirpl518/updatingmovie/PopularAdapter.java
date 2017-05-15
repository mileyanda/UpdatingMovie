package id.sch.smktelkom_mlg.privateassignment.xirpl518.updatingmovie;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by yanda on 15/05/2017.
 */

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ViewHolder> {

    private List<PopularListItem> popularListItems;
    private Context context; //mode default, hanya bisa diakses dengan dipanggil

    public PopularAdapter(List<PopularListItem> popularListItems, Context context) {
        this.popularListItems = popularListItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final PopularListItem popularListItem = popularListItems.get(position);

//        holder.imageViewOtof.setImageResource(R.drawable.ic_memory_black_24dp);
        holder.textViewTitle.setText(popularListItem.getTitle());
        holder.textViewYear.setText(popularListItem.getYear());

        Glide
                .with(context)
                .load("http://image.tmdb.org/t/p/w500" +popularListItem.getImageUrl())
                .into(holder.imageViewOtof);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Will be released soon", Toast.LENGTH_LONG).show();

//                Intent singleBlogIntent = new Intent(context, PopularDetailActivity.class);
//                singleBlogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //addFLags membuka activity dari fragment
//                singleBlogIntent.putExtra("blog_id", position); //position untuk menentukan posisi di array
//                context.startActivity(singleBlogIntent);

//                Intent singleBlogIntent = new Intent(context, DetailActivity.class);
//                singleBlogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                singleBlogIntent.putExtra("blog_id", position);
//                singleBlogIntent.putExtra("jenis", "Popular");
//                context.startActivity(singleBlogIntent);
            }
        });
    }

    @Override
    public int getItemCount() {return popularListItems.size();}

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textViewTitle;
        public TextView textViewYear;
        public ImageView imageViewOtof;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewTitle = (TextView) itemView.findViewById(R.id.textViewHeadAve);
            textViewYear = (TextView) itemView.findViewById(R.id.textViewDescAve);
            imageViewOtof = (ImageView) itemView.findViewById(R.id.imageViewOtofAve);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.LinearLayoutAve);
        }
    }
}