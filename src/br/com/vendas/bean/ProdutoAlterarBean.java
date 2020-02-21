package br.com.vendas.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.vendas.dao.FornecedorDao;
import br.com.vendas.dao.ProdutoDao;
import br.com.vendas.model.Fornecedor;
import br.com.vendas.model.Produto;

@ManagedBean (name = "ProdutoAlterarBean")
@ViewScoped
public class ProdutoAlterarBean {
	
	private Produto produto;
	private String acao;
	private Long codigo;
	
	private List<Fornecedor> fornecedores;
	
	public ProdutoAlterarBean() {
	}
	
	public void carregar() {
		
		if (codigo != null) {
			ProdutoDao pdao = new ProdutoDao();
			produto = pdao.buscarPorId(codigo);
		} else {
			produto = new Produto();
		}
		
		FornecedorDao fdao = new FornecedorDao();
		fornecedores = fdao.listar();
	}
	
	public void editar() {
		
	}
	
	public Produto getProduto() {
		if (produto == null) {
			produto = new Produto();
		}
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
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

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}
	
	
	
	

}
