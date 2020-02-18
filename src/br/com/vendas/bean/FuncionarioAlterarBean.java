package br.com.vendas.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.vendas.dao.FuncionarioDao;
import br.com.vendas.model.Funcionario;

@ManagedBean(name = "FuncionarioAlterarBean")
@ViewScoped
public class FuncionarioAlterarBean {

	private Funcionario funcionario;
	private String acao;
	private Long codigo;

	public FuncionarioAlterarBean() {

	}

	public FuncionarioAlterarBean(Funcionario funcionario) {
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

	public void carregar() {
		if (codigo != null) {
			FuncionarioDao fdao = new FuncionarioDao();
			funcionario = fdao.buscarPorId(codigo);
		} else {
			funcionario = new Funcionario();
		}

	}
	
	public void excluir() {
		FuncionarioDao fdao = new FuncionarioDao();
		fdao.excluir(funcionario);
		funcionario = new Funcionario();
	}

	public void editar() {
		FuncionarioDao fdao = new FuncionarioDao();
		fdao.alterar(funcionario);
		funcionario = new Funcionario();
	}

}
