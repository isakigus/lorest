package test.etiquetas;

import BO.GestorEtiquetas;
import DAO.DaoEtiquetas;
import VO.Etiquetas;

public class ObtenerTestEtiqueta {
	
	public static void main(String[] args) {
		

		DaoEtiquetas dao = new DaoEtiquetas();

		Etiquetas selecionado = dao.obtenerEtiqueta(5);

		System.out.println(selecionado);
		
		
		

		GestorEtiquetas gestor = new GestorEtiquetas();

		Etiquetas selecionado2 = gestor.obtenerEtiqueta(5);

		System.out.println(selecionado2);
		
		
		;

	}

}
