package carconf.service.impl;

import carconf.HibernateUtil;
import carconf.entity.EquipmentType;
import carconf.service.EquipmentTypeService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class EquipmentTypeServiceImpl implements EquipmentTypeService {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session session = null;

    public List<EquipmentType> getEquipmentTypes() {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<EquipmentType> criteria = builder.createQuery(EquipmentType.class);
        Root<EquipmentType> root = criteria.from(EquipmentType.class);
        criteria.select(root);
        Query<EquipmentType> q = session.createQuery(criteria);
        List<EquipmentType> equipmentTypeList = q.getResultList();
        session.getTransaction().commit();
        return equipmentTypeList;
    }
}
