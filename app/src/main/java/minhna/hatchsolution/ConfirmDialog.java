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
import android.widget.Toast;

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
    @BindView(R.id.tv_no_ticket)
    EditText edtTicketQuantity;
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
        Firebase.setAndroidContext(driverActivity);
        myFirebaseRef = new Firebase(AC.FIREBASE_REF).child(String.valueOf(System.currentTimeMillis()));
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
                if (Utils.isConnectionAvaiable(driverActivity)) {
                    boolean first = false;
                    boolean second = false;
                    boolean last = false;
                    if (edtName.getText().toString().trim().equals(""))
                        edtName.setError(driverActivity.getString(R.string.No_blank));
                    else
                        first = true;
                    if (edtPhone.getText().toString().trim().equals(""))
                        edtPhone.setError(driverActivity.getString(R.string.No_blank));
                    else
                        second = true;
                    if (edtTicketQuantity.getText().toString().trim().equals(""))
                        edtTicketQuantity.setError(driverActivity.getString(R.string.No_blank));
                    else
                        last = true;
                    if (first == true && second == true && last == true) {
                        bookTicket();
                        dismiss();
                    }
                } else
                    Toast.makeText(driverActivity, driverActivity.getString(R.string.Please_check_network), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void bookTicket() {
        myFirebaseRef.child("Group_name").setValue(AC.currentUser.name);
        myFirebaseRef.child("Depart").setValue(AC.currentUser.depart);
        myFirebaseRef.child("Type_vehicle").setValue(AC.currentUser.seat);
        myFirebaseRef.child("Price").setValue(AC.currentUser.price);
        myFirebaseRef.child("Travel").setValue("Sai Gon - Nha Trang 1/9/2016");
        myFirebaseRef.child("Receiver").setValue(edtName.getText().toString());
        myFirebaseRef.child("Phone").setValue(edtPhone.getText().toString());
        myFirebaseRef.child("Ticket_Quantity").setValue(edtTicketQuantity.getText().toString());
        Toast.makeText(driverActivity, driverActivity.getString(R.string.Book_successful), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResume() {
        makeWrapContent();
        super.onResume();
        getDialog().setTitle(driverActivity.getString(R.string.Confirm));
    }

    private void makeWrapContent() {
        ViewGroup.LayoutParams params = getDialog().getWindow().getAttributes();
        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        getDialog().getWindow().setAttributes((WindowManager.LayoutParams) params);
    }
}
