package tr.edu.gtu.bilmuh.sorucevap;

import java.util.Date;

/**
 * Created by sunum on 2/27/16.
 */
public class Skor {
    private int skor;
    private Date time;

    public Skor(int skor) {
        this.skor = skor;
        this.time = new Date();
    }

    public Skor() {

    }

    public int getSkor() {
        return skor;
    }

    public void setSkor(int skor) {
        this.skor = skor;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
