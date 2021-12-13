package myminiprj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class CinemaMain {
	private BufferedReader br;
	private CinemaDAO dao;
	
	public CinemaMain() {
		dao = new CinemaDAO();
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

	}
	public static void main(String[] args) {
		new CinemaMain();
	}
}