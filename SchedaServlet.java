package it.contrader.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.SchedaDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.SchedaService;
import it.contrader.service.UserService;
import it.contrader.service.Service;

public class SchedaServlet extends HttpServlet  {

	private static final long serialVersionUID = 1L;

	public SchedaServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<SchedaDTO> service = new SchedaService();
		List<SchedaDTO> listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<SchedaDTO> service = new SchedaService();
		String mode = request.getParameter("mode");
		SchedaDTO dto;
		int id_scheda;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "SCHEDALIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/scheda/schedamanager.jsp").forward(request, response);
		break;

		case "READ":
			id_scheda = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id_scheda);
			request.setAttribute("dto", dto);

			if (request.getParameter("update") == null) {
				getServletContext().getRequestDispatcher("/scheda/readscheda.jsp").forward(request, response);
			}
			else {
				getServletContext().getRequestDispatcher("/scheda/updatescheda.jsp").forward(request, response);
			}

			break;

		case "INSERT":
			int user_id = Integer.parseInt(request.getParameter("user_id").toString());
			String tipo_esercizio = request.getParameter("tipo_esercizio").toString();
			int num_ripetizioni = Integer.parseInt(request.getParameter("num_ripetizioni").toString());
			dto = new SchedaDTO (user_id, tipo_esercizio, num_ripetizioni);
			ans = service.insert(dto);

			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/scheda/schedamanager.jsp").forward(request, response);
			break;

		case "UPDATE":
			user_id = Integer.parseInt(request.getParameter("user_id"));
			tipo_esercizio = request.getParameter("tipo_esercizio");
			num_ripetizioni = Integer.parseInt(request.getParameter("num_ripetizioni"));
			id_scheda = Integer.parseInt(request.getParameter("id"));
			dto = new SchedaDTO (id_scheda, user_id, tipo_esercizio, num_ripetizioni);
			System.out.println(dto.toString());
			ans = service.update(dto); 
			System.out.println(ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/scheda/schedamanager.jsp").forward(request, response);
			break;

			case "DELETE":
				id_scheda = Integer.parseInt(request.getParameter("id"));
				ans = service.delete(id_scheda);
				request.setAttribute("ans", ans);
				updateList(request);
				getServletContext().getRequestDispatcher("/scheda/schedamanager.jsp").forward(request, response);
				break;
		}
	}
}