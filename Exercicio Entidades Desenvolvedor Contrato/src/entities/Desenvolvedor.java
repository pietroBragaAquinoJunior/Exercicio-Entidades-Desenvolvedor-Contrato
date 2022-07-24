package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.NivelDesenvolvedor;

public class Desenvolvedor {
	
	private String nome;
	private NivelDesenvolvedor nivel;
	private Double salarioBase;
	private Departamento departamento;
	private List<ContratoHora> contratos = new ArrayList<>();
	
	public Desenvolvedor(String nome, NivelDesenvolvedor nivel, Double salarioBase, Departamento departamento) {
		this.nome = nome;
		this.nivel = nivel;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public NivelDesenvolvedor getNivel() {
		return nivel;
	}

	public void setNivel(NivelDesenvolvedor nivel) {
		this.nivel = nivel;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<ContratoHora> getContratos() {
		return contratos;
	}
	
	public void adicionarContrato(ContratoHora contrato) {
		contratos.add(contrato);
	}
	
	public void removerContrato(ContratoHora contrato) {
		contratos.remove(contrato);
	}

	public double calcularGanhos(int year, int month) {
		double soma = salarioBase;
		Calendar calendar = Calendar.getInstance();
		for(ContratoHora c: contratos) {
			calendar.setTime(c.getData());
			int c_year = calendar.get(Calendar.YEAR);
			int c_month = calendar.get(Calendar.MONTH + 1);
			if(year == c_year && c_month == month) {
				soma += c.calcularValorTotal();
			}
		}
		return soma;
	}
	
}
