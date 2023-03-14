package banking;

/**
 * Abstract Account Holder.
 */
public abstract class AccountHolder {
    private int idNumber;
    
    /**
     * @param idNumber The holder unique ID.
     */
    protected AccountHolder(int idNumber) {
        // TODO: complete the constructor
        this.idNumber = idNumber;
    }

    public int getIdNumber() {
        // TODO: complete the method
        return this.idNumber;
    }
}
