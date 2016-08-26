package minhna.hatchsolution;

/**
 * Created by Administrator on 26-Aug-16.
 */
public class Utils {

    public static String getGroupString (int key) {
        String returnString = "Nhà xe ";
        if (key==AC.GROUP_1)
            return returnString + "Việt Khuê";
        else if (key==AC.GROUP_2)
            return returnString + "Hotelic";
        else if (key==AC.GROUP_3)
            return returnString + "Hoa Cúc";
        else
            return returnString;
    }

}
