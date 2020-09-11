package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class MataTudo {
	public MataTudo() {
		super();
}
	
	public String SO() {
		String os = System.getProperty("os.name");
		return os;
}
	
	public void LerProcess(String SO) {
		if(SO.contains("Linux")) {
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
		}else {
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
		}
	}
	
	public void MatarPid (String SO, int Pid) { 
		if (SO.contains("Linux")) {
			try {
				Runtime.getRuntime().exec(("kill -9 " + Pid));
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			try {
				Runtime.getRuntime().exec("TASKKILL /PID " + Pid);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void MatarName(String SO, String Nome) {
		if (SO.contains("Windows")) {
			try {
				Runtime.getRuntime().exec("pkill " + Nome);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			try {
				Runtime.getRuntime().exec("TASKKILL /IM " + Nome);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		JOptionPane.showMessageDialog(null, "Eu sou o Kira");
	}

}
