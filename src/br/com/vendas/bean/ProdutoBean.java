package br.com.vendas.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.vendas.dao.ProdutoDao;
import br.com.vendas.model.Produto;

@ManagedBean (name = "ProdutoBean")
@ViewScoped
public class ProdutoBean {

	private Produto produto;
	private List<Produto> produtos;
	private String acao;
	private String codigo;
	
	public ProdutoBean() {
	}

	public void carregar() {
		ProdutoDao pdao = new ProdutoDao();
		produtos = pdao.listar();
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

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
}
