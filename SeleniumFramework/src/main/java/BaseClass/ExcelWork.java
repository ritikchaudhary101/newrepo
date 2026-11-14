package BaseClass;
import org.apache.poi.ss.usermodel.DataFormatter;
import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWork {
	

	 
		
		public class ForExcel {

			
			public String getdata(String path, int sheetno , int row , int column)
			{
				
				
	           String value = "";
				
				try {
						FileInputStream fis = new FileInputStream(path);
						XSSFWorkbook wb = new XSSFWorkbook(fis);
						
			         XSSFSheet sheet	= wb.getSheetAt(sheetno);
			         DataFormatter formatter = new DataFormatter();
			         
			         value = formatter.formatCellValue(sheet.getRow(row).getCell(column));
				}
				catch (Exception e) {
					
					System.out.println("issue in get read" +e);
					
				}
			         return value;
			         
			         
				
				
			}

			public static void main(String[] args) {
				
				String path = "C:\\workspace\\java workspace\\Newproject\\TestData\\Book1.xlsx";
						ForExcel ob = new ForExcel();
						
						ArrayList<String> names = new ArrayList<>();
						ArrayList<String> aadhaarList = new ArrayList<>();
						ArrayList<String> voterIdList = new ArrayList<>();
						for(int i = 0; i <=10;i++)
						{
						
							
								String name = ob.getdata(path, 0, i, 0);
						        String aadhaar = ob.getdata(path, 0, i, 1);
						        String voterId = ob.getdata(path, 0, i, 2);

						        names.add(name);
						        aadhaarList.add(aadhaar);
						        voterIdList.add(voterId);
						
							
							

						        //System.out.printf("%-12s | %-18s | %-15s%n",
						               // names.get(i),
						                //aadhaarList.get(i),
						                //voterIdList.get(i));
							
							
				
					
							System.out.println(names.get(i) +   "  |  " + aadhaarList.get(i) + "  |  "   +  voterIdList.get(i));
				
						}}}
		
		


}
