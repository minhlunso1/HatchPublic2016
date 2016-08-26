package minhna.hatchsolution;

import android.app.Dialog;
import android.content.Intent;
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

    private CommentAdapter adapter;
    private AppCompatActivity activity;

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
        activity = (AppCompatActivity) getActivity();
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
        getData();
        setupRV();
    }

    private void getData() {
        List<Comment> list = new ArrayList<>();
        list.add(new Comment(R.drawable.user_9,"Rita Phạm","Lái xe an toàn", 5));
        list.add(new Comment(R.drawable.user_7, "Trang Phan","Dịch vụ tốt, tài xế chu đáo", 5));
        list.add(new Comment(R.drawable.user_8,"Lệ Quyên","Tuy chậm mà chắc. Yên tâm.", 3));
        list.add(new Comment(R.drawable.user_10,"Chi Nguyen","Không vượt ẩu", 5));
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
        Intent intent = new Intent(getActivity(), RatingActivity.class);
        startActivity(intent);
        activity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        dismiss();
    }

}
