package com.project.digitallibrary.dto;

import lombok.Data;

import java.util.HashMap;


public class AssetInfo {
    private boolean inUse;

    public AssetInfo() {
    }

    public AssetInfo(boolean inUse) {
        this.inUse = inUse;
    }

    public boolean isInUse() {
        return inUse;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }

    @Override
    public String toString() {
        return "AssetInfo{" +
                "inUse=" + inUse +
                '}';
    }
}
