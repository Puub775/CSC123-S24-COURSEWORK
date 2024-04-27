
public class Member {
    private int membershipNumber;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String city;
    private String zipCode;
    private boolean isChild;
    private Member guardian;

    public Member(int membershipNumber, String firstName, String lastName, String dateOfBirth, String city, String zipCode, boolean isChild, Member guardian) {
        this.membershipNumber = membershipNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.city = city;
        this.zipCode = zipCode;
        this.isChild = isChild;
        this.guardian = guardian;
    }

    public int getMembershipNumber() {
        return membershipNumber;
    }

    public void setMembershipNumber(int membershipNumber) {
        this.membershipNumber = membershipNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public boolean isChild() {
        return isChild;
    }

    public void setChild(boolean child) {
        isChild = child;
    }

    public Member getGuardian() {
        return guardian;
    }

    public void setGuardian(Member guardian) {
        this.guardian = guardian;
    }
}

