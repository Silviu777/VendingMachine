package com.vm.interf;
import com.vm.components.Cash;
import com.vm.components.Item;
import com.vm.exceptions.NotFullPaidException;
import com.vm.exceptions.SoldOutException;
import com.vm.exceptions.NotSufficientChangeException;

public interface IVendingMachine {

    public boolean validateAmount(double amount) throws NotFullPaidException;
    public double itemPrice(Item item) throws SoldOutException;
    public double returnChange(double change) throws NotSufficientChangeException;
    public double addAmount(Cash cash);
    public void deliverItem() throws NotSufficientChangeException;
    public void printData();
}
