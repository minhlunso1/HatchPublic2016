package minhna.hatchsolution;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import java.util.List;

/**
 * Created by Administrator on 21-Aug-16.
 */
public class CommentAdapter extends RecyclerView.Adapter<CommentViewHolder> {

    private Context context;
    private List<Comment> list;


    public CommentAdapter(List<Comment> commentList) {
        list = commentList;
    }

    @Override
    public CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_comment, parent, false);
        return new CommentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CommentViewHolder holder, int position) {
        Comment tmp = list.get(position);
        Glide.with(context)
                .load(tmp.img_id)
                .asBitmap()
                .into(new BitmapImageViewTarget(holder.imgAva) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                holder.imgAva.setImageDrawable(circularBitmapDrawable);
            }
        });
        holder.tvHeader.setText(tmp.header);
        holder.tvBody.setText(tmp.body);
        int mark = (int) tmp.ratingMark;
        if (mark>0)
            holder.imgStar1.setVisibility(View.VISIBLE);
        if (mark>1)
            holder.imgStar2.setVisibility(View.VISIBLE);
        if (mark>2)
            holder.imgStar3.setVisibility(View.VISIBLE);
        if (mark>3)
            holder.imgStar4.setVisibility(View.VISIBLE);
        if (mark>4)
            holder.imgStar5.setVisibility(View.VISIBLE);
    }

    @Override
    public int getItemCount() {
        return list==null ? 0:list.size();
    }

}
