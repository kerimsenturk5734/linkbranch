package com.kerimsenturk.linkbranch.util.IconManager;

public enum IconSize {
    _16(16),
    _32(32),
    _64(64),
    _128(128),
    _256(256),
    _512(512),
    _1024(1024);

    private final int value;
    IconSize(int value){
        this.value = value;
    }
    public int value(){
        return this.value;
    }
}
