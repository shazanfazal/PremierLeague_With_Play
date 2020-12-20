package utils;

import javafx.collections.ObservableList;

import java.util.ArrayList;

public class SortingObj {

	/**
	 * if the object implements with comparable interface only  we can compare else we cant compare 2 objects,
	 * this is a DSC based comparing
	 * @param listNeededToSort the array List that will be passed inorder to sort the list
	 * @param <T> generic comparable interface that will be passed
	 */
	public static <T extends Comparable<T>> void sortingInDescendingOrder(ArrayList<T> listNeededToSort){
		for(int iteration = 0; iteration < listNeededToSort.size() - 1;  iteration++){ 
			for(int comparison = 0; comparison < listNeededToSort.size() - (iteration + 1); comparison++){
				if(listNeededToSort.get(comparison).compareTo(listNeededToSort.get(comparison + 1)) < 0){
					T tempVSwap = listNeededToSort.get(comparison);
					listNeededToSort.set(comparison,listNeededToSort.get(comparison + 1));
					listNeededToSort.set(comparison + 1,tempVSwap);
				}
			}
		}	
	}
}
