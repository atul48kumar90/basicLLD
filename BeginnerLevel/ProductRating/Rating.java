package ProductRating;

public class Rating {
    private final String userid;
    private final int star;

    public Rating(String userid, int star) {
        if(star < 1 || star >5) {
            throw new IllegalArgumentException("star must be between 1 and 5");
        }
        this.userid = userid;
        this.star = star;
    }

    public String getUserId() {
        return userid;
    }

    public int getStar() {
        return star;
    }
}
