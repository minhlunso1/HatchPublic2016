package minhna.hatchsolution;

import android.app.Application;

/**
 * Created by Administrator on 26-Aug-16.
 */
public class BaseApplication extends Application {
    public static float maxPoint = 5;
    public static float minPoint = 1;
    public static int group = 0;

    @Override
    public void onCreate() {
        super.onCreate();
        setupGroupName();
    }

    private void setupGroupName() {
        AC.GROUP_1_STR = getString(R.string.Group_1);
        AC.GROUP_2_STR = getString(R.string.Group_2);
        AC.GROUP_3_STR = getString(R.string.Group_3);
    }
}
