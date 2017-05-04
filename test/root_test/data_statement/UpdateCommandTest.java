/* Jacob Culley
 * CS 210 
 * Instructor Morehead
 */
package root_test.data_statement;

import org.junit.Before;

import root.data_statement.UpdateCommand;
import root_test.AbstractCommandTest;

public class UpdateCommandTest extends AbstractCommandTest {

	@Override
	@Before
	public void setUp() throws Exception {
		command = new UpdateCommand();
		good = new String[] {
				"update emp set sal = 200;",
				"update emp set sal = 500 ;",
				"update emp set sal = 500.001 ;",
				"update emp set sal = 500. ;",
				"update emp set sal = .500 ;",
				"update    emp     set     sal      =     200             ;",
				"update emp set dates = '07/08/1999';",
				"update emp set dates =    '07/08/1999'    ;",
				"update emp set sal = 'everybody loves kung fu fighting' ;",
				"update emp set sal = 'everybody loves kung, fu, fighting' ;",
				"update emp set sal = '87 hunched over logs with !@#' ;",
				"update emp set sal = '99 dogs';",
				"update emp set sal = '99/99/9999';",
				"update emp set sal = '99 dogs';",
				"update emp set sal = false;",
				"update emp set sal = true;",
				"update emp set sal = '99 dogs';",
				
				
				
		};
		bad = new String[] { 
				"update emp set sal = 200 here name = 80;",
				"update emp set sal = 200 where name = 'jones'",
				"update empset sal = 200 where name = 'jones';",
		};
	}
}
