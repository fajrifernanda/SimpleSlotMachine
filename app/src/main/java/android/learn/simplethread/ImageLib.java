package android.learn.simplethread;

import java.util.ArrayList;

/**
 * Created by Fajri on 12/11/2017.
 */

public class ImageLib {
    int kode;
    int fileLoc;

    public ImageLib(int kode, int fileLoc){
        this.kode = kode;
        this.fileLoc = fileLoc;
    }

    public int getKode() {
        return kode;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }

    public int getFileLoc() {
        return fileLoc;
    }

    public void setFileLoc(int fileLoc) {
        this.fileLoc = fileLoc;
    }
}
