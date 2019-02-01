package com.igor.tsearch.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.igor.tsearch.R;
import com.igor.tsearch.model.Tweet;

import java.util.ArrayList;
import java.util.List;

public class TweetsAdapter extends RecyclerView.Adapter {


private Context mContext;
private RecyclerView mRecyclerView;
private List<Tweet> mTweets;
public TweetsAdapter(Context context) {
        mContext = context;
        mTweets = new ArrayList<>();
        }

@Override
public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        }

public void setTweets(List<Tweet> tweets) {
            mTweets.clear();
            mTweets.addAll(tweets);
        }

@NonNull
@Override
public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ConstraintLayout v = (ConstraintLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tweet, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;

        }

@Override
public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        Tweet tweet = mTweets.get(position);
        viewHolder.twTweet.setText(tweet.getContent());

        }

@Override
public int getItemCount() {
        return mTweets.size();
        }

public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView twTweet;

    ViewHolder(View itemView) {
        super(itemView);

        twTweet = (TextView)itemView.findViewById(R.id.tv_tweet);

    }

    @Override
    public void onClick(View view) {
        int itemPosition = mRecyclerView.getChildLayoutPosition(view);


    }
}

}
