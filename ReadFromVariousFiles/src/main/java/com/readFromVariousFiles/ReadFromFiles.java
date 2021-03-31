package com.readFromVariousFiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Map;
import java.util.Properties;

import org.yaml.snakeyaml.Yaml;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

 
public class ReadFromFiles 
{
	static ReadFromFiles readFromFiles = new ReadFromFiles();
    public static void main( String[] args ) throws IOException, BiffException
    {
		readFromFiles.readFromYAMLFile();
		readFromFiles.readFromExcel();
        readFromFiles.readFromCSV();
		readFromFiles.readFromPropertiesFile();
		readFromFiles.readFromTextFile();
    }

	public void readFromYAMLFile() throws FileNotFoundException {
		Yaml yaml = new Yaml();
		InputStream is = new FileInputStream(new File("Files/yamlFile.yml"));
		Map<String,Object> result = yaml.load(is);
		String a = (String) result.get("Starting range");
		System.out.println(result.toString());
		Collection<Object> file = result.values();
		System.out.println(file);
	}

	public void readFromExcel() throws BiffException, IOException {
		File f = new File("Files/excelFile.xls");
		Workbook wb = Workbook.getWorkbook(f);
		Sheet sh = wb.getSheet(0);
		int col = sh.getColumns();
		int row = sh.getRows();
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				Cell c = sh.getCell(j, i);
				System.out.println(c.getContents());
			}
		}
	}

    public void readFromCSV() throws IOException {
        File file = new File("Files/csvFile.csv");
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);
		String text;
		String[] filedata = null;
		while ((text=br.readLine())!=null) {
			filedata = text.split(",");
		}
		for(int i=0;i<filedata.length;i++)
			System.out.println(filedata[i]);

		br.close();
    }

	public void readFromPropertiesFile() throws FileNotFoundException, IOException {
		FileReader reader=new FileReader("Files/propertiesFile.properties");  
		Properties p=new Properties();  
		p.load(reader); 
		System.out.println(p.getProperty("key1"));
		System.out.println(p.getProperty("key2"));
	}

	public void readFromTextFile() throws IOException {
		File f = new File("Files/textFile.txt");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String text;
		String[] filedata = null;
		while ((text=br.readLine())!=null) {
			filedata = text.split(",");
		}
		for(int i=0;i<filedata.length;i++)
			System.out.println(filedata[i]);

		br.close();
	}
}
