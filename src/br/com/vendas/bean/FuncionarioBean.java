package br.com.vendas.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.vendas.dao.FuncionarioDao;
import br.com.vendas.model.Funcionario;

@ManagedBean(name = "FuncionarioBean")
@ViewScoped
public class FuncionarioBean {

	private Funcionario funcionario;
	private String acao;
	private Long codigo;
	private List<Funcionario> funcionarios;
	private List<Funcionario> funcionariosFiltrados;

	public FuncionarioBean() {
	}

	public void novo() {
		this.funcionario = new Funcionario();
	}

	public void carregar() {
		FuncionarioDao fdao = new FuncionarioDao();
		funcionarios = fdao.listar();
	}

	
	public FuncionarioBean(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Funcionario getFuncionario() {
		if (funcionario == null) {
			funcionario = new Funcionario();
		}
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public List<Funcionario> getFuncionariosFiltrados() {
		return funcionariosFiltrados;
	}

	public void setFuncionariosFiltrados(List<Funcionario> funcionariosFiltrados) {
		this.funcionariosFiltrados = funcionariosFiltrados;
	}

}
