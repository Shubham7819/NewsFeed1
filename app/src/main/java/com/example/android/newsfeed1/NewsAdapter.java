package com.example.android.newsfeed1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {

    private static final String SEPARATOR_1 = "T";
    private static final String SEPARATOR_2 = "Z";

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.news_list_item, parent, false);
        }

        News currentNews = getItem(position);

        TextView headlineView = (TextView) convertView.findViewById(R.id.headlineTV);
        headlineView.setText(currentNews.getHeadline());

        TextView sectionView = (TextView) convertView.findViewById(R.id.sectionTV);
        sectionView.setText(currentNews.getSection());

        String dateAndTime = currentNews.getPublicationDate();
        String date = null;
        String time = null;

        if (dateAndTime.contains(SEPARATOR_1)){
            String[] parts = dateAndTime.split(SEPARATOR_1);
            date = parts[0];
            time = parts[1];
            if (time.contains(SEPARATOR_2)){
                String part[] = time.split(SEPARATOR_2);
                time = part[0];
            }
        }

        TextView dateView = (TextView) convertView.findViewById(R.id.date);
        dateView.setText(date);

        TextView timeView = (TextView) convertView.findViewById(R.id.time);
        timeView.setText(time);

        return convertView;
    }

    public NewsAdapter(@NonNull Context context, List<News> news) {
        super(context, 0, news);
    }

}
