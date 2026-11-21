package isep.lab.mvc.model;

public class Person {
    private String nom;
    private String prenom;
    private String date_naiss;

    private String sex;

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getDate_naiss() {
        return date_naiss;
    }

    public String getSex() {
        return sex;
    }

    public void setNom(String value) {
        nom = value;
    }

    public void setPrenom(String value) {
        prenom = value;
    }

    public void setDate_naiss(String value) {
        date_naiss = value;
    }

    public void setSex(String value) {
        sex = value;
    }

    public int getBirthYear() {
        return Integer.parseInt(date_naiss.substring(0, 4));
    }

    public Person(String nom, String prenom, String date_naiss, String sex) {
        this.nom = nom;
        this.prenom = prenom;
        this.date_naiss = date_naiss;
        this.sex = sex;
    }

}
