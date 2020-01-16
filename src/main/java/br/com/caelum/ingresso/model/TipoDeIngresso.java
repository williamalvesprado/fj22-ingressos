package br.com.caelum.ingresso.model;

import java.math.BigDecimal;

import br.com.caelum.ingresso.model.desconto.Desconto;
import br.com.caelum.ingresso.model.desconto.DescontoParaBancos;
import br.com.caelum.ingresso.model.desconto.DescontoParaEstudante;
import br.com.caelum.ingresso.model.desconto.SemDesconto;

public enum TipoDeIngresso {
	
	Inteiro(new SemDesconto()),
	Estudante(new DescontoParaEstudante()),
	Banco(new DescontoParaBancos());

	private final Desconto desconto;
	
	TipoDeIngresso(Desconto desconto){
		this.desconto = desconto;

	}
	
	public BigDecimal aplicaDesconto(BigDecimal valor) {
		return desconto.aplicarDescontoSobre(valor);
		
	}
	public String getDescricao() {
		return desconto.getDescricao();
	}
	
	
	
	
}
