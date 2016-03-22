package com.noveo.traineeship.network.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.noveo.traineeship.network.R;
import com.noveo.traineeship.network.models.News;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by serg on 22.03.16.
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    List<News> newsItems;

    public NewsAdapter() {
        super();
        newsItems = new ArrayList<News>();
    }

    public void addData(News news) {
        newsItems.add(news);
        notifyDataSetChanged();
    }

    public void clear() {
        newsItems.clear();
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view , viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        News news = newsItems.get(i);
        viewHolder.title.setText(news.getTitle());
//        viewHolder.image.setImageBitmap(news.getImage());
    }

    @Override
    public int getItemCount() {
        return newsItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
//        public ImageView image;
        public TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
//            image = (ImageView) itemView.findViewById();
            title = (TextView)  itemView.findViewById(R.id.title);
        }
    }
}
