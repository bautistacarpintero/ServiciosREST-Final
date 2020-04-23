package carpinteroseverino.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HerdAlert {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int herdId;
    private int bcsThreshold;


    public HerdAlert() {
    }

    public HerdAlert(int herdId, int bcsThreshold) {
        this.herdId = herdId;
        this.bcsThreshold = bcsThreshold;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHerdId() {
        return herdId;
    }

    public void setHerdId(int herdId) {
        this.herdId = herdId;
    }

    public int getBcsThreshold() {
        return bcsThreshold;
    }

    public void setBcsThreshold(int bcsThreshold) {
        this.bcsThreshold = bcsThreshold;
    }
}
