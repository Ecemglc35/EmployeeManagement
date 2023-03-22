package Models;

/**
 *
 * @author ecemgulec
 */
public class User {
    private String userName;
    private String password;

    public User() {

    }

    public User(String userName, String password) {

    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    public void add(Employee employee) {

    }

    public void update(Employee employee) {

    }

    public void delete(Employee employee) {

    }

    public String toString() {
        return userName + "," + password;
    }

}