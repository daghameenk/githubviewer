package alu.com;

public class SelectedCustomerManager {

    private static SelectedCustomerManager instance;
    private int selectedCustomerId;
    private String selectedCustomerFullName;

    private SelectedCustomerManager() {
        // Private constructor to prevent direct instantiation
    }

    public static synchronized SelectedCustomerManager getInstance() {
        if (instance == null) {
            instance = new SelectedCustomerManager();
        }
        return instance;
    }

    public void setCustomerData(int id, String fullName) {
        this.selectedCustomerId = id;
        this.selectedCustomerFullName = fullName;
    }

    public int getSelectedCustomerId() {
        return selectedCustomerId;
    }

    public String getSelectedCustomerFullName() {
        return selectedCustomerFullName;
    }

    public void clearCustomerData() {
        this.selectedCustomerId = -1;
        this.selectedCustomerFullName = null;
    }
}