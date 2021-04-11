package ua.kpi.comsys.iv8228;

public class Movie {
    private final String Title;
    private final String Year;
    private final String imdbID;
    private final String Type;
    private final int Poster;

    public Movie(String Title, String Year, String imdbID, String Type, int Poster) {
        this.Title = Title;
        this.Year = Year;
        this.imdbID = imdbID;
        this.Type = Type;
        this.Poster = Poster;
    }

    public String getTitle() {
        return Title;
    }
    public String getYear() {
        return Year;
    }
    public String getimdbID() {
        return imdbID;
    }
    public String getType() {
        return Type;
    }
    public int getPosterID(){
        return Poster;
    }
}

