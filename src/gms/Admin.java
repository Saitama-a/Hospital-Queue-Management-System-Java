package gms;

public class Admin {


private String username;
private String password;

public Admin(String username,
             String password) {
    this.username = username;
    this.password = password;
}

public String getUsername() {
    return username;
}

public boolean login(String user,
                     String pass) {
    return username.equals(user)
            && password.equals(pass);
}

@Override
public String toString() {
    return username + "," + password;
}


}
