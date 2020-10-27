package Server.DAO;

import Server.model.DB.DetailOderEntity;
import Server.service.DBUtil;
import Server.service.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class DetailOrderDAO {

    public DetailOderEntity save(DetailOderEntity entity){
        Session s = HibernateUtil.getSession(DetailOderEntity.class);
        return DBUtil.addData(entity,s);
    }
    public void delete(Long id){
        Session s = HibernateUtil.getSession(DetailOderEntity.class);
        DBUtil.deleteData(id,DetailOderEntity.class,s);
    }
    public DetailOderEntity getByID(Long id){
        Session s = HibernateUtil.getSession(DetailOderEntity.class);
        DetailOderEntity entity = DBUtil.getDataByID(id,DetailOderEntity.class,s);
        return entity;
    }
    public List<DetailOderEntity> getListByIdOrder(int id) {
        Session s = HibernateUtil.getSession(DetailOderEntity.class);
        List<DetailOderEntity> ls = new ArrayList<>();
        ls = DBUtil.getListHasCondition("idOrder",id,DetailOderEntity.class,s);
        return  ls;
    }
}
