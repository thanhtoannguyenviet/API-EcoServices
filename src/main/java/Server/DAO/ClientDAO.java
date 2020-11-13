package Server.DAO;

import Server.Comom.CUSTOM_QUERY;
import Server.model.DB.ClientEntity;
import Server.service.DBUtil;
import Server.service.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClientDAO {
    public ClientEntity save(ClientEntity entity){
        Session s = HibernateUtil.getSession(ClientEntity.class);
        return DBUtil.addData(entity,s);
    }
    public void delete(Long id){
        Session s = HibernateUtil.getSession(ClientEntity.class);
        DBUtil.deleteData(id,ClientEntity.class,s);
    }
    public ClientEntity getByID(Long id){
        Session s = HibernateUtil.getSession(ClientEntity.class);
        ClientEntity entity = DBUtil.getDataByID(id,ClientEntity.class,s);
        return entity;
    }
    public List<ClientEntity> getListByID(int id) {
        Session s = HibernateUtil.getSession(ClientEntity.class);
        List<ClientEntity> lsClient = new ArrayList<>();
        lsClient = DBUtil.getListHasCondition("role",id,ClientEntity.class,s);
        return  lsClient;
    }
    public List<ClientEntity> getListByFullname(String fullname) {
        Session s = HibernateUtil.getSession(ClientEntity.class);
        List<ClientEntity> lsClient = new ArrayList<>();
        lsClient = DBUtil.getListByCustomQuery(CUSTOM_QUERY.getListByFullname(fullname),ClientEntity.class,s);
        return  lsClient;
    }
    public ClientEntity getClientBySecretKey(String fullname) {
        Session s = HibernateUtil.getSession(ClientEntity.class);
        List<ClientEntity> lsClient = DBUtil.getListByCustomQuery(CUSTOM_QUERY.getClientBySecretKey(fullname),ClientEntity.class,s);
        if(lsClient.size()>0){
            ClientEntity clientEntity = new ClientEntity();
            clientEntity = lsClient.get(0);
            return clientEntity;
       }
        return  null;
    }
    public ClientEntity loginClient(String username, String password){
        Session s = HibernateUtil.getSession(ClientEntity.class);
        List<ClientEntity> lsClient = DBUtil.getListByCustomQuery(CUSTOM_QUERY.loginClient(username, password),ClientEntity.class,s);
        if(lsClient.size()>0){
            ClientEntity clientEntity = new ClientEntity();
            clientEntity = lsClient.get(0);
            return clientEntity;
        }
        return  null;
    }
}
