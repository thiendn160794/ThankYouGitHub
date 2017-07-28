package com.wigoanalytics.analytics.wigo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.wigoanalytics.analytics.wigo.R;
import com.wigoanalytics.analytics.wigo.model.dto.Contact;

import java.util.ArrayList;

/**
 * Created by thiendn on 27/07/2017.
 */

public class ContactsListAdapter extends RecyclerView.Adapter<ContactsListAdapter.ViewHolder> {

    ArrayList<Contact> mListContact;
    Context mContext;

    public ContactsListAdapter(ArrayList<Contact> mListContact) {
        this.mListContact = mListContact;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contacts_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvPosition.setText(mListContact.get(position).getPosition());
        holder.tvNameContact.setText(mListContact.get(position).getName());
        Glide.with(mContext).load(mListContact.get(position).getAvatar()).apply(RequestOptions.circleCropTransform()).into(holder.ivAvatarContact);
    }

    @Override
    public int getItemCount() {
        return mListContact.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder{
        ImageView ivAvatarContact;
        TextView tvNameContact;
        TextView tvPosition;

        public ViewHolder(View itemView) {
            super(itemView);
            ivAvatarContact = (ImageView) itemView.findViewById(R.id.iv_avatar_contact);
            tvNameContact = (TextView) itemView.findViewById(R.id.tv_name);
            tvPosition = (TextView) itemView.findViewById(R.id.tv_job_title);
        }
    }
}
