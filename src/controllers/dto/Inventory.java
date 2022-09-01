package controllers.dto;

public class Inventory {
    public Inventory(int inventoryId, int userFk, int itemFk) {
        this.inventoryId = inventoryId;
        this.userFk = userFk;
        this.itemFk = itemFk;
    }

    private int inventoryId;
    private int userFk;
    private int itemFk;

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public int getUserFk() {
        return userFk;
    }

    public void setUserFk(int userFk) {
        this.userFk = userFk;
    }

    public int getItemFk() {
        return itemFk;
    }

    public void setItemFk(int itemFk) {
        this.itemFk = itemFk;
    }
}
