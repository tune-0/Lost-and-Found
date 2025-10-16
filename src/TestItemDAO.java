import java.sql.Date;
import java.util.List;

public class TestItemDAO {
    public static void main(String[] args) {
        ItemDAO dao = new ItemDAO();

        System.out.println("=== Testing Lost and Found Item Management System ===\n");

        // 1. Add new items
        System.out.println("1. Adding new items...");
        Item item1 = new Item("Blue Backpack", Date.valueOf("2024-10-10"), "Found");
        Item item2 = new Item("iPhone 13", Date.valueOf("2024-10-12"), "Lost");
        Item item3 = new Item("Black Wallet", Date.valueOf("2024-10-14"), "Found");

        dao.addItem(item1);
        dao.addItem(item2);
        dao.addItem(item3);
        System.out.println("Items added successfully!\n");

        // 2. Get all items
        System.out.println("2. Retrieving all items...");
        List<Item> allItems = dao.getAllItems();
        for (Item item : allItems) {
            System.out.println(item);
        }
        System.out.println();

        // 3. Search items by name
        System.out.println("3. Searching for 'phone'...");
        List<Item> searchResults = dao.searchItemsByName("phone");
        for (Item item : searchResults) {
            System.out.println(item);
        }
        System.out.println();

        // 4. Get items by status
        System.out.println("4. Getting all 'Found' items...");
        List<Item> foundItems = dao.getItemsByStatus("Found");
        for (Item item : foundItems) {
            System.out.println(item);
        }
        System.out.println();

        // 5. Update an item
        if (!allItems.isEmpty()) {
            System.out.println("5. Updating first item status to 'Lost'...");
            Item itemToUpdate = allItems.get(0);
            itemToUpdate.setStatus("Lost");
            boolean updated = dao.updateItem(itemToUpdate);
            System.out.println("Update successful: " + updated);
            System.out.println("Updated item: " + dao.getItemById(itemToUpdate.getItemId()));
            System.out.println();
        }

        // 6. Get total count
        System.out.println("6. Total items in database: " + dao.getTotalItemCount());
        System.out.println();

        // 7. Delete an item (optional - uncomment to test)
        /*
        if (!allItems.isEmpty()) {
            System.out.println("7. Deleting last item...");
            Item itemToDelete = allItems.get(allItems.size() - 1);
            boolean deleted = dao.deleteItem(itemToDelete.getItemId());
            System.out.println("Delete successful: " + deleted);
            System.out.println("Remaining items: " + dao.getTotalItemCount());
        }
        */

        System.out.println("\n=== Test Complete ===");
    }
}