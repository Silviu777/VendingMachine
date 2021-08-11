package com.vm.components;
import com.vm.components.Item;
import com.vm.exceptions.SoldOutException;
import java.util.HashMap;

public class VendingStorage {

    private HashMap<Item, Integer> inventory = new HashMap<>();

    public HashMap<Item, Integer> getInventory() {
        return inventory;
    }

    public void insertItem(Item item) {
        int count = inventory.get(item);
        inventory.put(item, count + 1);
    }

}
