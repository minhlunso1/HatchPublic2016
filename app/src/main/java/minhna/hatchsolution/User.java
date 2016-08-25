package minhna.hatchsolution;

/**
 * Created by Administrator on 21-Aug-16.
 */
public class User {
    public int img_ava;
    public String name;
    public String group;
    public float ratingMark;
    public String price;

    public User(int img_ava, String name, String group, float ratingMark, String price) {
        this.img_ava = img_ava;
        this.name = name;
        this.group = group;
        this.ratingMark = ratingMark;
        this.price = price;
    }
}
