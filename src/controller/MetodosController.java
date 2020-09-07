package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MetodosController {
	
	public MetodosController() {
		super();
	}
	
	public String qualSO() {
		return System.getProperty("os.name");
	}
	
	public void listarProcessos(String SO) {
		if(SO.contains("Windows")) {
			try {
				Process p = Runtime.getRuntime().exec("tasklist");
				InputStream stream = p.getInputStream();
				InputStreamReader reader = new InputStreamReader(stream);
				BufferedReader buffer = new BufferedReader(reader);
				String line = buffer.readLine();
				while(line != null) {
					System.out.println(line);
					line = buffer.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			try {
				Process p = Runtime.getRuntime().exec("ps -ef");
				InputStream stream = p.getInputStream();
				InputStreamReader reader = new InputStreamReader(stream);
				BufferedReader buffer = new BufferedReader(reader);
				String line = buffer.readLine();
				while(line != null) {
					System.out.println(line);
					line = buffer.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void killPID(String SO, int PID) {
		if(SO.contains("Windows")) {
			try {
				Runtime.getRuntime().exec("taskkill /PID " + PID);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			try {
				Runtime.getRuntime().exec("kill -9 " + PID);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void killName(String SO, String Name) {
		if(SO.contains("Windows")) {
			try {
				Runtime.getRuntime().exec("pkill " + Name);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
