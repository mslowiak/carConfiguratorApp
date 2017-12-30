package carconf.service.impl;

import carconf.HibernateUtil;
import carconf.entity.EquipmentElement;
import carconf.entity.EquipmentType;
import carconf.service.EquipmentElementService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class EquipmentElementServiceImpl implements EquipmentElementService {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session session = null;

    public List<EquipmentElement> getEquipmentElements() {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<EquipmentElement> criteria = builder.createQuery(EquipmentElement.class);
        Root<EquipmentElement> root = criteria.from(EquipmentElement.class);
        criteria.select(root);
        Query<EquipmentElement> q = session.createQuery(criteria);
        List<EquipmentElement> equipmentElementList = q.getResultList();
        session.getTransaction().commit();
        return equipmentElementList;
    }

    @Override
    public List<EquipmentElement> getEquipmentElementsByLevelId(int levelId) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<EquipmentElement> criteria = builder.createQuery(EquipmentElement.class);
        Root<EquipmentElement> root = criteria.from(EquipmentElement.class);
        criteria.select(root).where(builder.equal(root.get("equipmentLevel"), levelId));
        Query<EquipmentElement> q = session.createQuery(criteria);
        List<EquipmentElement> equipmentElementList = q.getResultList();
        session.getTransaction().commit();
        return equipmentElementList;
    }
}
