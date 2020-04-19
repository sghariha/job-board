package com.shariharan.jobboard.model;

import java.util.HashSet;

public class IDContainer {
    private HashSet<String> idSet;

    public IDContainer() {
        this.idSet = new HashSet<>();
    }

    public IDContainer(HashSet<String> idList) {
        this.idSet = new HashSet<>();
        for (String id : this.idSet) {
            idSet.add(id);
        }
    }

    public HashSet<String> getIdSet() {
        return this.idSet;
    }

    public void setIdSet(HashSet<String> IdSet) {
        this.idSet = new HashSet<>();
        for (String id : this.idSet) {
            idSet.add(id);
        }
    }

    public void addId(String id) {
        this.idSet.add(id);
    }

    public void deleteId(String id) {
        this.idSet.remove(id);
    }
}