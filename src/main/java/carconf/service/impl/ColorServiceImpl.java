package carconf.service.impl;

import carconf.HibernateUtil;
import carconf.entity.Color;
import carconf.entity.Model;
import carconf.service.ColorService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ColorServiceImpl implements ColorService {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session session = null;

    public List<Color> getColors() {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Color> criteria = builder.createQuery(Color.class);
        Root<Color> root = criteria.from(Color.class);
        criteria.select(root);
        Query<Color> q = session.createQuery(criteria);
        List<Color> colorList = q.getResultList();
        session.getTransaction().commit();
        return colorList;
    }
}
