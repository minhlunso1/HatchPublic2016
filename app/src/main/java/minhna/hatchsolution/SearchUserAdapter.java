package minhna.hatchsolution;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class SearchUserAdapter extends RecyclerView.Adapter<DriverViewHolder> {

    private Context context;
    private List<User> list;
    private DriverViewHolder.OnItemClickListener listener;


    public SearchUserAdapter(List<User> userList, DriverViewHolder.OnItemClickListener listener) {
        list = userList;
        this.listener = listener;
    }

    @Override
    public DriverViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_driver, parent, false);
        return new DriverViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(DriverViewHolder holder, int position) {
        User tmp = list.get(position);
        holder.imgAva.setImageDrawable(ContextCompat.getDrawable(context, tmp.img_ava));
        holder.tvName.setText(tmp.name);
        holder.tvGroup.setText(tmp.group);
        holder.tvPrice.setText(tmp.price);
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