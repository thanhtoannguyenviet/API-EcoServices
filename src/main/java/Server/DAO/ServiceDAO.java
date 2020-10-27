package Server.DAO;

import Server.model.DB.ServiceEntity;
import Server.model.DTO.Criteria;
import Server.service.DBUtil;
import Server.service.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ServiceDAO {
    public ServiceEntity save(ServiceEntity entity){
        Session s = HibernateUtil.getSession(ServiceEntity.class);
        return DBUtil.addData(entity,s);
    }
    public void delete(Long id){
        Session s = HibernateUtil.getSession(ServiceEntity.class);
        DBUtil.deleteData(id,ServiceEntity.class,s);
    }
    public ServiceEntity getByID(Long id){
        Session s = HibernateUtil.getSession(ServiceEntity.class);
        ServiceEntity entity = DBUtil.getDataByID(id,ServiceEntity.class,s);
        return entity;
    }
    public List<ServiceEntity> getListByIdCompany(int id) {
        Session s = HibernateUtil.getSession(ServiceEntity.class);
        List<ServiceEntity> ls = new ArrayList<>();
        ls = DBUtil.getListHasCondition("idCompany",id,ServiceEntity.class,s);
        return  ls;
    }
    public List<ServiceEntity> getListByIdService(int id) {
        Session s = HibernateUtil.getSession(ServiceEntity.class);
        List<ServiceEntity> ls = new ArrayList<>();
        ls = DBUtil.getListHasCondition("idService",id,ServiceEntity.class,s);
        return  ls  ;
    }
    public List<ServiceEntity> loadDataPagination(Criteria criteria) {

        Session s = HibernateUtil.getSession(ServiceEntity.class);
        List<ServiceEntity> ls = DBUtil.loadDataPagination( s,criteria);
        return ls;
    }
    public List<ServiceEntity> loadDataPaginationHasCondition(Criteria criteria) {

        Session s = HibernateUtil.getSession(ServiceEntity.class);
        List<ServiceEntity> ls = DBUtil.getListHasCondition( "actived",1,criteria.getClazz(),s);
        return ls;
    }
    public List<ServiceEntity> getListByNameService(String nameService) {
        Session s = HibernateUtil.getSession(ServiceEntity.class);
        List<ServiceEntity> ls = DBUtil.getListByCustomQuery( "Select * from Service where nameservice = N'"+nameService+"'",ServiceEntity.class,s);
        return ls;
    }
}
