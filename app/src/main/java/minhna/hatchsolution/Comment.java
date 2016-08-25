package minhna.hatchsolution;

/**
 * Created by Administrator on 22-Aug-16.
 */
public class Comment {
    
    public int img_id;
    public String header;
    public String body;
    public float ratingMark;

    public Comment(int img_id, String header, String body, float ratingMark) {
        this.img_id = img_id;
        this.header = header;
        this.body = body;
        this.ratingMark = ratingMark;
    }
    
}
