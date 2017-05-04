/* Jacob Culley
 * CS 210 
 */

/**
 * Dr Morehead, this is what I was able to get done before the midnight deadline.
 * I still need to get my abstract value class to work properly before I can 
 * fully test my Binary Writer class.  It's been a great class, and I can honestly 
 * say that I've learned more programming this semester than I ever have before and 
 * I still plan to finish all 9 modules.
 */
package root;

import java.io.IOException;
import java.util.Scanner;

import org.xml.sax.SAXException;

import root.ICommand;
import root.admin_statement.BackupCommand;
import root.admin_statement.ExitCommand;
import root.admin_statement.PrintCommand;
import root.admin_statement.ReadCommand;
import root.admin_statement.RestoreCommand;
import root.data_statement.DefineIndexCommand;
import root.data_statement.DefineTableCommand;
import root.data_statement.DeleteCommand;
import root.data_statement.DropCommand;
import root.data_statement.InsertCommand;
import root.data_statement.RenameCommand;
import root.data_statement.UpdateCommand;
import root.data_statement.xml.Reader;
import root.query_statement.IntersectionCommand;
import root.query_statement.JoinCommand;
import root.query_statement.MinusCommand;
import root.query_statement.OrderCommand;
import root.query_statement.ProjectionCommand;
import root.query_statement.SelectCommand;
import root.query_statement.UnionCommand;

/**
 * Distributes input command into matching command.
 */
public class Driver {

	private ICommand[] commands = new ICommand[] { new BackupCommand(),
			new DefineIndexCommand(), new DefineTableCommand(),
			new DeleteCommand(), new DropCommand(), new ExitCommand(),
			new InsertCommand(), new IntersectionCommand(), new JoinCommand(),
			new MinusCommand(), new OrderCommand(), new PrintCommand(),
			new ProjectionCommand(), new ReadCommand(), new RenameCommand(),
			new RestoreCommand(), new SelectCommand(), new UnionCommand(),
			new UpdateCommand() };

	private int exitCondition = 0;

	/**
	 * Takes in input command, cycles until exit command.
	 */
	public void run() {
		System.out.println("Notes: When renaming a field, you must first Drop\n"
				+ " the Table, and run the Define Table Command again.");
		System.out.println(" Program writes to external file after every input command\n");
		
		Scanner sc = new Scanner(System.in);
		while (exitCondition == 0) {
			System.out.println("Enter a command from Project Grammar");
			System.out.print("> ");
			lineIntake(sc);
		}
		sc.close();
	}

	/**
	 * Filters inLine command into corresponding script.
	 */
	public boolean commandFinder(String input) {
		for (ICommand command : commands) {
			if (command.matches(input)) {
				command.execute();
				return true;
			}
		}
		return false;
	}

	/**
	 * Captures command line input
	 */
	public void lineIntake(Scanner inLineSc) {
		String input = inLineSc.nextLine();
		while (input.lastIndexOf(';') < 0 && inLineSc.hasNextLine()) {
			String inLineStr = " " + inLineSc.nextLine();
			input = input.concat(inLineStr);
		}
		System.out.println();
		System.out.print("Entered Command: ");
		System.out.println(input);
		if (!commandFinder(input)) {
			System.out.println("This is not a correct statement");
		}
		System.out.println();
	}

	/**
	 * Start of user input. 
	 */
	public static void main(String[] args){
		try{
			new Reader().Reader();
		} catch(IOException e) {

		} catch(SAXException e){
			
		}
		
		new Driver().run();

	}
}