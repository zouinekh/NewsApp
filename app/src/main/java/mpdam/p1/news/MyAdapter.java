package mpdam.p1.news;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import java.io.Serializable;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.RvViewHolder>  {
    public List<News> items;
    public Context context;
    MyAdapter(Context context,List<News> news){
        this.context=context;
        this.items=news;

    }


    @NonNull
    @Override
    public RvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.newsitem,parent,false);
        return new RvViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RvViewHolder holder, int position) {
        News  s = items.get(position);
        holder.textView.setText(s.getTitle());
        holder.myImage.setImageResource(s.getImage());

        Intent i = new Intent(context, newsDetails.class);
        i.putExtra("news",s);
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(i);

            }
        });
        holder.myImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();

    }

    public class RvViewHolder extends RecyclerView.ViewHolder{
        public ImageView  myImage;
        public TextView textView;
        public RvViewHolder(@NonNull View itemView) {
            super(itemView);
            myImage=itemView.findViewById(R.id.imageTitle);
            textView=itemView.findViewById(R.id.textNews);
        }
    }
}
