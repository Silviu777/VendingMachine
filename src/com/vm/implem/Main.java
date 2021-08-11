package com.vm.implem;

import com.vm.components.BankStorage;
import com.vm.components.Cash;
import com.vm.components.Item;
import com.vm.components.VendingStorage;
import com.vm.exceptions.NotSufficientChangeException;

public class Main {
    public static void main(String[] args) throws NotSufficientChangeException {

        BankStorage bankStorage = new BankStorage();
        bankStorage.getCashMap().put(new Cash("CINCIZECI_BANI", 50), 20);
        bankStorage.getCashMap().put(new Cash("UN_LEU", 1), 10);
        bankStorage.getCashMap().put(new Cash("CINCI_LEI", 5), 5);
        bankStorage.getCashMap().put(new Cash("ZECE_LEI", 10), 15);

        VendingStorage itemInventory = new VendingStorage();
        itemInventory.getInventory().put(new Item(1, "Gatorade", 7.5), 6);
        itemInventory.getInventory().put(new Item(2, "Nutramino Protein Bar", 9.5), 3);
        itemInventory.getInventory().put(new Item(3, "Sprite", 3), 5);
        itemInventory.getInventory().put(new Item(4, "Snickers", 4.5), 7);
        itemInventory.getInventory().put(new Item(5, "Pop-Cola", 6), 3);

        System.out.println("Welcome to the Vending Machine! Explore the items and make your choice >>>");

        VendingMachineImpl test = new VendingMachineImpl(itemInventory, bankStorage);
        test.deliverItem();
    }
}
