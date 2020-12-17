package utils;

import java.io.*;
import java.util.ArrayList;

public class FileHandling {
	/**
	 * Made a generic method to write all the different club into different files and any type of array can be written to a file by using this method.
	 * @param fileNameToWrite the file name that the object needed to be written
	 * @param listOfObjectsToSave arraylist name that has to be written
	 * @param <T> generic symbol T
	 */
	public static <T> void writingToAFile(File fileNameToWrite, ArrayList<T> listOfObjectsToSave){
		FileOutputStream savingTheObjects = null;
		ObjectOutputStream toWriteTheObj = null;
		
		try{
			savingTheObjects = new FileOutputStream(fileNameToWrite);
			toWriteTheObj = new ObjectOutputStream(savingTheObjects);
			toWriteTheObj.writeObject(listOfObjectsToSave);  //writing the arraylist as a whole into the file
		
		}catch(FileNotFoundException fileMissing){
			System.out.println(" File is not available");
			
		}catch(IOException objectMissing){
			System.out.println(" Object is missing");
			
		}finally{
			try{
				savingTheObjects.close();
				toWriteTheObj.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}	
}
