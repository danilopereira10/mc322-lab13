package printer;

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
		print("Pontua��o total: " + totalScore);
	}
	
	public void printMap(String[][] matrix) {
		for (String[] line : matrix) {
			print(java.util.Arrays.toString(line));
		}
	}
}
