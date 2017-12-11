package carconf.service.impl;

import carconf.HibernateUtil;
import carconf.entity.Wheel;
import carconf.service.WheelService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class WheelServiceImpl implements WheelService {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session session = null;

    public List<Wheel> getWheels() {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Wheel> criteria = builder.createQuery(Wheel.class);
        Root<Wheel> root = criteria.from(Wheel.class);
        criteria.select(root);
        Query<Wheel> q = session.createQuery(criteria);
        List<Wheel> wheelList = q.getResultList();
        session.getTransaction().commit();
        return wheelList;
    }
}
