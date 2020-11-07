
package aa.classlar;

public class KutuphaneStok {
    
    private int stok_id;
    private int kitap_id;
    private int barcode;

    public KutuphaneStok() {
    }

    public KutuphaneStok(int stok_id, int kitap_id, int barcode) {
        this.stok_id = stok_id;
        this.kitap_id = kitap_id;
        this.barcode = barcode;
    }

    public int getStok_id() {
        return stok_id;
    }

    public void setStok_id(int stok_id) {
        this.stok_id = stok_id;
    }

    public int getKitap_id() {
        return kitap_id;
    }

    public void setKitap_id(int kitap_id) {
        this.kitap_id = kitap_id;
    }

    public int getBarcode() {
        return barcode;
    }

    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }
    
    
}
