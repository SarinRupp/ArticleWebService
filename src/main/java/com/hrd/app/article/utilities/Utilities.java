package com.hrd.app.article.utilities;

import java.io.File;

public class Utilities {

	public static void deleteFile(String filename) {
		
		try {

			File file = new File(filename);

			if (file.delete()) {
				System.out.println(file.getName() + " is deleted!");
			} else {
				System.out.println("Delete operation is failed.");
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static int offset(int limit, int offset){
		return limit * (offset - 1);
	}

}
