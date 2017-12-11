package carconf.service.impl;

import carconf.HibernateUtil;
import carconf.entity.ConfigurationsLevelEngine;
import carconf.service.ConfigurationsLevelEngineService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ConfigurationsLevelEngineServiceImpl implements ConfigurationsLevelEngineService {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session session = null;

    public List<ConfigurationsLevelEngine> getConfigurations() {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<ConfigurationsLevelEngine> criteria = builder.createQuery(ConfigurationsLevelEngine.class);
        Root<ConfigurationsLevelEngine> root = criteria.from(ConfigurationsLevelEngine.class);
        criteria.select(root);
        Query<ConfigurationsLevelEngine> q = session.createQuery(criteria);
        List<ConfigurationsLevelEngine> configurationsLevelEngineList = q.getResultList();
        session.getTransaction().commit();
        return configurationsLevelEngineList;
    }
}
