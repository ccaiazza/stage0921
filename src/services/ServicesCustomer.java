package services;

import java.util.ArrayList;

import bean.Aereo;
import bean.Aeroporto;
import bean.Volo;
import dao.AereoDAOImpl;
import dao.AeroportoDAOImpl;
import dao.GenericDAO;
import dao.VoloDAOImpl;

public class ServicesCustomer {

	private VoloDAOImpl voloDAO;
	private AeroportoDAOImpl aeroportoDAO ;
	private AereoDAOImpl aereoDAO ;

	public ServicesCustomer() {
		aeroportoDAO = new AeroportoDAOImpl();
		aereoDAO = new AereoDAOImpl();
		voloDAO = new VoloDAOImpl();
	};

	public boolean insertAereo(Aereo aereo) {

		return aereoDAO.insert(aereo);
	}

	public boolean insertAeroporto(Aeroporto aeroporto) {

		return aeroportoDAO.insert(aeroporto);
	}

	public boolean insertVolo(Volo volo) {

		if(aereoDAO.getByPk(volo.getAereo().getAereoId())!=null 
				&& aeroportoDAO.getByPk(volo.getAeroportoArrivo().getAeroportoId())!=null
				&& aeroportoDAO.getByPk(volo.getAeroportoPartenza().getAeroportoId())!=null ) {

			return voloDAO.insert(volo);
		}

		return false;
	}

	public boolean deleteAereo(Object id) {

		return aereoDAO.delete(id);
	}

	public boolean deleteAeroporto(Object id) {

		return aeroportoDAO.delete(id);
	}


	public boolean deletetVolo(Object id) {

		return voloDAO.delete(id);
	}

	public boolean updateAereo(Aereo aereo, Object id) {

		Aereo provvisorio = aereoDAO.getByPk(id);
		provvisorio.setNomeAereo(aereo.getNomeAereo());
		provvisorio.setTipoAereo(aereo.getTipoAereo());
		provvisorio.setPostiDisponibili(aereo.getPostiDisponibili());
		provvisorio.setCompagniaAppartenenza(aereo.getCompagniaAppartenenza());

		return aereoDAO.update(provvisorio, id);
	}

	public boolean updateAeroporto(Aeroporto aeroporto, Object id) {

		Aeroporto provvisorio = aeroportoDAO.getByPk(id);
		provvisorio.setCittà(aeroporto.getCittà());
		provvisorio.setNazione(aeroporto.getNazione());
		provvisorio.setNome(aeroporto.getNome());
		provvisorio.setNumeroPiste(aeroporto.getNumeroPiste());

		return aeroportoDAO.update(provvisorio, id );
	}


	public boolean upadteVolo(Volo volo, Object id) {		

		Volo provvisorio = voloDAO.getByPk(id);

		provvisorio.setDataPartenza(volo.getDataPartenza()); ;
		provvisorio.setDataArrivo(volo.getDataArrivo());;
		provvisorio.setNumeroPasseggeri(volo.getNumeroPasseggeri()); ;

		if(aeroportoDAO.getByPk(volo.getAeroportoPartenza().getAeroportoId())==null)
			return false;
		provvisorio.setAeroportoPartenza(volo.getAeroportoPartenza());
		if(aeroportoDAO.getByPk(volo.getAeroportoArrivo().getAeroportoId())==null)
			return false;
		provvisorio.setAeroportoArrivo(volo.getAeroportoArrivo());

		if(aereoDAO.getByPk(volo.getAereo().getAereoId())==null)
			return false;
		provvisorio.setAereo(volo.getAereo()); ;

		return voloDAO.update(volo, id);
	}

	public ArrayList<Aereo> getAerei() {

		return aereoDAO.getAll();
	}

	public ArrayList<Aeroporto> getAeroporti() {

		return aeroportoDAO.getAll();
	}

	public ArrayList<Volo> getVoli() {

		return voloDAO.getAll();
	}

	public void removeVoloFromAereo(Object id) {
		
		Aereo aereo = aereoDAO.getByPk(id);
		ArrayList<Volo> voli = voloDAO.getAll();

		for( Volo v:voli) {
			if(v.getAereo().getAereoId()==aereo.getAereoId())
				voloDAO.delete(v);
		}
	}

	public Aereo getAereoByPK(Object id) {

		return aereoDAO.getByPk(id);

	}
	public Aeroporto getAeroportoByPK(Object id) {

		return aeroportoDAO.getByPk(id);
	}

	public Volo getVoloByPK(Object id) {

		return voloDAO.getByPk(id);
	}

	public void removeVoloFromAeroporto(Object id) {


		Aeroporto aeroporto = aeroportoDAO.getByPk(id);
		ArrayList<Volo> voli = voloDAO.getAll();

		for( Volo v:voli) {
			if(v.getAeroportoArrivo().getAeroportoId()==aeroporto.getAeroportoId())
				voloDAO.delete(v);
		}

		for( Volo v:voli) {
			if(v.getAeroportoPartenza().getAeroportoId()==aeroporto.getAeroportoId())
				voloDAO.delete(v);
		}
	}

}