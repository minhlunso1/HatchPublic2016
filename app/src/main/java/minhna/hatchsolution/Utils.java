package minhna.hatchsolution;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.util.Locale;

/**
 * Created by Administrator on 26-Aug-16.
 */
public class Utils {

    public static String getGroupString (Context context, int key) {
        String returnString;
        if (Locale.getDefault().getLanguage().equals("en")) {
            returnString = " " + context.getString(R.string.Client);
            if (key==AC.GROUP_1)
                return AC.GROUP_1_STR + returnString;
            else if (key==AC.GROUP_2)
                return AC.GROUP_2_STR + returnString;
            else if (key==AC.GROUP_3)
                return AC.GROUP_3_STR + returnString;
        }
        else {
            returnString = context.getString(R.string.Client) + " ";
            if (key==AC.GROUP_1)
                return returnString + AC.GROUP_1_STR;
            else if (key==AC.GROUP_2)
                return returnString + AC.GROUP_2_STR;
            else if (key==AC.GROUP_3)
                return returnString + AC.GROUP_3_STR;
        }
        return returnString;
    }

    public static boolean isConnectionAvaiable(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null)
                for (int i = 0; i < info.length; i++)
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
        }
        return false;
    }

}
