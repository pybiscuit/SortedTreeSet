import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
       // open the file passed via command line args.
		File inputFile = new File(args[0]);
		char skipFirstRow = 'Y';
        char firstPerson = 'Y';
		
		// PersonImperialSet listOfPeople = new PersonImperialSet();
		SortedTreeSet alphaList = new SortedTreeSet();

		String path = new File("").getAbsolutePath();

		// test person - not used in final version, requested in pt. 1
		// Person newPerson = new Person("Marcus", 72, 111);

		try {
			// open a scanner to read the file. try-catch for ioexceptions.
			Scanner scnr = new Scanner(inputFile);

			// loop over scanner nextlines (skipping the first for column headers)
			// extracting name, height, wegiht.
			// add the person data to the list of people.
			while (scnr.hasNextLine()) {

				if (skipFirstRow == 'Y') {
                    skipFirstRow = 'N';
					scnr.nextLine();
                    continue;
                }

				String name = scnr.next();
				double height = scnr.nextDouble();
				double weight = scnr.nextDouble();
				
				// Person tmpPerson = new Person(name, height, weight);
				Person tmpPerson1 = new Person(name, height, weight);
				// listOfPeople.add(tmpPerson);
                if (firstPerson == 'Y') {
                    alphaList = new SortedTreeSet(tmpPerson1);
                    firstPerson = 'N';
                } else {
                    alphaList.add(tmpPerson1);
                }
				
			}

			scnr.close();

		} catch (IOException e) {
			System.out.print("File not found.");
			e.printStackTrace();
		}
		// alphaList.sort();
		System.out.print(alphaList + "\n");
		// System.out.print(listOfPeople);		

		// try {
		// 	FileWriter fWriter = new FileWriter(path + "\\hr_imperial_set_output.txt");
		// 	fWriter.write(listOfPeople.toString());
		// 	fWriter.close();

		// 	FileWriter fWriter2 = new FileWriter(path + "\\hr_ordered_set_output.txt");
		// 	fWriter2.write(alphaList.toString());
		// 	fWriter2.close();

		// } catch (IOException e) {
		// 	System.out.print(e.getMessage());
		// }
	}
}
