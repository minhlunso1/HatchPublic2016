package minhna.hatchsolution;

import java.util.Comparator;

public class DriverComparision implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        if (o1.ratingMark > o2.ratingMark)
            return -1;
         else if (o1.ratingMark == o2.ratingMark)
            return 0;
        return 1;
    }
}