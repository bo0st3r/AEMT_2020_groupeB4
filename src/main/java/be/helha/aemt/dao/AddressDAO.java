package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.helha.aemt.entity.Address;
import be.helha.aemt.helper.Config;

@NamedQuery(name="Address.queryAll", query="SELECT a FROM Adress a") 
@NamedQuery(name="Address.queryById", query="SELECT a FROM Adress a WHERE a.id = :id")
@NamedQuery(name="Address.queryEquals", query="SELECT a.id FROM Adress a WHERE a.city = :city AND a.street = :street AND a.number = :number AND a.postCode = :postCode")
@NamedQuery(name="Address.queryIdFromEquals", query="SELECT a FROM Adress a WHERE a.city = :city AND a.street = :street AND a.number = :number AND a.postCode = :postCode")

@Stateless
@LocalBean
public class AddressDAO {
	@PersistenceContext(unitName = Config.UNIT_NAME)
	private EntityManager em;
	
	public List<Address> queryAll(){
		return em.createNamedQuery("Address.queryAll").getResultList();
	}
	
	public Address queryById(int id){
		Query query = em.createNamedQuery("Adress.queryById");
		query.setParameter("id", id);
		List<Address> results = query.getResultList();
		if(results.size() > 0)
		{
			return results.get(0);
		}else {
			return null;
		}
	}
	
	public Address queryEquals(Address address) {
		Query query = em.createNamedQuery("Address.queryEquals");
		query.setParameter("city", address.getCity());
		query.setParameter("street", address.getStreet());
		query.setParameter("number", address.getNumber());
		query.setParameter("postCode", address.getPostCode());
		List<Address> results = query.getResultList();
		if(results.size() > 0)
		{
			return results.get(0);
		}else {
			return null;
		}
	}
	
	public int queryIdFromEquals(Address address) {
		Query query = em.createNamedQuery("Address.queryIdFromEquals");
		query.setParameter("city", address.getCity());
		query.setParameter("street", address.getStreet());
		query.setParameter("number", address.getNumber());
		query.setParameter("postCode", address.getPostCode());
		List<Integer> results = query.getResultList();
		if(results.size() > 0)
		{
			return results.get(0);
		}
		return -1;
	}
	
	public Address post(Address address) {
		address.setId(queryIdFromEquals(address));
		
		em.persist(address);
		
		return address;
	}
}
