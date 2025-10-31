package IntermediateLevel.ProductRatingService;

public class Rating {
    private final String userid;
    private int star;
    private final String comment;

    public Rating(String userId, int star, String comment){
        if(star<1 || star>5){
            throw new IllegalArgumentException("star must be between 1 and 5");
        }
        this.userid = userId;
        this.star = star;
        this.comment = comment;
    }

    public String getUserId(){ return userid; }
    public int getStar(){ return star; }
    public String getComment(){ return comment; }
}
