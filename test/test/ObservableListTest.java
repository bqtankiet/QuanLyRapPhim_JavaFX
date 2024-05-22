package test;

import java.util.Iterator;

import database.RapList;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Rap;
import models.tableViewItem.RapItem;

public class ObservableListTest {

	public static void main(String[] args) {
		ObservableList<RapItem> dataRap = FXCollections.observableArrayList();
		ObservableList<RapItem> prevDataRap = FXCollections.observableArrayList();
		for (Rap rap : RapList.getAll()) {
			dataRap.add(rap.createRapItem());
		}
		for (RapItem item : dataRap) {
			prevDataRap.add(new RapItem(item.getRap()));
		}
		
		//Print
//		prevDataRap.get(0).setTenRap(new SimpleStringProperty("adfdasf"));
		for (RapItem rapItem : prevDataRap) {
			System.out.println(rapItem);
		}
		System.out.println("-----");
		for (RapItem rapItem : dataRap) {
			System.out.println(rapItem);
		}
		System.out.println(prevDataRap.equals(dataRap));
	}
}
