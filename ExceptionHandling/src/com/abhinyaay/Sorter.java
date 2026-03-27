package com.abhinyaay;

public class Sorter implements Sort, Searcher {

	int data;

	public Sorter(int data) {
		this.data = data;
	}

	public void manipulate() {
		System.out.println("Manipulating the Sorter");
	}

	@Override
	public void ascending() {
		System.out.println("Ascending of Sorter");
	}

	@Override
	public void descending() {
		System.out.println("Descending sorter");
		Searcher.descending();
		Sort.super.descending();
	}

	public static void main(String[] args) {

		Sorter sort = new Sorter(33);

		sort.manipulate();
		sort.ascending();

		sort.descending();

	}
}