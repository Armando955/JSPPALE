package it.contrader.service;

import it.contrader.converter.SchedaConverter;
import it.contrader.dao.SchedaDAO;
import it.contrader.dto.SchedaDTO;
import it.contrader.model.Scheda;

public class SchedaService extends AbstractService<Scheda, SchedaDTO> {
	
	public SchedaService(){
		this.dao = new SchedaDAO();
		this.converter = new SchedaConverter();
	}
	

}
