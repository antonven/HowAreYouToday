package myapps.wycoco.com.howareyoutoday;

/**
 * Created by asus on 25/04/2017.
 */

public class InputModel {
    String age;
    String department;
    String feeling;
    String gender;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getFeeling() {
        return feeling;
    }

    public void setFeeling(String feeling) {
        this.feeling = feeling;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public InputModel(String age, String department, String feeling, String gender) {

        this.age = age;
        this.department = department;
        this.feeling = feeling;
        this.gender = gender;
    }
}
