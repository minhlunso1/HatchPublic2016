package minhna.hatchsolution;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.rey.material.widget.Spinner;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.apptik.widget.MultiSlider;

/**
 * Created by Administrator on 26-Aug-16.
 */
public class DialogFilter extends DialogFragment {

    @BindView(R.id.sliderStar)
    MultiSlider sliderStar;
    @BindView(R.id.spinnerGroup)
    Spinner spinner;
    @BindView(R.id.tvStarNumber)
    TextView tvStarNumber;
    @BindView(R.id.btnDone)
    Button btnDone;

    private int maxDistance, minStar, gender;
    private DriverActivity driverActivity;

    public DialogFilter() {
    }

    public static DialogFilter newInstance() {
        DialogFilter fragment = new DialogFilter();
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        driverActivity = (DriverActivity) getActivity();
        return dialog;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_filter, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setupValue();
        setDistanceNumber(tvStarNumber);
        sliderStar.getThumb(0).setValue(minStar);
        sliderStar.getThumb(1).setValue(maxDistance);
        sliderStar.setOnThumbValueChangeListener(new MultiSlider.OnThumbValueChangeListener() {
            @Override
            public void onValueChanged(MultiSlider multiSlider, MultiSlider.Thumb thumb, int thumbIndex, int value) {
                if (thumbIndex == 0)
                    minStar = value;
                else
                    maxDistance = value;
                setDistanceNumber(tvStarNumber);
            }
        });

        String[] items = new String[]{driverActivity.getString(R.string.all), AC.GROUP_1_STR, AC.GROUP_2_STR, AC.GROUP_3_STR};
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, items);
        spinner.setAdapter(spinnerAdapter);
        spinner.setSelection(gender);

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseApplication.maxPoint = maxDistance;
                BaseApplication.minPoint = minStar;
                BaseApplication.group = spinner.getSelectedItemPosition();
                driverActivity.loadData();
                dismiss();
            }
        });

    }

    private void setupValue() {
        maxDistance = (int) BaseApplication.maxPoint;
        minStar = (int) BaseApplication.minPoint;
        gender = BaseApplication.group;
    }

    @Override
    public void onResume() {
        makeWrapContent();
        super.onResume();
    }

    private void setDistanceNumber(TextView tv) {
            tv.setText(minStar + " - "+maxDistance + " sao");
    }

    private void makeWrapContent() {
        ViewGroup.LayoutParams params = getDialog().getWindow().getAttributes();
        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        getDialog().getWindow().setAttributes((android.view.WindowManager.LayoutParams) params);
    }
}
