package carconf.service.impl;

import carconf.HibernateUtil;
import carconf.entity.EquipmentLevel;
import carconf.service.EquipmentLevelService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class EquipmentLevelServiceImpl implements EquipmentLevelService {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session session = null;

    public List<EquipmentLevel> getEquipmentLevels() {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<EquipmentLevel> criteria = builder.createQuery(EquipmentLevel.class);
        Root<EquipmentLevel> root = criteria.from(EquipmentLevel.class);
        criteria.select(root);
        Query<EquipmentLevel> q = session.createQuery(criteria);
        List<EquipmentLevel> equipmentLevelList = q.getResultList();
        session.getTransaction().commit();
        return equipmentLevelList;
    }
}
