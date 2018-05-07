package repository;

public class User {
    private String token = "";
    private int userId = 0;
    private String userName = "";
    private String firstName = "";
    private String lastName = "";

    public void setAll(String token, int userId, String userName, String firstName, String lastName) {
        this.token = token;
        this.userId = userId;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void clear() {
        this.token = "";
        this.userId = 0;
        this.userName = "";
        this.firstName = "";
        this.lastName = "";
    }

    public String getToken() {
        return token;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
