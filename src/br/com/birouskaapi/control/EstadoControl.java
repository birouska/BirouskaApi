package br.com.birouskaapi.control;

import java.util.List;

import br.com.birouskaapi.dao.EstadoDAO;
import br.com.birouskaapi.model.Estado;

public class EstadoControl {

	EstadoDAO estDao = new EstadoDAO();

	public List<Estado> List() {
		return estDao.List();
	}

}
