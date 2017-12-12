import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Github {
	public static void main(String[] args) throws Exception {
		System.out.println("Enter your username: ");
		Scanner input = new Scanner(System.in);
		String username = input.nextLine();
		
		URL user = new URL("https://api.github.com/search/users?q=" + username);
		URLConnection con = user.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;

		while ((inputLine = in.readLine()) != null)
			System.out.println(inputLine);
		in.close();
	}

}
