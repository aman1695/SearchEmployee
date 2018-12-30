package problemCSV;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;

public class ReadCSV {
	
	private final static String PROMPT = "search> ";
	private final static String QUIT = "quit";

	public static void main(String[] args) {
		DataStore dataStore = loadData();
		promptAndSearch(dataStore);
	}

	private static void promptAndSearch(DataStore dataStore) {
		System.out.println("Please Enter Search terms. Enter QUIT/quit to quit.");
		System.out.print(PROMPT);
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			while (true) {
				if(scanner.hasNextLine()) {
					String input = scanner.nextLine();
					if(QUIT.equalsIgnoreCase(input)) {
						System.out.println("quiting...");
						break;
					}
					printSearchResult(dataStore.search(input));
				}
				System.out.print(PROMPT);
			}
		} finally {
			if (scanner != null) scanner.close();
		}
	}

	private static DataStore loadData() {
		String fileName = "employees.csv";
		File file = new File(fileName);
		DataStore dataStore = DataStore.getDataStore();
		Scanner inputStream = null;
		try {
			inputStream = new Scanner(file);
			while(inputStream.hasNext()) {
				String data = inputStream.nextLine();
				Employee e = Employee.newEmployee(data);
				dataStore.insertEmployee(e);
			}
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} finally {
			if (inputStream != null) inputStream.close();
		}
		return dataStore;
	}
	
	private static void printSearchResult(Set<Employee> employees) {
		for (Employee employee : employees) {
			System.out.println(employee);
		}
		System.out.println();
	}

}
