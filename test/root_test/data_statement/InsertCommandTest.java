/* Jacob Culley
 * CS 210 
 * Instructor Morehead
 */
package root_test.data_statement;

import org.junit.Before;

import root.data_statement.InsertCommand;
import root_test.AbstractCommandTest;

public class InsertCommandTest extends AbstractCommandTest {

	@Override
	@Before
	public void setUp() throws Exception {
		command = new InsertCommand();
		good = new String[] {
				"insert( 1)into emp;",
				"insert (255)into emp;",
				"insert(1.1)into emp;",
				"insert (256.856)into emp;",
				"insert (.256)into emp;",
				"insert ('12/15/2012')into emp;",
				"insert ('ribbit')into emp;",
				"insert ('ribbit goes the frog')into emp;",
				"insert (true)into emp;",
				"insert (false)into emp;",
				"insert ('ribbit', 1, 33.1)into emp;",
				"insert (    1, 'hello', 33.1, '02/19/2014' ) into emp;",
				"insert (1, 'hello', 33.1, '02/19/2014', TRUE, FAlse ) into emp;",
				"insert (1, 'hello', 33.1, '02/19/2014', True, False, 'Dancing Man' ) into emp;",
				"insert (1, 'hello', 33.1, '02/19/2014' ) into emp;",
				"insert (1,2,3,4,5,6,7,8,9,10)into emp;",
				"insert (1   ,  5,  6     , 9)into emp;",
				"insert (1,'hello goodbye', 45 , 67, true)into emp;",
				"insert (127.1259, .005, 125.)into emp;",
				"insert (1, 'spring chickens', 'dead samurai', '05/25/2114')into emp;",
				"insert (1     ,     21    ,   1223,        123)into emp;",
				"insert ('hamster dance into the night')into emp;",
				"insert ('hamsters dancing, into the nightcap')into emp;",
				"insert('ribbit, 265, !@#$%^&*()', 256)into emp;",
				"insert (1000059987)into emp;",
				"insert (.999999999)into emp;",
				"insert (1651.1632165)into emp;",
				"insert (   '12/10/2000')into emp;",
				"insert ('12/10/2000'   )into emp;",
				"insert('flying ribbit, #creepy')into emp;",
				"insert ('12/10/2000')into emp;",
				"insert (  '12/10/2000'  )into emp;",
				"insert ('Spring chickens, dancing')into emp;",
				"insert (true)into emp;",
				"insert(false)into emp;",
				"insert('rubber duck's')into emp;"
				
				
					
		};
		bad = new String[] { 
				"insert (, 'hello', 33.1, '02/19/2014' ) into emp;",
				"insert (1, 'hello', 33.1, '02/19/2014' ) into emp",
				"insert (1, 'hello', 33.1, '02/19/2014 ) into emp;",
				"insert(1, 'hello', 33.z, '02/19/2014' ) into emp;",
				"insert (1, 'hello', 33.1, '02/19/2014' ) into;",
				"insert () into emp;",
				"insert (   ) into emp;",
				"inse (1, 'hello', 33.1, '02/19/2014' ) into emp;",
				"insert (1.1d)into emp;",
				"insert (1111d)into emp;",
				"insert (zzzzzzz)into emp;",
				"insert (/)into emp;",
				"insert ('ham',                )into emp;",
				"insert (1,)into emp;",
				"insert (1.2,)into emp;",
				"insert ('12/12/2121', )into emp;",
				"insert (1, )into emp;",
				"insert (hello)into emp;",
				"insert (1, hello )into emp;",
				"insert (1, 'hello )into emp;",
				"insert (1, 'hello , 'diamond mine')into emp;",
				"insert (Z, 'hello , 'diamond mine')into emp;",
				"insert (Z99, 'hello , 'diamond mine')into emp;",
				"insert (1, 'hello , 'diamond mine')into emp;",
				"insert ('07/08/20155')into emp;",
				"insert ('02/191/2222')into emp;",
				"insert ('021/19/2222')into emp;",
				"insert ('21/19/2222')into emp;",
				
				
		};
	}
}
