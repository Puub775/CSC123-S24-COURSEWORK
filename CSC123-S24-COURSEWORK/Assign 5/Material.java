//Name: Pablo Conde 
//Email: pconde1@csudh.edu
public class Material {
    private int itemReference;
    private String title;
    private double replacementValue;
    private String location;
    private boolean isSuitableForChildren;

    public Material(int itemReference, String title, double replacementValue, String location, boolean isSuitableForChildren) {
        this.itemReference = itemReference;
        this.title = title;
        this.replacementValue = replacementValue;
        this.location = location;
        this.isSuitableForChildren = isSuitableForChildren;
    }

    public int getItemReference() {
        return itemReference;
    }

    public void setItemReference(int itemReference) {
        this.itemReference = itemReference;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getReplacementValue() {
        return replacementValue;
    }

    public void setReplacementValue(double replacementValue) {
        this.replacementValue = replacementValue;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isSuitableForChildren() {
        return isSuitableForChildren;
    }

    public void setSuitableForChildren(boolean suitableForChildren) {
        isSuitableForChildren = suitableForChildren;
    }
}

