package com.wigoanalytics.analytics.wigo.view.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wigoanalytics.analytics.wigo.R;
import com.wigoanalytics.analytics.wigo.adapter.ContactsListAdapter;
import com.wigoanalytics.analytics.wigo.model.dto.Contact;
import com.wigoanalytics.analytics.wigo.model.local.sharePref.SharedPreferenceRepository;
import com.wigoanalytics.analytics.wigo.model.remote.ApiUtils;
import com.wigoanalytics.analytics.wigo.utils.DialogUtils;
import com.wigoanalytics.analytics.wigo.utils.ToastUtils;
import com.wigoanalytics.analytics.wigo.view.activity.HomeActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by thiendn on 27/07/2017.
 */

public class ListContactFragment extends Fragment {

    @BindView(R.id.toolbar_contact_list)
    Toolbar toolbar;
    @BindView(R.id.rv_list_contacts)
    RecyclerView rvListContacts;

    HomeActivity mActivityCallback;
    ContactsListAdapter mContactsAdapter;
    ArrayList<Contact> mListContact;
    Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityCallback = (HomeActivity) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contacts_list, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mActivityCallback.setSupportActionBar(toolbar);
        mActivityCallback.getSupportActionBar().setDisplayShowTitleEnabled(false);
        final ProgressDialog progressDialog = DialogUtils.createLoadingDialog(mContext);
        progressDialog.show();
        String authKey = SharedPreferenceRepository.getAuthenticationKey(mContext);
        ApiUtils.getApiService().getAllContact(authKey).enqueue(new Callback<List<Contact>>() {
            @Override
            public void onResponse(Call<List<Contact>> call, Response<List<Contact>> response) {
                //TODO: @thiendn add more logic to handle
                ToastUtils.showShortToast(mContext, "Response Code: " + response.code());
                if (response.code() == 200){
                    mListContact = (ArrayList<Contact>) response.body();
                    mContactsAdapter = new ContactsListAdapter(mListContact);
                    rvListContacts.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
                    rvListContacts.setAdapter(mContactsAdapter);
                }
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<List<Contact>> call, Throwable t) {
                ToastUtils.showShortToast(mContext, "Connect fail");
            }
        });
    }
}
