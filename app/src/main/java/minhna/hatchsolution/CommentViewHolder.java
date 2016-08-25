package minhna.hatchsolution;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 22-Aug-16.
 */
public class CommentViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.img_ava)
    ImageView imgAva;
    @BindView(R.id.tv_header)
    TextView tvHeader;
    @BindView(R.id.tv_body)
    TextView tvBody;

    @BindView(R.id.star1)
    ImageView imgStar1;
    @BindView(R.id.star2)
    ImageView imgStar2;
    @BindView(R.id.star3)
    ImageView imgStar3;
    @BindView(R.id.star4)
    ImageView imgStar4;
    @BindView(R.id.star5)
    ImageView imgStar5;


    public CommentViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }

}
