package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcessKill {
	public ProcessKill() {
		super();
}
	//verifica Sistema operacional
	public String SO() {
		String os = System.getProperty("os.name");
		return os;
		
		
}
	
	public void readProcess(String SO) {
		if(SO.contains("Windows")) { 				// se windows
			try {
			
				Process proc = Runtime.getRuntime().exec("TASKLIST");
				InputStream fluxo = proc.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					System.out.println(linha);
					linha = buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else { 					//se linux
			try {
			
				Process proc = Runtime.getRuntime().exec("ps -A");
				InputStream fluxo = proc.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					System.out.println(linha);
					linha = buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
		
			} catch (IOException e) {
			e.printStackTrace();
			}
		
		}
	}
	
	public void KillPid (String SO, int Pid) { 
			if (SO.contains("Windows")) {
				try {
					Runtime.getRuntime().exec("TASKKILL /PID " + Pid); 	//Comando Windows
				}catch(Exception e) {
					e.printStackTrace();
				}
			}else {
				try {
					Runtime.getRuntime().exec(("kill -9 " + Pid));		//Comando Linux
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
	}
	
	public void KillName(String SO, String Nome) {
			if (SO.contains("Windows")) {
				try {
					Runtime.getRuntime().exec("TASKKILL /IM " + Nome);	//Comando Windows
				}catch(Exception e) {
					e.printStackTrace();
				}
			}else {
				try {
					Runtime.getRuntime().exec("pkill " + Nome);		//Comando Linux
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
	}
	
}
