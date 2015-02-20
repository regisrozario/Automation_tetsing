package day1;

import java.io.File;


public class Utils {
	
	public static void main(String args[]){
		String dirPath = "E:\\folder";
		
		File folder = new File(dirPath);
		
		removeFiles(folder);
		
	}
	
	
	public static void removeFiles(File folder){
	
	if(folder.isDirectory()){
		if(folder.listFiles().length!=0){
			
		File[] Filenames = folder.listFiles();
		int numberOfFiles = Filenames.length;
		
		
		for(int i = 0; i<numberOfFiles; i++){
			
			if (Filenames[i].isDirectory()){
				
				removeFiles(Filenames[i]);
			}
			else
			{
				boolean result = Filenames[i].delete();
				String value = (result)? "Filename"+ Filenames[i].getName()+ " Successfully deleted": "unable to delete file : "+ Filenames[i].getName();
				
				System.out.println(value);
			}
		}
		}
		boolean result = folder.delete();
		String value = (result)? "Folder"+ folder.getName()+ " Successfully deleted": "unable to delete folder : "+ folder.getName();
		
		System.out.println(value);
	}
		
	}
}