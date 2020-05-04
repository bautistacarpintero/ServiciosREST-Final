package carpinteroseverino.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Herd {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany(mappedBy = "herd")

    @JsonManagedReference
    private List<Cow> cows;

    private String location;

    public Herd() {
        this.cows = new ArrayList<>();
    }

    public Herd(String location) {
        this.cows = new ArrayList<>();
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public boolean addCow(Cow cow) {
        return this.cows.add(cow);
    }

    public boolean removeCow(Cow cow) {
        return this.cows.remove(cow);
    }

    public void deleteAllCow(Cow cow) {
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

    @JsonProperty
    public Double getAvgBCS() {
        if (cows.size() == 0)
            return null;
        else {
            double sum = 0.0;
            int count = 0;
            for (Cow cow : cows) {
                Integer bcs = cow.getLastBCS();
                if (bcs != null) {
                    sum += bcs;
                    count++;
                }
            }
            return count == 0 ? null : sum / count;
        }
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
