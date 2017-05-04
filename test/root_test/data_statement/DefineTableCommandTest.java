/* Jacob Culley
 * CS 210 
 * Instructor Morehead
 */
package root_test.data_statement;

import org.junit.Before;

import root.data_statement.DefineTableCommand;
import root_test.AbstractCommandTest;

public class DefineTableCommandTest extends AbstractCommandTest {

	@Override
	@Before
	public void setUp() throws Exception {
		command = new DefineTableCommand();
		good = new String[] {
				"define table emp having fields(name varchar, age integer, state char(2));",
				"define table emp2 having fields(name varchar, age integer);",
				"define table emp3 having fields (name varchar, age integer, state char(2));",
				"define table emp4 having fields (name varchar, age integer, state char(2) ) ;",
				" define table emp5 having fields(name varchar, age integer, state char(2));",
				" define  table  emp6  having fields(name varchar, age integer, state char(2));",
				"define     table   emp7 having  fields  (name varchar, age integer, state char(2));",
				"define table emp8 having fields(name  varchar, age integer, state char(2));",
				"define table emp9 having fields(state char(2), state char(9));",
				"define table emp10 having fields(state char(2));",
				"define table emp11 having fields(state char (2));",
				"define table emp12 having fields(state char(2) );",
				"define table emp13 having fields(state char (2) );",
				"define table emp14 having fields(state char(2)     , age integer  );",
				"define table emp15 having fields(state char ( 225 ) );",
				"define table emp16 having fields(state integer);",
				"define table emp17 having fields(state date);",
				"define table emp18 having fields(state real);",
				"define table emp19 having fields(state varchar);",
				"define table emp10 having fields(state   boolean  );",
				
				
		};
		bad = new String[] {
				"define table emp having fields(state char(2), );",
				"define table emp having fields(name varchar..);",
				"define table emp having fields( );",
				"define table emp having fields);",
				"define table emp having fields(naar..);",
				"define table emp having fields(name varchar..",
				"define tableng fields(name varchar..);",
				"define table emp having fields(name varchar..;",
				"define table emp having fieldsname varchar);",
				"define  emp having fields(name varchar)",
				"define table emp having fields(name varchar chin char(3));",
				"define table emp having fields(name varchar,, age integer);",
				"define table emp having fields(name varchar, age char(9 9));",
				"define table emp having fields(name varchar, age char());",
				"define table emp having fields(name varchar, age 'integer');",
				"define table emp having fields(state char(z));",
				"define table emp having fields(state chart(2));",
				"define table emp having fields(state chsar(2));",
				"define table emp having fields(state bloolean);",
		};
	}
}
