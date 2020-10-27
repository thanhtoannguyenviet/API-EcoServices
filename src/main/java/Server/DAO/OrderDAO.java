package Server.DAO;

import Server.model.DB.OrderEntity;
import Server.service.DBUtil;
import Server.service.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    public OrderEntity save(OrderEntity entity){
        Session s = HibernateUtil.getSession(OrderEntity.class);
        return DBUtil.addData(entity,s);
    }
    public void delete(Long id){
        Session s = HibernateUtil.getSession(OrderEntity.class);
        DBUtil.deleteData(id,OrderEntity.class,s);
    }
    public OrderEntity getByID(Long id){
        Session s = HibernateUtil.getSession(OrderEntity.class);
        OrderEntity entity = DBUtil.getDataByID(id,OrderEntity.class,s);
        return entity;
    }
    public List<OrderEntity> getListByIdCustomer(int id) {
        Session s = HibernateUtil.getSession(OrderEntity.class);
        List<OrderEntity> ls = new ArrayList<>();
        ls = DBUtil.getListHasCondition("idCustomer",id,OrderEntity.class,s);
        return  ls;
    }
    public List<OrderEntity> getListByCS(int id) {
        Session s = HibernateUtil.getSession(OrderEntity.class);
        List<OrderEntity> ls = new ArrayList<>();
        ls = DBUtil.getListHasCondition("idCS",id,OrderEntity.class,s);
        return  ls;
    }
//    public List<OrderEntity> getList(int id) {
//        List<OrderEntity> ls = new ArrayList<>();
//        ls = DBUtil.getListHasCondition("idCustomer",id,OrderEntity.class,s);
//        return  ls;
//    }
}
