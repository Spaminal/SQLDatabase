/* Jacob Culley
 * CS 210 
 * Instructor Morehead
 */
package root_test.query_statement;

import org.junit.Before;

import root.query_statement.ProjectionCommand;
import root_test.AbstractCommandTest;

public class ProjectionCommandTest extends AbstractCommandTest {

	@Override
	@Before
	public void setUp() throws Exception {
		command = new ProjectionCommand();
		good = new String[] {
				"project emp over a, b, c;",
				"project emp over alpha, beta, carrot;",
				"project emp over  alpha,  beta,  carrot;",
				"project emp over alpha,beta,carrot;",
				"project emp over alpha;",
				
	
		};
		bad = new String[] { 
				"project emp over alpha beta, carrot;",
				"project emp over alpha, , carrot;",
				"project emp over alpha, ",
				"project emp over , carrot;",
				"projt emp over alpha, beta, carrot;",
				"project emp ovr alpha, beta, carrot;",
				"project emp ove, beta, carrot;",
		};
	}
}
