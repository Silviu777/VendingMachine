package com.vm.implem;

import com.vm.components.BankStorage;
import com.vm.components.Cash;
import com.vm.components.Item;
import com.vm.components.VendingStorage;
import com.vm.exceptions.NotFullPaidException;
import com.vm.exceptions.NotSufficientChangeException;
import com.vm.exceptions.SoldOutException;
import com.vm.interf.IVendingMachine;

import java.util.Scanner;

public class VendingMachineImpl implements IVendingMachine {

    private Item currentItem;
    private VendingStorage itemInventory = new VendingStorage();
    private BankStorage bankStorage = new BankStorage();

    public VendingMachineImpl(VendingStorage itemInventory, BankStorage bankStorage) {
        this.itemInventory = itemInventory;
        this.bankStorage = bankStorage;
    }

    // private void setCash() {}
    // private void setItems() {}

    @Override
    public boolean validateAmount(double amount) throws NotFullPaidException {
        if (amount < currentItem.getPrice()) {
            return false;
        }
        return true;
    }

    @Override
    public double itemPrice(Item item) {
        if (itemInventory.getInventory().containsValue(item.id)) {
            currentItem = item;
            return currentItem.getPrice();
        }
        throw new SoldOutException("The item you selected is sold out!");
    }

    @Override
    public double returnChange(double change) throws NotSufficientChangeException {
        while (true) {
            for (var value : bankStorage.getCashMap().entrySet()) {
                if (value.getKey().getValue() < change) {
                    change -= value.getKey().getValue();
                }
            }
            if (change == 0) System.out.println("The change is null");
        else
            if (change < 0)
                break;
       }
        return change;
    }

    @Override
    public double addAmount(Cash cash) {
        if (bankStorage.getCashMap().containsKey(cash)) {
            int sum = bankStorage.getCashMap().get(cash);
            bankStorage.getCashMap().put(cash, ++sum);
        }
        return cash.getValue();
    }

    @Override
    public void deliverItem() throws NotSufficientChangeException {
        Item item = null;
        double itemPrice = 0, totalAmount = 0;

        Scanner scan = new Scanner(System.in);
        double sum = scan.nextDouble();

        Cash amount = new Cash(sum);
        totalAmount += addAmount(amount);

        System.out.println("Enter the item id and enter the amount >> ");
        int id = scan.nextInt();

        for (var product : itemInventory.getInventory().keySet()) {
            if (id == product.getId())
                item = product;
            // System.out.println("Produs selectat!");
            else
                System.out.println("The product you requested does not exist!");
        }
        try {
            if (validateAmount(itemPrice))
                System.out.println("You selected: " + item.getName() + " for the price of " + item.getPrice());

        } catch (NotFullPaidException e) {
            e.printStackTrace();
        }

        double rest = totalAmount - itemPrice;
        if (totalAmount != 0 && rest != 0)
            System.out.println("Wait for your change...");
        else
            if (returnChange(rest) > 0)
                throw new NotSufficientChangeException();
    }

    @Override
    public void printData() {
        System.out.println("Item inventory: " + itemInventory);
        System.out.println("\nFinancial situation : " + bankStorage);
    }
}
