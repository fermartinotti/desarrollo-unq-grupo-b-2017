package morfiya.repositories;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import morfiya.domain.Menu;
import morfiya.domain.Pedido;
import morfiya.domain.Proveedor;

public class PedidoDAO extends HibernateGenericDAO<Pedido>{

	private static final long serialVersionUID = 1L;

	@Override
	public List<Pedido> getAllByPage(Integer pageSize, Integer pageNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<Pedido> getDomainClass() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Pedido> getCantDePedidosPorMenu(final Menu menu){
		HibernateTemplate template = getHibernateTemplate();	
		DetachedCriteria criteria = DetachedCriteria.forClass(Pedido.class);
		criteria.add(Restrictions.eq("menu", menu));

		return (List<Pedido>) (this.getHibernateTemplate().findByCriteria(criteria));
		
	}
}
