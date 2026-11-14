package Utils;

import java.io.IOException;

public interface ExcelReader {

	public String getdata(String path, int sheetno , int row , int column) throws IOException;
	
	
}
