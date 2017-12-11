package carconf.service.impl;

import carconf.HibernateUtil;
import carconf.entity.Model;
import carconf.service.ModelService;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;
import java.util.List;

public class ModelServiceImpl implements ModelService {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session session = null;

    public List<Model> getAllModels() {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Model> criteria = builder.createQuery(Model.class);
        Root<Model> root = criteria.from(Model.class);
        criteria.select(root);
        Query<Model> q = session.createQuery(criteria);
        List<Model> modelList = q.getResultList();
        session.getTransaction().commit();
        return modelList;
    }
}
