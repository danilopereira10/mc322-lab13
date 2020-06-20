package printer;

import com.mc322.jewel_collector.items.Item;

public class Printer {
	private Printer() {}
	
	private static Printer instance;
	
	public static Printer getInstance() {
		if (instance == null) {
			return new Printer();
		}
		return instance;
	}
	
	public void print(String message) {
		System.out.println(message);
	}
	
	public void printBagInfo(int amountOfJewels, int totalScore) {
		print("Quantidade de joias: " + amountOfJewels);
		print("Pontuação total: " + totalScore);
	}
	
	public void printMap(Item[][] matrix) {
		for (String[] line : matrix) {
			print(java.util.Arrays.toString(line));
		}
	}
}
