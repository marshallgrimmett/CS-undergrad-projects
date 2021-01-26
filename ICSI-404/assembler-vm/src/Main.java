import java.io.*;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author marshallgrimmett
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		Scanner sc = null;
		
		try {
			sc = new Scanner(new File(args[0]));
		}
		catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
		
		Operation[] ops = loadInstructions();
		String[] registers = {"r1", "r2", "r3"};
//		String[] mode = {"opcode", "register", "immediate", "destination", "address"};
		
		while (sc.hasNextLine()) {
            Scanner line = new Scanner(sc.nextLine());
	        while (line.hasNext()) {
	            String word = line.next();
	            System.out.println(word);
	            for (int i = 0; i < 16; i++) {
	            	if (word == ops[i].operation) {
	            		
	            	}
	            }
	        }
	        line.close();
	    }

	}
	
	public static void handleWord(String word) {
		
	}
	
	public static Operation[] loadInstructions() {
		Operation ops[] = new Operation[16];
		ops[0] = new Add();
		return ops;
	}
	
	
	
	// Ex. assemble file1.s
	// Ex. if add is read, then the dictionary changes to acceptable arguments for that operation.
	// Once all arguments are accepted, the line must terminate with '\n' (spaces and tabs accepted)
	// If a ';' is found ignore the line
	
	// Check syntax
	// All operations stored in a list/array
	// Check that the op is in the list and store the opcode.
	// get the next words and check that

}
