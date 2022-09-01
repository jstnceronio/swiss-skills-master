package controllers.dto;

/**
 * One could generate a dto class from a create table statement using this tool ..
 * https://tools.knowledgewalls.com/mysqltabletojavaclass
 */
public class User {
    private int id;
    private String username;
    private String password;

    public User(int id, String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
