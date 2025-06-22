import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


class Main {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        // open the file passed via command line args.
		File inputFile = new File(args[0]);
		boolean skipHeader = true;
        boolean rootNode = true;
		
        // updated with implementation for SortedTreeSet
		SortedTreeSet hrBinaryTree = new SortedTreeSet();

		String path = new File("").getAbsolutePath();


		try {
			// open a scanner to read the file. try-catch for ioexceptions.
			Scanner scnr = new Scanner(inputFile);

			// loop over scanner nextlines (skipping the first for column headers)
			// extracting name, height, wegiht.
			// add the person data to the list of people.
			while (scnr.hasNextLine()) {

				if (skipHeader) {
                    skipHeader = false;
					scnr.nextLine();
                    continue;
                }

				String name = scnr.next();
				double height = scnr.nextDouble();
				double weight = scnr.nextDouble();
				
				// Person tmpPerson = new Person(name, height, weight);
				Person nodeData = new Person(name, height, weight);
				// listOfPeople.add(tmpPerson);
                if (rootNode) {
                    hrBinaryTree = new SortedTreeSet(nodeData);
                    rootNode = false;
                } else {
                    hrBinaryTree.add(nodeData);
                }
				
			}

			scnr.close();

		} catch (IOException e) {
			System.out.print("File not found.");
			e.printStackTrace();
		}

		System.out.print(hrBinaryTree + "\n");

		try {
			FileWriter fWriter2 = new FileWriter(path + "\\hr_ordered_set_output.txt");
			fWriter2.write(hrBinaryTree.toString());
			fWriter2.close();
            System.out.print("\nHR data was successfully written to:\n" + path + "\\hr_ordered_set_output.txt\n");

		} catch (IOException e) {
			System.out.print(e.getMessage());
		}
	}
}
