package test.etiquetas;

import java.util.List;

import BO.GestorEtiquetas;
import DAO.DaoEtiquetas;
import VO.Etiquetas;

public class ListadoTestEtiquetas {

	public static void main(String[] args) {

		DaoEtiquetas dao = new DaoEtiquetas();

		List<Etiquetas> listado = dao.listarTodasEtiquetas();

		System.out.println(listado);

		GestorEtiquetas gestor = new GestorEtiquetas();

		List<Etiquetas> listado2 = gestor.listaEtiquetas();

		System.out.println(listado2);

	}

}
