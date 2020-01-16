package br.com.caelum.ingresso.model.form;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.caelum.ingresso.dao.LugarDao;
import br.com.caelum.ingresso.dao.SessaoDao;
import br.com.caelum.ingresso.model.Ingresso;


public class CarrinhoForm {
	
	
	private List<Ingresso> ingresso = new ArrayList<>();

	public List<Ingresso> getIngresso() {
		return ingresso;
	}

	public void setIngresso(List<Ingresso> ingresso) {
		this.ingresso = ingresso;
	}
	public List<Ingresso> toIngressos(SessaoDao sessaoDao, LugarDao lugarDao){
		
		return this.ingressos.stream().map(ingresso ->{
			Sessao sessao = sessaoDao.findOne(ingresso.getSessao().getId());
			Lugar lugar = lugarDao.findOne(ingresso.gatLugar().getId());
			TipoDeIngresso tipoDeIngresso = ingresso.getTipoDeIngresso();
			return new Ingresso(sessao, tipoDeIngresso, lugar);
		}).collect(Collectors.toList());
		
	}

}
