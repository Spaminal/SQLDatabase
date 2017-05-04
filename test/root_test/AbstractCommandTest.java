/* Jacob Culley
 * CS 210 
 * Instructor Morehead
 * AbstractCommandTest class base supplied by instructor
 */
package root_test;

import static org.junit.Assert.*;

import org.junit.Test;

import root.ICommand;


/**
 * The Class AbstractCommandTest.
 */
public abstract class AbstractCommandTest {
		
		protected ICommand command;
				
		public abstract void setUp() throws Exception;
			
		protected String[] good;		
		protected String[] bad;		
		
		@Test
		public void testMatches(){
			for(String s : good){
				System.out.println(s);
				assertTrue(command.matches(s));
			}
			for(String s : bad){
				System.out.println(s);
				assertFalse(command.matches(s));
			}
		}
}