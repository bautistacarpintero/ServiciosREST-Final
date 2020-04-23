package carpinteroseverino.model;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Cow {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int electronicId;
    private Date birthdate;
    private Date lastDateOfBirth;
    private int birthCount;
    private double weight;

    @ManyToOne
    private Herd herd;


    public Cow() {
    }

    public Cow(int electronicId, Date birthdate, Date lastDateOfBirth, int birthCount, double weight) {
        this.electronicId = electronicId;
        this.birthdate = birthdate;
        this.lastDateOfBirth = lastDateOfBirth;
        this.birthCount = birthCount;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getElectronicId() {
        return electronicId;
    }

    public void setElectronicId(int electronicId) {
        this.electronicId = electronicId;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Date getLastDateOfBirth() {
        return lastDateOfBirth;
    }

    public void setLastDateOfBirth(Date lastDateOfBirth) {
        this.lastDateOfBirth = lastDateOfBirth;
    }

    public int getBirthCount() {
        return birthCount;
    }

    public void setBirthCount(int birthCount) {
        this.birthCount = birthCount;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Herd getHerd() {
        return herd;
    }

    public void setHerd(Herd herd) {
        this.herd = herd;
    }
}
