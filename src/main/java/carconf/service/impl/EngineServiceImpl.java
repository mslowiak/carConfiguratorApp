package carconf.service.impl;

import carconf.HibernateUtil;
import carconf.entity.Engine;
import carconf.service.EngineService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class EngineServiceImpl implements EngineService {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session session = null;

    public List<Engine> getEngines() {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Engine> criteria = builder.createQuery(Engine.class);
        Root<Engine> root = criteria.from(Engine.class);
        criteria.select(root);
        Query<Engine> q = session.createQuery(criteria);
        List<Engine> engineList = q.getResultList();
        session.getTransaction().commit();
        return engineList;
    }
}
