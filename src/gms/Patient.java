package gms;

public class Patient extends Person {


private int token;
private String disease;
private String status;

public Patient(int token, String name,
               String disease, String status) {
    super(name);
    this.token = token;
    this.disease = disease;
    this.status = status;
}

public int getToken() {
    return token;
}

public String getDisease() {
    return disease;
}

public String getStatus() {
    return status;
}

public void setDisease(String disease) {
    this.disease = disease;
}

public void setStatus(String status) {
    this.status = status;
}

@Override
public String getDetails() {
    return "Token: " + token +
            "\nName: " + name +
            "\nDisease: " + disease +
            "\nStatus: " + status;
}

}
