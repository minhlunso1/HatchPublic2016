package minhna.hatchsolution;

import android.content.Context;

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

}
