package minhna.hatchsolution;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 26-Aug-16.
 */
public class RatingActivity extends AppCompatActivity {

    @BindView(R.id.star1)
    ImageView star1;
    @BindView(R.id.star2)
    ImageView star2;
    @BindView(R.id.star3)
    ImageView star3;
    @BindView(R.id.star4)
    ImageView star4;
    @BindView(R.id.star5)
    ImageView star5;
    @BindView(R.id.starS1)
    ImageView starS1;
    @BindView(R.id.starS2)
    ImageView starS2;
    @BindView(R.id.starS3)
    ImageView starS3;
    @BindView(R.id.starS4)
    ImageView starS4;
    @BindView(R.id.starS5)
    ImageView starS5;

    private ImageView[] starsView;
    private ImageView[] starsViews;
    private int starChoose;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
        ButterKnife.bind(this);

        setupStarRating();
        initActionBar();
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    private void initActionBar() {
        if (getSupportActionBar()!=null) {
            ActionBar actionBar = getSupportActionBar();
            actionBar.setDisplayUseLogoEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setHomeAsUpIndicator(ContextCompat.getDrawable(this, R.mipmap.ic_arrow_back_white_24dp));
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return false;
    }

    private void setupStarRating() {
        starsView = new ImageView[]{star1, star2, star3, star4, star5};
        for (int i = 0; i < starsView.length; i++) {
            final int finalI = i;
            starsView[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    starChoose = finalI + 1;
                    for (int j = 0; j <= finalI; j++) {
                        starsView[j].setImageResource(R.mipmap.orange_star);
                    }
                    for (int j = finalI + 1; j < starsView.length; j++) {
                        starsView[j].setImageResource(R.drawable.ic_star_orange_border);
                    }
                }
            });
        }

        starsViews = new ImageView[]{starS1, starS2, starS3, starS4, starS5};
        for (int i = 0; i < starsViews.length; i++) {
            final int finalI = i;
            starsViews[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    starChoose = finalI + 1;
                    for (int j = 0; j <= finalI; j++) {
                        starsViews[j].setImageResource(R.mipmap.orange_star);
                    }
                    for (int j = finalI + 1; j < starsView.length; j++) {
                        starsViews[j].setImageResource(R.drawable.ic_star_orange_border);
                    }
                }
            });
        }
    }

    @OnClick(R.id.btn_send)
    public void sendRating() {
        finish();
    }

}
