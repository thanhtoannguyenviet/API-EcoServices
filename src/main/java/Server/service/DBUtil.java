package Server.service;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;
import Server.model.DTO.Criteria;
public class DBUtil {
    public static <T> List<T> loadAllData(Class<T> type, Session session) {
        session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(type);
        criteria.from(type);
        List<T> data = session.createQuery(criteria).getResultList();
        session.getTransaction().commit();
        return data;
    }

    public static <T> T addData(T newItem, Session session) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(newItem);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            ex.printStackTrace();
        } finally {
            session.close();
            return newItem;
        }
    }

    public static <T, K> void deleteData(T primaryID, Class<K> cl, Session session) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            K item = session.load(cl, (Serializable)primaryID);
            if (item != null) {
                session.delete(item);
            }
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            ex.printStackTrace();
        }finally {
            session.close();
        }
    }

    public static <T, K> K getDataByID(T primaryID, Class<K> cl, Session session) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            K item = (K) session.get(cl, (Serializable)primaryID);
            tx.commit();
            return item;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            ex.printStackTrace();
            return null;
        }
        finally {
            session.close();
        }
    }
    public static <T> List<T> getListHasCondition(String conditionColumn,int condition,Class<T> type,Session session){
        Transaction tx = null;
        try {
            tx =  session.beginTransaction();
            org.hibernate.Criteria criteria = session.createCriteria(type).add(Restrictions.eq(conditionColumn,condition));
            tx.commit();
            return  criteria.list() ;
        }catch (HibernateException ex) {
            return null;
        }
        finally {
            session.close();
        }
    }
    public static <T> List<T> getListByCustomQuery(String customQuery,Class <T> type, Session session){
        Transaction tx= null;
        try{
            tx=session.beginTransaction();
            SQLQuery q = session.createSQLQuery(customQuery);
            q.addEntity(type);
            tx.commit();
            return q.list();
        }catch(HibernateException ex){
            return null;
        }
        finally {
            session.close();
        }
    }
    public static <T> List<T> loadDataPagination(Session session,Criteria criter ) {
        try{
            session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            int itemStart = 0;
            int itemEnd = 2;
            if (criter != null) {
                itemStart = criter.getCurrentPage() * criter.getItemPerPage();
                itemEnd = itemStart + criter.getItemPerPage();
            }
            CriteriaQuery<T> criteriaQuery = builder.createQuery(criter.getClazz());
            Root<T> from = criteriaQuery.from(criter.getClazz());
            CriteriaQuery<T> select = criteriaQuery.select(from);
            TypedQuery<T> typedQuery = session.createQuery(select);
            typedQuery.setFirstResult(itemStart);
            typedQuery.setMaxResults(itemEnd);
            List<T> data = typedQuery.getResultList();
            // session.getTransaction().commit();
            return typedQuery.getResultList();
        }catch (Exception ex){
            ex.getMessage();
            return null;
        }finally {
            session.close();
        }
    }

}
