/* Jacob Culley
 * CS 210 
 * Instructor Morehead
 */
package root_test.data_statement;

import org.junit.Before;

import root.data_statement.DefineIndexCommand;
import root_test.AbstractCommandTest;

public class DefineIndexCommandTest extends AbstractCommandTest {

	@Override
	@Before
	public void setUp() throws Exception {
		command = new DefineIndexCommand();
		good = new String[] {
				"define index on emp (sal);",
				"define index on emp(sal);",
				"define index  on  emp (sal)  ;",
				"define  index on emp (sal);",
				"define   index  on emp   (sal) ;",
				"define index on emp ( sal ) ;",
				"define index on emp( sal) ;",
				"define  index  on emp ( sal )       ;",
				"define index on emp99 ( sal ) ;",
				
		};
		bad = new String[] { 
				"define index on emp sal);",
				"defineindex on emp (sal):",
				"define index on emp;",
				"define index on emp (sal",
				"defiindex on em (sal);",
				"defineindexonemp(sal)));",
				"define index on emp (()sal);",
				"define index on emp* (sal');",
				"defi   !e index on emp (sal');",
				"define index on emp (sal');",
				"define index on emp (sal'",
				"define index on ');",
				"define index on emp (''sal');",
				"defi ne inde x on emp ( sa l'  ",
				"defi ne inde  x on emp (sal');",
				
		};
	}
}
