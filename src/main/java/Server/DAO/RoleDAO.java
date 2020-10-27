package Server.DAO;

import Server.model.DB.ClientEntity;
import Server.model.DB.RoleEntity;
import Server.service.DBUtil;
import Server.service.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDAO {
    Session s = HibernateUtil.getSession(RoleEntity.class);
    public RoleEntity getByID(int id){
        Session s = HibernateUtil.getSession(RoleEntity.class);
        RoleEntity entity = DBUtil.getDataByID(id, RoleEntity.class,s);
        return entity;
    }
    public List<RoleEntity> getAll(){
        Session s = HibernateUtil.getSession(RoleEntity.class);
        List<RoleEntity> lsEntity = DBUtil.loadAllData(RoleEntity.class,s);
        return lsEntity;
    }
}
