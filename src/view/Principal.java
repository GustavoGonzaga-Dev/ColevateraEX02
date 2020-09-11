package view;

import javax.swing.JOptionPane;

import controller.ProcessKill;

public class Principal {

	public static void main(String[] args) {

		ProcessKill procController = new ProcessKill();
		String os = procController.SO();
		
		int Pid, menu;
		String Nome;
		do {
			menu = Integer.parseInt(JOptionPane.showInputDialog
					("Menu: \n" 
					+ "1 - Processos \n" 
					+ "2 - Kill por Pid \n" 
					+ "3 - Kill por Nome \n" 
					+ "9 - Finalizar"));
			
			switch(menu) {	
				case 1:
					procController.readProcess(os);
					break;
				case 2:
					 Pid = Integer.parseInt(JOptionPane.showInputDialog("Digite o Pid do processo: "));
					 procController.KillPid(os, Pid);
					 System.out.println("Sistema operacional: " + os + " \n Pid: " + Pid + " processo morto ");
					break;
				case 3:
					Nome = JOptionPane.showInputDialog("Digite o Nome do processo");
					procController.KillName(os, Nome);
					System.out.println("Sistema operacional: " + os + " \n Nome: " + Nome + " processo morto");
					break;
				case 9:
					JOptionPane.showMessageDialog(null,"Programa finalizado");
					break;
				default:
					JOptionPane.showMessageDialog(null,"Valor inserido é invalido!");
			}
			
		}while(menu!=9);
	}
 

}
