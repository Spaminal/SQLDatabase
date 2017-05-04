package root.data_statement.tables.binary_files;

import root.data_statement.tables.Field;
import root.data_statement.tables.Table;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Stores each Table as a Binary Map.
 */
public class BinaryMap {

	public BinaryMap() {

	}

	// Fix this!
	/**
	 * Creates a new Binary Map from Table.
	 */
	public BinaryMap(Table table) {
		String tableName = table.getName();
		boolean hasValues = table.hasValues();

		try {
			RandomAccessFile file = new RandomAccessFile(tableName, "rw");
			
			if (!hasValues) {
				file.writeUTF(tableName);
				for (Field field : table.getFields()) {
					file.writeUTF(field.getFieldName());
					file.writeUTF(field.getFieldType());
					if (field.getFieldType() == "CHAR"){
						file.writeUTF(field.getFieldSizeStr());
					}
					file.writeUTF(field.getFieldValue().toString());
				}
			} else {
				for (Field field : table.getFields()) {
					file.writeUTF(field.getFieldName());
					file.writeUTF(field.getFieldType());
					if(field.getFieldType() == "CHAR"){
						file.writeUTF(field.getFieldSizeStr());
					}
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Binary File Error");
		} catch (IOException e) {
			System.out.println("UTF Write Error");
		}

	}

	
	

}
