package minhna.hatchsolution;

/**
 * Created by Administrator on 21-Aug-16.
 */
public class User {
    public int img_ava;
    public String name;
    public int groupId;
    public String depart;
    public float ratingMark;
    public String price;
    public String seat;

    public User(int img_ava, String name, int groupId, String depart, float ratingMark, String price, String seat) {
        this.img_ava = img_ava;
        this.name = name;
        this.groupId = groupId;
        this.depart= depart;
        this.ratingMark = ratingMark;
        this.price = price;
        this.seat = seat;
    }
}
