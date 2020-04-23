package carpinteroseverino.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class CowBCS {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int cowId;
    private Date date;
    private int bcs;


    public CowBCS() {

    }

    public CowBCS(int cowId, Date date, int bcs) {
        this.cowId = cowId;
        this.date = date;
        this.bcs = bcs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCowId() {
        return cowId;
    }

    public void setCowId(int cowId) {
        this.cowId = cowId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getBcs() {
        return bcs;
    }

    public void setBcs(int bcs) {
        this.bcs = bcs;
    }
}
