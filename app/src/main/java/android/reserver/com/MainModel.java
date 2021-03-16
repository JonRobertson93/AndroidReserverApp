package android.reserver.com;

public class MainModel {

    private int mSeatNumber;

    // constructor
    public MainModel(int seatNumber) {
        setmSeatNumber(seatNumber);
    }

    // getters and setters
    public int getmSeatNumber() {
        return mSeatNumber;
    }

    public void setmSeatNumber(int mSeatNumber) {
        this.mSeatNumber = mSeatNumber;
    }

}
