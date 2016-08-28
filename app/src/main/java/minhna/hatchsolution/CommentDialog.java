package minhna.hatchsolution;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 20-Aug-16.
 */
public class CommentDialog extends DialogFragment {

    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.title)
    TextView tvTitle;
    @BindView(R.id.tv_price)
    TextView tvPrice;

    private CommentAdapter adapter;
    private DriverActivity activity;

    public CommentDialog() {
    }

    public static CommentDialog newInstance() {
        CommentDialog fragment = new CommentDialog();
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        activity = (DriverActivity) getActivity();
        return dialog;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.diag_comment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String title = AC.GROUP_CHOOSEN + " Review";
        tvTitle.setText(title);
        tvPrice.setText(AC.PRICE_CHOOSEN);
        getData();
        setupRV();
    }

    private void getData() {
        List<Comment> list = new ArrayList<>();
        if (AC.GROUP_CHOOSEN_TYPE==1) {
            list.add(new Comment(R.drawable.user_9, "Rita Phạm", "Chạy xe an toàn, hài long với chất lượng", 5));
            list.add(new Comment(R.drawable.user_7, "Trang Phan", "Dịch vụ tốt, tài xế chu đáo", 5));
            list.add(new Comment(R.drawable.user_8, "Lệ Quyên", "Không vượt ẩu", 4));
            list.add(new Comment(R.drawable.user_10, "Chi Nguyen", "Xe sạch sẽ, giường nằm thoải mái", 5));
        } else if (AC.GROUP_CHOOSEN_TYPE==2) {
            list.add(new Comment(R.drawable.user_9, "Rita Phạm", "Thường hay lấn tuyến", 2));
            list.add(new Comment(R.drawable.user_7, "Trang Phan", "Dịch vụ tốt, tài xế chu đáo", 5));
            list.add(new Comment(R.drawable.user_8, "Lệ Quyên", "Thời gian nghỉ giữa chuyến quá nhanh", 3));
            list.add(new Comment(R.drawable.user_10, "Chi Nguyen", "Còn vượt ẩu", 2));
        } else {
            list.add(new Comment(R.drawable.user_9, "Rita Phạm", "Thường hay lấn tuyến", 2));
            list.add(new Comment(R.drawable.user_7, "Trang Phan", "Chăm sóc khách chưa tốt", 2));
            list.add(new Comment(R.drawable.user_8, "Lệ Quyên", "Chua thật sự yên tâm với nhà xe", 2));
            list.add(new Comment(R.drawable.user_10, "Chi Nguyen", "Chạy quá ẩu", 1));
        }
        adapter = new CommentAdapter(list);
    }

    @Override
    public void onResume() {
        super.onResume();
        makeWrapContent();
    }

    private void setupRV() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(activity);
        rv.setLayoutManager(layoutManager);
        rv.setHasFixedSize(true);
        rv.setAdapter(adapter);
    }

    private void makeWrapContent() {
        ViewGroup.LayoutParams params = getDialog().getWindow().getAttributes();
        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        getDialog().getWindow().setAttributes((WindowManager.LayoutParams) params);
    }

    @OnClick(R.id.img_close)
    public void closeDialog() {
        dismiss();
    }

    @OnClick(R.id.tv_book)
    public void bookTrip() {
        activity.showConfirmDialog();
        dismiss();
    }

}
