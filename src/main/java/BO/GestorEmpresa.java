package BO;

import java.util.List;

import javax.transaction.Transactional;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DAO.DaoEmpresa;
import VO.Empresa;

@Service
public class GestorEmpresa {

	// @Autowired
	DaoEmpresa daoEmpresa = new DaoEmpresa();

	public GestorEmpresa() {
		super();
	}

	@Transactional
	public boolean crearEmpresa(Empresa empresa) {

		return daoEmpresa.crearEmpresa(empresa);

	}

	@Transactional
	public boolean modificarEmpresa(Empresa empresa) {

		return daoEmpresa.modificarEmpresa(empresa);
	}

	@Transactional
	public boolean borrarEmpresa(Empresa empresa) {
		return daoEmpresa.borrarEmpresa(empresa);
	}

	public Empresa obtenerEmpresa(int idEmpresa) {

		return daoEmpresa.obtenerEmpresa(idEmpresa);

	}

	public List<Empresa> listarEmpresas() {

		return daoEmpresa.listarEmpresas();
	}

}
