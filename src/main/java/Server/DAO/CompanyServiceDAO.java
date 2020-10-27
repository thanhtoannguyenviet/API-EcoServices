package Server.DAO;

import Server.model.DB.CompanyServiceEntity;
import Server.model.DTO.Criteria;
import Server.service.DBUtil;
import Server.service.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class CompanyServiceDAO {
    public CompanyServiceEntity save(CompanyServiceEntity entity){
        Session s = HibernateUtil.getSession(CompanyServiceEntity.class);
        return DBUtil.addData(entity,s);
    }
    public void delete(Long id){
    Session s = HibernateUtil.getSession(CompanyServiceEntity.class);
        DBUtil.deleteData(id,CompanyServiceEntity.class,s);
    }
    public CompanyServiceEntity getByID(Long id){
        Session s = HibernateUtil.getSession(CompanyServiceEntity.class);
        CompanyServiceEntity entity = DBUtil.getDataByID(id,CompanyServiceEntity.class,s);
        return entity;
    }
    public List<CompanyServiceEntity> getListByIdCompany(int id) {
        Session s = HibernateUtil.getSession(CompanyServiceEntity.class);
        List<CompanyServiceEntity> ls = new ArrayList<>();
        ls = DBUtil.getListHasCondition("idCompany",id,CompanyServiceEntity.class,s);
        return  ls;
    }
    public List<CompanyServiceEntity> getListByIdService(int id) {
        Session s = HibernateUtil.getSession(CompanyServiceEntity.class);
        List<CompanyServiceEntity> ls = new ArrayList<>();
        ls = DBUtil.getListHasCondition("idService",id,CompanyServiceEntity.class,s);
        return  ls  ;
    }
    public List<CompanyServiceEntity> loadDataPagination(Criteria criteria) {
        Session s = HibernateUtil.getSession(CompanyServiceEntity.class);
        List<CompanyServiceEntity> ls = DBUtil.loadDataPagination( s,criteria);
        return ls;
    }
}
