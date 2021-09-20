package Class;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class HandleFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new HandleFile().readFile("src\\Gui\\GuiClient.java");
	}
	
	
    public void CreateDirectory(String path, String nameFolder) {
    	try {
    	  	File x = new File(path + "\\" + nameFolder);
    	  	System.out.println(x.exists());
	  		  if (!x.exists()) {
	  			  if ( x.mkdir()) {
	  				  System.out.println("Create folder success!");
	  	                
	  			  } else {
	  				  System.out.println("ERROR!");
	  	          }
	  			  	path = path + "\\" + nameFolder;         
	  		  }else {
	  			  System.out.println("Folder already exists");
	  		  }
		} catch (Exception e) {
			// TODO: handle exception
		}
  
    }
	
    public void createFile(String path, String nameFile) {
    	File file = new File(path + "\\" + nameFile);
    	try {
			if( file.createNewFile()) {
				System.out.println("Tạo file thành côcng");
			}else {
				System.out.println("lỗi rồi ");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
    public void writeFile(String path, String content) {
    	try {
			FileOutputStream file = new FileOutputStream(path);
			String string = content;
			byte[] a = string.getBytes(); // ep kieu String ve mang byte
		
			file.write(a); // ghi mang byte vao file
			System.out.print("Da ghi thanh cong!");
			file.close();
		} catch (Exception e2) {
			System.out.print(e2);// In lỗi ra màn hình
		}
    }
    
    public void readFile(String path) {
    	 BufferedReader br = null;
    	 if(!checkFileExist(path)) {
    		 System.out.println("file ko tồn tại");
    	 }else {
	         try {   
	             br = new BufferedReader(new FileReader(path));       
	             int num=0;
	             char ch;
	
	             while((num = br.read()) != -1)
	             {    
	                 ch = (char) num;
	                 System.out.print(ch);
	             }
	         }catch(Exception e) {
	        	 System.out.println(e.getMessage());
	         }
    	 }
    }
    public boolean checkFileExist(String path) {
	  	File file = new File(path);
	  	if( file.exists() ) {
	  		return true ; 
	  	}
    	return false ; 
    }

}
