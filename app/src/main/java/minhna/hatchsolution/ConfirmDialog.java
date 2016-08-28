package minhna.hatchsolution;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.Firebase;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 26-Aug-16.
 */
public class ConfirmDialog extends DialogFragment {

    @BindView(R.id.tv_name)
    EditText edtName;
    @BindView(R.id.tv_phone)
    EditText edtPhone;
    @BindView(R.id.tv_book)
    TextView btnDone;

    private Firebase myFirebaseRef;
    private DriverActivity driverActivity;

    public ConfirmDialog() {
    }

    public static ConfirmDialog newInstance() {
        ConfirmDialog fragment = new ConfirmDialog();
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        driverActivity = (DriverActivity) getActivity();
        return dialog;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.diag_confirm, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public void onResume() {
        makeWrapContent();
        super.onResume();
    }

    private void makeWrapContent() {
        ViewGroup.LayoutParams params = getDialog().getWindow().getAttributes();
        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        getDialog().getWindow().setAttributes((WindowManager.LayoutParams) params);
    }
}
