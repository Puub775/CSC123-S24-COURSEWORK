//Name: Pablo Conde 
//Email: pconde1@csudh.edu
public class DVD extends Material {
    private String releaseDate;
    private int durationMinutes;

    public DVD(int itemReference, String title, double replacementValue, String location, boolean isSuitableForChildren, String releaseDate, int durationMinutes) {
        super(itemReference, title, replacementValue, location, isSuitableForChildren);
        this.releaseDate = releaseDate;
        this.durationMinutes = durationMinutes;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }
}
