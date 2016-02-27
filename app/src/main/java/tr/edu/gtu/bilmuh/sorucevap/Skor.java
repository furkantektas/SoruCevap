package tr.edu.gtu.bilmuh.sorucevap;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.Date;

/**
 * Created by sunum on 2/27/16.
 */
@Table(name="skorlar")
public class Skor extends Model {
    @Column(name = "skor")
    private int skor;
    @Column(name = "time")
    private Date time;

    public Skor(int skor) {
        this.skor = skor;
        this.time = new Date();
    }

    public Skor(int skor, Date time) {
        this.skor = skor;
        this.time = time;
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
