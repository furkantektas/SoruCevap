package tr.edu.gtu.bilmuh.sorucevap;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Furkan Tektas on 2/13/16.
 */
public class Soru {

    @SerializedName("soru")
    private String metin;

    private String dogruCevap;
    private String yanlisCevap;

    public Soru(String metin, String dogruCevap, String yanlisCevap) {
        this.metin = metin;
        this.dogruCevap = dogruCevap;
        this.yanlisCevap = yanlisCevap;
    }

    public String getMetin() {
        return metin;
    }

    public void setMetin(String metin) {
        this.metin = metin;
    }

    public String getDogruCevap() {
        return dogruCevap;
    }

    public void setDogruCevap(String dogruCevap) {
        this.dogruCevap = dogruCevap;
    }

    public String getYanlisCevap() {
        return yanlisCevap;
    }

    public void setYanlisCevap(String yanlisCevap) {
        this.yanlisCevap = yanlisCevap;
    }
}
