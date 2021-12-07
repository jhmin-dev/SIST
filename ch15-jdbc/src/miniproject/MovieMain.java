package miniproject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class MovieMain {
	private BufferedReader br;
	private MovieDAO dao;
	
	public MovieMain() {
		dao = new MovieDAO();
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			callMenu();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			if(br!=null) try {br.close();} catch(IOException e) {}
		}
	}
	
	public void callMenu() throws IOException {
		while(true) {

		}
	}
	
	public static void main(String[] args) {
		new MovieMain();
	}
}