package minhna.hatchsolution;

import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;

public class DriverActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, DriverViewHolder.OnItemClickListener {

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.nav_view)
    NavigationView nav;
    @BindView(R.id.rv)
    RecyclerView rv;

    private SearchUserAdapter adapter;
    private List<User> list;
    String group;

    public DriverActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver);
        ButterKnife.bind(this);
        setupNav();
        initActionBar();
    }

    @Override
    protected void onStart() {
        super.onStart();
        loadData();

    }

    public void loadData() {
        prepare();
        displayData();
    }

    private void prepare() {
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setHasFixedSize(true);

        list = new ArrayList<>();
        List<User> baseList = new ArrayList<>();
        group = getString(R.string.Client) + " ";
        String depart = getString(R.string.Depart) + " ";
        baseList.add(new User(R.drawable.user_5, group + AC.GROUP_1_STR, 1, depart + "8:00", 5.0f, "300.000đ / vé", "Giường nằm 38 chỗ "));
        baseList.add(new User(R.drawable.user_4, group + AC.GROUP_2_STR, 2, depart + "15:00", 3.0f, "280.000đ / vé", "Giường nằm 41 chỗ "));
        baseList.add(new User(R.drawable.user_2, group + AC.GROUP_3_STR, 3, depart + "8:00", 2.0f, "250.000đ / vé", "Giường nằm 38 chỗ "));
        baseList.add(new User(R.drawable.user_3, group + AC.GROUP_2_STR, 3, depart + "10:00", 3.0f, "260.000đ / vé", "Giường nằm 45 chỗ "));
        baseList.add(new User(R.drawable.user_1, group + AC.GROUP_3_STR, 2, depart + "19:00", 2.0f, "250.000đ / vé", "Giường nằm 41 chỗ "));
        baseList.add(new User(R.drawable.user_6, group + AC.GROUP_2_STR, 3, depart + "8:00", 3.0f, "270.000đ / vé", "Giường nằm 41 chỗ "));
        for (int i=0;i<baseList.size();i++) {
            User user = baseList.get(i);
            int mark = (int) user.ratingMark;
            if (BaseApplication.group == AC.ALL || Utils.getGroupString(this, BaseApplication.group).equals(user.name)) {
                if (mark <= BaseApplication.maxPoint && mark >= BaseApplication.minPoint)
                    list.add(user);
            }
            Collections.sort(list, new DriverComparision());
        }
    }

    private void displayData() {
        adapter = new SearchUserAdapter(list, this);
        rv.setAdapter(new ScaleInAnimationAdapter(adapter));
    }

    private void setupNav() {
        nav.setNavigationItemSelectedListener(this);
    }

    private void initActionBar() {
        if (getSupportActionBar() != null){
            ActionBar actionBar = getSupportActionBar();
            actionBar.setTitle(getString(R.string.Trip_demo));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                FragmentManager fm = getSupportFragmentManager();
                DialogFilter editNameDialog = DialogFilter.newInstance();
                editNameDialog.show(fm, "diag_filter");
                return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        return false;
    }

    @Override
    public void onItemClick(View itemView, int position) {
        User tmp = list.get(position);
        AC.GROUP_CHOOSEN_TYPE = tmp.groupId;
        AC.GROUP_CHOOSEN = tmp.name;
        AC.GROUP_AVA = tmp.img_ava;
        AC.PRICE_CHOOSEN = tmp.price;

        FragmentManager fm = getSupportFragmentManager();
        CommentDialog editNameDialog = CommentDialog.newInstance();
        editNameDialog.show(fm, "diag_comment");
    }
}
