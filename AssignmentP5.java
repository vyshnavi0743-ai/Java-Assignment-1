interface Issuable {
    void issueItem();
    void returnItem();
}
abstract class LibraryItem {
    protected String title;
    protected String itemId;
    protected boolean isIssued;
    public LibraryItem(String title, String itemId) {
        this.title = title;
        this.itemId = itemId;
        this.isIssued = false;
    }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getItemId() { return itemId; }
    public void setItemId(String itemId) { this.itemId = itemId; }
    public boolean isIssued() { return isIssued; }
    public void setIssued(boolean issued) { isIssued = issued; }
    public abstract int calculateFine(int daysLate);
    public void displayInfo() {
        System.out.println("Title: " + title + ", ID: " + itemId + ", Status: " + (isIssued ? "Issued" : "Available"));
    }
}
class Book extends LibraryItem implements Issuable {  
    public Book(String title, String itemId) {
        super(title, itemId);
    }
    @Override
    public int calculateFine(int daysLate) {
        return daysLate*5;
    }
    @Override
    public void issueItem() {
        this.isIssued = true;
    }
    @Override
    public void returnItem() {
        this.isIssued = false;
    }
    @Override
    public String toString() {
        return title + " (Book)";
    }
}
class Magazine extends LibraryItem implements Issuable {
    public Magazine(String title, String itemId) {
        super(title, itemId);
    }
    @Override
    public int calculateFine(int daysLate) {
        return daysLate * 2; 
    }
    @Override
    public void issueItem() {
        this.isIssued = true;
    }
    @Override
    public void returnItem() {
        this.isIssued = false;
    }
    @Override
    public String toString() {
        return title + " (Magazine)";
    }
}
public class AssignmentP5 {
    public static void main(String[] args) {
        LibraryItem[] libraryInventory = new LibraryItem[4];
        libraryInventory[0] = new Book("Java Programming", "B01");
        libraryInventory[1] = new Magazine("National Geographic", "M01");
        libraryInventory[2] = new Book("Clean Code", "B02");
        libraryInventory[3] = new TimeMagazine("Time Magazine", "M02"); 
        for (LibraryItem item : libraryInventory) {
            if (item instanceof Issuable) {
                ((Issuable) item).issueItem();
            }
        }
        int[] simulatedDaysLate = {4, 4, 2, 2};
        System.out.println("Expected Output:\n");
        for (int i = 0; i < libraryInventory.length; i++) {
            LibraryItem item = libraryInventory[i];
            int daysLate = simulatedDaysLate[i];
            int fine = item.calculateFine(daysLate); 

            System.out.printf("Item: %s | Fine for %d days late: Rs.%d\n", 
                    item.toString(), daysLate, fine);
        }
    }
}
class TimeMagazine extends Magazine {
    public TimeMagazine(String title, String itemId) {
        super(title, itemId);
    }
}