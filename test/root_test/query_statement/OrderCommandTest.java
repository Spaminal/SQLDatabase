/* Jacob Culley
 * CS 210 
 * Instructor Morehead
 */
package root_test.query_statement;

import org.junit.Before;

import root.query_statement.OrderCommand;
import root_test.AbstractCommandTest;

public class OrderCommandTest extends AbstractCommandTest {

	@Override
	@Before
	public void setUp() throws Exception {
		command = new OrderCommand();
		good = new String[] { 
				"order emp by sal;",
				"order emp by sal descending;",
				"order  emp by sal;",
				"order emp  by sal;",
				"order emp by  sal;",
				"order emp by sal ;",
				"order  emp  by  sal     ;",

		};
		bad = new String[] {
				"order emp by sal",
				"order emp by sal descending",
				"orderemp by sal;",
				"order empby sal;",
				"order emp bysal;",
				"order emp by sal();",
				"order emp by sal descendi;",
		};
	}
}
