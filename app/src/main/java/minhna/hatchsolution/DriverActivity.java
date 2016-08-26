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
import android.widget.Toast;

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
        baseList.add(new User(R.drawable.user_5, "Nguyễn Minh Trí", "Nhà xe Việt Khuê", 5.0f, "190.000đ"));
        baseList.add(new User(R.drawable.user_2, "Vũ Quang Huy", "Nhà xe Hotelic", 3.0f, "180.000đ"));
        baseList.add(new User(R.drawable.user_3, "Nguyễn Anh Minh", "Nhà xe Hoa Cúc", 2.0f, "170.000đ"));
        baseList.add(new User(R.drawable.user_6, "Lý Quốc Hoàng", "Nhà xe Hotelic", 3.0f, "150.000đ"));
        baseList.add(new User(R.drawable.user_4, "Trần Lữ Sinh", "Nhà xe Hotelic", 3.0f, "150.000đ"));
        baseList.add(new User(R.drawable.user_1, "Đỗ Việt Linh", "Nhà xe Hotelic", 3.0f, "170.000đ"));
        for (int i=0;i<baseList.size();i++) {
            User user = baseList.get(i);
            int mark = (int) user.ratingMark;
            if (BaseApplication.group == AC.ALL || Utils.getGroupString(BaseApplication.group).equals(user.group)) {
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
        if (position==0) {
            FragmentManager fm = getSupportFragmentManager();
            CommentDialog editNameDialog = CommentDialog.newInstance();
            editNameDialog.show(fm, "diag_comment");
        } else
            Toast.makeText(DriverActivity.this, getString(R.string.Please_choose_another), Toast.LENGTH_SHORT).show();
    }
}
