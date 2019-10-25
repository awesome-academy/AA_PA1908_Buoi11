package vn.sunasterisk.buoi11_implicitintentandmenu.screen.main;

import vn.sunasterisk.buoi11_implicitintentandmenu.R;
import vn.sunasterisk.buoi11_implicitintentandmenu.base.BaseActivity;
import vn.sunasterisk.buoi11_implicitintentandmenu.screen.contact.ContactFragment;

public class MainActivity extends BaseActivity {

    private ContactFragment mContactFragment;

    @Override
    protected void registerListeners() {

    }

    @Override
    protected void initComponents() {
        addContactFragment();
    }

    private void addContactFragment() {
        mContactFragment = new ContactFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_container, mContactFragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
}
