package calc;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {

	/**
	 * 配列の値をExcelに書き込む
	 * @param filePath ファイルパス
	 * @param x 二次配列
	 * @param rowNumber 書き始める行番号(1,2,3,…)
	 * @param cellNumber 書き始める列番号(1,2,3,…)
	 */
	public static void excelWrite(String fileName,double[][] x,int rowNumber,int cellNumber) {
		
		XSSFWorkbook workbook = findFile(fileName);
		
		XSSFSheet sheet = null;
		
		//シートを作成
		sheet = workbook.getSheet("Sheet1");
		
		int rowCount = rowNumber-1;
		int cellCount = rowNumber-1;
		for(int i=0;i<x.length;i++){
			XSSFRow row = sheet.createRow(rowCount);
			rowCount++;
			for(int j=0;j<x[0].length;j++){
				XSSFCell cell = row.createCell(cellCount);
				//セルのｍに値を挿入
				cell.setCellValue(x[i][j]);
				cellCount++;
			}
		}
		try{
			FileOutputStream out = new FileOutputStream(fileName);
			workbook.write(out);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	
	/**
	 * ファイルを探し、無ければ作成
	 * @param fileName
	 * @return XSSFWorkbook
	 */
	private static XSSFWorkbook findFile(String fileName){
		
		FileInputStream inStream = null;
		XSSFWorkbook workbook = null;

		//ファイルを指定
		try{
			inStream = new FileInputStream(fileName);
			workbook = new XSSFWorkbook ( inStream );
			inStream.close();
		}catch(IOException e){
			//ファイルが見つからない場合はファイルを作成する
			e.printStackTrace();
			System.out.println("Excelファイルを作成します");
			try{
				FileOutputStream out = new FileOutputStream(fileName);
				out.close();
			}catch(IOException e2){
				e2.printStackTrace();
			}
			workbook = new XSSFWorkbook();
		}
		
		return workbook;

	}
}


