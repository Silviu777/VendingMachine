package com.vm.components;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankStorage {

    private HashMap<Cash, Integer> cashMap = new HashMap<>();

    public BankStorage(HashMap<Cash, Integer> cashMap) {
        this.cashMap = cashMap;
    }

    public BankStorage() { }

    public HashMap<Cash, Integer> getCashMap() {
        return cashMap;
    }
}
