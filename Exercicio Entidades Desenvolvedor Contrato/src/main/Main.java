package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.ContratoHora;
import entities.Departamento;
import entities.Desenvolvedor;
import entities.enums.NivelDesenvolvedor;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		/* O programa recebe informações referentes ao desenvolvedor, departamento e contratos */
		/* O programa recebe uma data e calcula o salário que o desenvolvedor deve receber no mês */
		/* Exercício em java para treinamento de Calendar, Entidades, Enum, Lista, Métodos e outros */
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Insira o nome do departamento: ");
		String nomeDepartamento = sc.next();
		
		System.out.println("Informações sobre o desenvolvedor: ");
		System.out.print("Nome: ");
		String nomeDesenvolvedor = sc.next();
		System.out.print("Nível (JUNIOR, PLENO ou SENIOR): ");
		String nivel = sc.next();
		System.out.print("Salário base: ");
		double salarioBase = sc.nextDouble();
		
		NivelDesenvolvedor nivelDesenvolvedor = NivelDesenvolvedor.valueOf(nivel);
		Departamento departamento = new Departamento(nomeDepartamento);
		Desenvolvedor desenvolvedor = new Desenvolvedor(nomeDesenvolvedor, nivelDesenvolvedor, salarioBase, departamento);
	
		System.out.print("Quantos contratos para este desenvolvedor?");
		int nContratos = sc.nextInt();
		
		for(int i=0;i<nContratos;i++) {
			System.out.println("Contrato #"+i+": ");
			System.out.print("Data (DD/MM/YYYY): ");
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date dataContrato = sdf.parse(sc.next());
			System.out.print("Valor hora: ");
			double valorHora = sc.nextDouble();
			System.out.print("Duração em horas: ");
			int duracaoHoras = sc.nextInt();
			ContratoHora contrato = new ContratoHora(dataContrato, valorHora, duracaoHoras);
			desenvolvedor.adicionarContrato(contrato);
		}
		
		System.out.println("Digite um mês e ano para calcular os ganhos (MM/yyyy): ");
		String dataDigitadaGanhos = sc.next();
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("MM/yyyy");
		Date dataGanho = sdf2.parse(dataDigitadaGanhos);
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(dataGanho);
		int mesGanho = calendario.get(Calendar.MONTH + 1);
		int anoGanho = calendario.get(Calendar.YEAR);
		
		System.out.println("Nome: "+desenvolvedor.getNome());
		System.out.println("Departamento: "+ desenvolvedor.getDepartamento().getName());
		System.out.println("Valor recebido em "+ sdf2.format(dataGanho) +": "+desenvolvedor.calcularGanhos(anoGanho, mesGanho));
		
		sc.close();

	}

}
