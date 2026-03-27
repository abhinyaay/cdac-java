package com.abhinyaay;

@FunctionalInterface
public interface Searcher {
    public void ascending();
    public static  void descending() {
    	System.out.println("interface static");
    }
}