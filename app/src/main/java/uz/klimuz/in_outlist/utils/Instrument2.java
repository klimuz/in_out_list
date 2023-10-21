package uz.klimuz.in_outlist.utils;

public class Instrument2 {
    private String name ;
    private int quantity = 0;
    private String pickup = "mic";
    private boolean isStereo = false;

    public Instrument2(String name, int quantity, String pickup, boolean isStereo) {
        this.name = name;
        this.quantity = quantity;
        this.pickup = pickup;
        this.isStereo = isStereo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPickup() {
        return pickup;
    }

    public void setPickup(String pickup) {
        this.pickup = pickup;
    }

    public boolean isStereo() {
        return isStereo;
    }

    public void setStereo(boolean stereo) {
        isStereo = stereo;
    }
}
