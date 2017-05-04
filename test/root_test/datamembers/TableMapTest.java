package root_test.datamembers;

import root.data_statement.tables.TableMap;

import org.junit.BeforeClass;
import org.junit.Test;

public class TableMapTest {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		String[] animalsArr = new String[]{
				"frog varchar", "dog varchar"
		};
		String[] numbersArr = new String[]{
				"numberone integer", "numbertwo integer"
		};
		String[] ribbit = new String[]{
				"frog varchar", "froggie varchar"
		};
		String[] moo = new String[]{
				"cowone varchar", "ncowtwo varchar"
		};
		String[] trees = new String[]{
				"numberone integer", "numbertwo integer"
		};
		String[] reals = new String[]{
				"numberone real", "numbertwo real"
		};
		String[] chars = new String[]{
				"state char(2)", "zip char(5)"
		};
		String[] bools = new String[]{
				"hasdog true", "hascat false"
		};
		TableMap.getTableMap().createTable("animals", animalsArr);
		TableMap.getTableMap().createTable("numbers", numbersArr);
		TableMap.getTableMap().createTable("frogs", ribbit);
		TableMap.getTableMap().createTable("cows", moo);
		TableMap.getTableMap().createTable("trees", trees);
		TableMap.getTableMap().createTable("reals", reals);
		TableMap.getTableMap().createTable("chars", chars);
		TableMap.getTableMap().createTable("boles", bools);
	}

	@Test
	public void printContents() {
		TableMap.getTableMap().printTableNames();
		TableMap.getTableMap().printTables();
	}

}
