package utils;

import java.util.Random;

public class EmailGeneratorUtil {
	
	

	public static String generateRandomEmail() {
		String characters = "abcdefghijklmnopqrstuvwxyz1234567890";
		StringBuilder email = new StringBuilder();
		
		Random random = new Random();
		
		for(int i=0;i<10;i++)
		{
			email.append(characters.charAt(random.nextInt(characters.length())));
		}
		email.append("@exampple.com");
		
		
		
		
		return email.toString();
	}

}
