package vn.sunasterisk.buoi11_implicitintentandmenu.screen.profile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import vn.sunasterisk.buoi11_implicitintentandmenu.R;
import vn.sunasterisk.buoi11_implicitintentandmenu.base.BaseActivity;
import vn.sunasterisk.buoi11_implicitintentandmenu.model.Contact;
import vn.sunasterisk.buoi11_implicitintentandmenu.screen.contact.ContactFragment;

public class ProfileActivity extends BaseActivity {

    private ImageView mImageAvatar;
    private TextView mTextName;
    private TextView mTextPhone;
    private TextView mTextAddress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void registerListeners() {

    }

    @Override
    protected void initComponents() {

        initViews();

    }

    private void initViews() {
        mImageAvatar = findViewById(R.id.image_avatar);
        mTextName = findViewById(R.id.text_name);
        mTextPhone = findViewById(R.id.text_phone);
        mTextAddress = findViewById(R.id.text_address);

        Intent intent = getIntent();
        if (intent == null) {

            return;
        }

        Contact contact = intent.getParcelableExtra(ContactFragment.KEY_CONTACT);
        mImageAvatar.setImageResource(contact.getAvatarId());
        mTextName.setText(contact.getName());
        mTextPhone.setText(contact.getPhone());
        mTextAddress.setText(contact.getAddress());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_profile;
    }
}
