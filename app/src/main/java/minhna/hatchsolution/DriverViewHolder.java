package minhna.hatchsolution;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 21-Aug-16.
 */
public class DriverViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.img_ava)
    ImageView imgAva;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_group)
    TextView tvGroup;
    @BindView(R.id.tv_price)
    TextView tvPrice;

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

    private OnItemClickListener mylistener;

    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
    }

    public DriverViewHolder (View view, OnItemClickListener listener) {
        super(view);
        mylistener = listener;
        ButterKnife.bind(this, view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mylistener != null)
                    mylistener.onItemClick(itemView, getLayoutPosition());
            }
        });
    }

}
