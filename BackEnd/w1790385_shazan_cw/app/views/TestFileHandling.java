package views;

import services.RequestLogic;

public class TestFileHandling {
	public static void main(String[] args){
		//to reload the file
		RequestLogic requestLogics = new RequestLogic();
		requestLogics.saveToTheFile();
		requestLogics.readFromTheFile();
	}

}
