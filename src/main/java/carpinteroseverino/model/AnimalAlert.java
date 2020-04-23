package carpinteroseverino.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AnimalAlert {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int animalId;
    private int bcsThreshold;


    public AnimalAlert() {
    }

    public AnimalAlert(int animalId, int bcsThreshold) {
        this.animalId = animalId;
        this.bcsThreshold = bcsThreshold;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public int getBcsThreshold() {
        return bcsThreshold;
    }

    public void setBcsThreshold(int bcsThreshold) {
        this.bcsThreshold = bcsThreshold;
    }
}
