package intre;

public class Users {
    protected int id;
    protected String login; 
    protected String password; 
    protected String name;
    protected String surname;
    
    {
        id = 0;
        login = "based";
        password = "asdf";
        name = "asdfsadf";
        surname = "asdfasdfs";
    }

    Users() {
        //
    }

    Users(int id, String login, String password, String name, String surname){
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    public String getData() {
        return "ID: " + id + ", Login: " + login + ", Password: " + password + ", Name: " + name + ", Surname: " + surname + "\n";
    }
}