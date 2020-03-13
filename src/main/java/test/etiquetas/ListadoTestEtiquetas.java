package test.etiqueta;

import java.util.List;

import muela.BO.GestorEtiqueta;
import muela.DAO.DaoEtiqueta;
import muela.VO.Etiqueta;

public class ListadoTestEtiqueta {

	public static void main(String[] args) {

		DaoEtiqueta dao = new DaoEtiqueta();

		List<Etiqueta> listado = dao.listarTodasEtiqueta();

		System.out.println(listado);

		GestorEtiqueta gestor = new GestorEtiqueta();

		List<Etiqueta> listado2 = gestor.listaEtiqueta();

		System.out.println(listado2);

	}

}
