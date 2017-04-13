package models;
public class User {
    public Integer lifes;
    public String name;

    public User(String name) {
        this.lifes = 10;
        this.name = name;
    }
    public Integer getLifes() {
        return this.lifes;
    }
    public String getName() {
        return this.name;
    }
    public void setName() {
        this.name = name;
    }
    public void setLifes(Integer x) {
        this.lifes = x;
    }
}
