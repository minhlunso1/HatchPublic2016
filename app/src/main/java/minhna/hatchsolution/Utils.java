package minhna.hatchsolution;

/**
 * Created by Administrator on 26-Aug-16.
 */
public class Utils {

    public static String getGroupString (int key) {
        String returnString = "Nhà xe ";
        if (key==AC.LIEN_HUNG)
            return returnString + "Liên Hưng";
        else if (key==AC.VIET_NHAT)
            return returnString + "Việt Nhật";
        else if (key==AC.HANH_CAFE)
            return returnString + "Hạnh Cafe";
        else
            return returnString;
    }

}
