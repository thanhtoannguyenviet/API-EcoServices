package Server.DAO;

import Server.model.DB.FeedbackEntity;
import Server.service.DBUtil;
import Server.service.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class FeedbackDAO {
    public FeedbackEntity save(FeedbackEntity entity){

        Session s = HibernateUtil.getSession(FeedbackEntity.class);
        return DBUtil.addData(entity,s);
    }
    public void delete(Long id){
        Session s = HibernateUtil.getSession(FeedbackEntity.class);
        DBUtil.deleteData(id,FeedbackEntity.class,s);
    }
    public FeedbackEntity getByID(Long id){
        Session s = HibernateUtil.getSession(FeedbackEntity.class);
        FeedbackEntity entity = DBUtil.getDataByID(id,FeedbackEntity.class,s);
        return entity;
    }
    public List<FeedbackEntity> getListByIdCustomer(int id) {
        Session s = HibernateUtil.getSession(FeedbackEntity.class);
        List<FeedbackEntity> ls = new ArrayList<>();
        ls = DBUtil.getListHasCondition("idCustomer",id,FeedbackEntity.class,s);
        return  ls;
    }
    public List<FeedbackEntity> getListByIdCos(int id) {
        Session s = HibernateUtil.getSession(FeedbackEntity.class);
        List<FeedbackEntity> ls = new ArrayList<>();
        ls = DBUtil.getListHasCondition("idCos",id,FeedbackEntity.class,s);
        return  ls;
    }
}
