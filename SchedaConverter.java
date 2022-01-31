package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.SchedaDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Scheda;
import it.contrader.model.User;

public class SchedaConverter  implements Converter<Scheda, SchedaDTO> {

	public SchedaDTO toDTO(Scheda schedaDTO) {
		
		SchedaDTO scheda = new SchedaDTO(schedaDTO.getId_scheda(), schedaDTO.getUser_id(), schedaDTO.getTipo_esercizio(), schedaDTO.getNum_ripetizioni());
		return scheda;

	}

	@Override
	public Scheda toEntity(SchedaDTO schedaDTO) {
		Scheda scheda = new Scheda(schedaDTO.getId_scheda(), schedaDTO.getUser_id(), schedaDTO.getTipo_esercizio(), schedaDTO.getNum_ripetizioni());
		return scheda;
	}
	@Override
	public List<SchedaDTO> toDTOList(List<Scheda> schedaList) {
		List<SchedaDTO> schedaDTOList = new ArrayList<SchedaDTO>();
		for(Scheda scheda : schedaList) {
			schedaDTOList.add(toDTO(scheda));
		}

		return schedaDTOList;
	}
}