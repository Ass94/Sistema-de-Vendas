package br.com.vendas.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.vendas.dao.FuncionarioDao;
import br.com.vendas.model.Funcionario;

@ManagedBean(name = "FuncionarioIncluirBean")
@ViewScoped
public class FuncionarioIncluirBean {
	
	private Funcionario funcionario;
	private String acao;
	private Long codigo;
	
	public FuncionarioIncluirBean() {
		
	}
	
	public FuncionarioIncluirBean(Funcionario funcionario) {
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

	public void novo() {
		this.funcionario = new Funcionario();
	}
	
	public void salvar() {
		FuncionarioDao fdao = new FuncionarioDao();
		fdao.salvar(funcionario);
		funcionario = new Funcionario();
	}
	
	public void carregar() {
		if (codigo != null) {
			FuncionarioDao fdao = new FuncionarioDao();
			funcionario = fdao.buscarPorId(codigo);
		} else {
			funcionario = new Funcionario();
		}
		
	}
	
}
