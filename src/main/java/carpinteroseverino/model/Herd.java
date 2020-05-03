package carpinteroseverino.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Herd {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany(mappedBy="herd")
    private List<Cow> cows;

    private String location;

    public Herd() {
        this.cows = new ArrayList<>();
    }

    public Herd(String location) {
        this.cows = new ArrayList<>();
        this.location = location;
    }

    public boolean addCow(Cow cow){
        return this.cows.add(cow);
    }

    public boolean removeCow(Cow cow){
        return this.cows.remove(cow);
    }

    public void deleteAllCow(Cow cow){
        this.cows = new ArrayList<>();
    }

    public List<Cow> getCows() {
        return cows;
    }

    public void setCows(List<Cow> cows) {
        this.cows = cows;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Herd{" +
                "id=" + id +
                ", cows=" + cows +
                ", location='" + location + '\'' +
                '}';
    }
}
