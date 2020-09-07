package view;

import javax.swing.JOptionPane;

import controller.MetodosController;

public class Main {
	
	public static void main(String[] args) {
		MetodosController metodos = new MetodosController();
		String SO = metodos.qualSO();
		int opc = 0;
		while(opc != 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("Menu:"
					+ "\n1- Mostrar processos"
					+ "\n2- Matar por PID"
					+ "\n3- Matar por nome"
					+ "\n9- Sair"
					+ "\nEscolha uma opção:"));
			switch(opc) {
				case 1: metodos.listarProcessos(SO);
					break;
				case 2:
					int PID = Integer.parseInt(JOptionPane.showInputDialog("Insira o PID"));
					metodos.killPID(SO, PID);
					break;
				case 3:
					String Name = JOptionPane.showInputDialog("Insira o nome");
					metodos.killName(SO, Name);
					break;
				case 9:
					JOptionPane.showMessageDialog(null, "bye bye...");
					break;
				default:
					JOptionPane.showMessageDialog(null, "Error, escolha uma opção acima");
			}
		}
	}
}
