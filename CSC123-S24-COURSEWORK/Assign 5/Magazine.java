//Name: Pablo Conde 
//Email: pconde1@csudh.edu
public class Magazine extends Material {
    private String publicationDate;
    private int issueNumber;

    public Magazine(int itemReference, String title, double replacementValue, String location, boolean isSuitableForChildren, 
    		String publicationDate, int issueNumber) {  super(itemReference, title, replacementValue, location, isSuitableForChildren);
        this.publicationDate = publicationDate;
        this.issueNumber = issueNumber;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }
}

