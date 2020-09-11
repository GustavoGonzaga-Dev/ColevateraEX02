package view;

import javax.swing.JOptionPane;
import controller.MataTudo;

public class Menu {
	public static void main(String[] args) {
		MataTudo procController = new MataTudo();
		String os = procController.SO();
		int esc, Pid;
		String Nome;
		do {
			esc = Integer.parseInt(JOptionPane.showInputDialog
					(os +": \n 1 - Processos \n 2 - Matar por Pid \n 3 - Matar por Nome \n 9 - Finalizar"));
			switch(esc) {	
				case 1:
					procController.LerProcess(os);
					break;
				case 2:
					 Pid = Integer.parseInt(JOptionPane.showInputDialog("Digite o Pid do processo: "));
					 procController.MatarPid(os, Pid);
					 System.out.println("Sistema operacional: " + os + " \n Pid: " + Pid + " processo matado ");
					break;
				case 3:
					Nome = JOptionPane.showInputDialog("Digite o Nome do processo");
					procController.MatarName(os, Nome);
					System.out.println("Sistema operacional: " + os + " \n Nome: " + Nome + " processo matado");
					break;
				case 9:
					JOptionPane.showMessageDialog(null,"Falouu :3");
					break;
				default:
					JOptionPane.showMessageDialog(null,"Valor invalido!");
				break;
			}
		}while(esc!=9);
	}
}
