package Server.DAO;

import Server.model.DB.RateEntity;
import Server.service.DBUtil;
import Server.service.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class RateDAO {
    public RateEntity save(RateEntity entity){
        Session s = HibernateUtil.getSession(RateEntity.class);
        return DBUtil.addData(entity,s);
    }
    public void delete(Long id){
        Session s = HibernateUtil.getSession(RateEntity.class);
        DBUtil.deleteData(id,RateEntity.class,s);
    }
    public RateEntity getByID(Long id){
        Session s = HibernateUtil.getSession(RateEntity.class);
        RateEntity entity = DBUtil.getDataByID(id,RateEntity.class,s);
        return entity;
    }
    public List<RateEntity> getListByIdCustomer(int id) {
        Session s = HibernateUtil.getSession(RateEntity.class);
        List<RateEntity> ls = new ArrayList<>();
        ls = DBUtil.getListHasCondition("idCustomer",id,RateEntity.class,s);
        return  ls;
    }
}
