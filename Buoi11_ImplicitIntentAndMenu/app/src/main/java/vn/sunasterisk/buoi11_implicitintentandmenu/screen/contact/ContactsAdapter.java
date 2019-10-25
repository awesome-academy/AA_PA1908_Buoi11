package vn.sunasterisk.buoi11_implicitintentandmenu.screen.contact;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.sunasterisk.buoi11_implicitintentandmenu.R;
import vn.sunasterisk.buoi11_implicitintentandmenu.model.Contact;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {

    private List<Contact> mContacts;
    private OnItemListeners mListeners;

    public ContactsAdapter(List<Contact> contacts) {
        mContacts = contacts;
    }

    public void setListeners(OnItemListeners listeners) {
        mListeners = listeners;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_contact, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Contact contact = mContacts.get(position);
        holder.bindData(contact);
    }

    @Override
    public int getItemCount() {
        return mContacts == null ? 0 : mContacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        private ImageView mImageAvatar;
        private TextView mTextName;
        private TextView mTextPhone;
        private ConstraintLayout mLayoutContact;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mImageAvatar = itemView.findViewById(R.id.image_avatar);
            mTextName = itemView.findViewById(R.id.text_name);
            mTextPhone = itemView.findViewById(R.id.text_phone);
            mLayoutContact = itemView.findViewById(R.id.layout_contact);
            mLayoutContact.setOnClickListener(this);
        }

        public void bindData(Contact contact) {
            mImageAvatar.setImageResource(contact.getAvatarId());
            mTextName.setText(contact.getName());
            mTextPhone.setText(contact.getPhone());
        }

        @Override
        public void onClick(View v) {
            mListeners.onItemClick(mContacts.get(getAdapterPosition()));
        }
    }

    public interface OnItemListeners {
        void onItemClick(Contact contact);
    }
}
