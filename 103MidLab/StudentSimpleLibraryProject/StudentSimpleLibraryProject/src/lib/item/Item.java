package lib.item;

import java.util.Objects;

public abstract class Item {
    private String barcode;
    private String title;
    private ItemStatus itemStatus;

    public Item(String barcode, String title) {
        this.barcode = barcode;
        this.title = title;
        this.itemStatus = itemStatus.AVAILABLE;
    }

    public ItemStatus getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(ItemStatus itemStatus) {
        this.itemStatus = itemStatus;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (!Objects.equals(this.barcode, other.barcode)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Item{" + "barcode=" + barcode + ", title=" + title + ", itemStatus=" + itemStatus + '}';
    }

}
