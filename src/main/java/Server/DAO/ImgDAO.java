package Server.DAO;

import Server.model.DB.ImgEntity;
import Server.service.DBUtil;
import Server.service.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class ImgDAO {
    public ImgEntity save(ImgEntity entity){
        Session s = HibernateUtil.getSession(ImgEntity.class);
        return DBUtil.addData(entity,s);
    }
    public void delete(Long id){
        Session s = HibernateUtil.getSession(ImgEntity.class);
        DBUtil.deleteData(id,ImgEntity.class,s);
    }
    public ImgEntity getByID(Long id){
        Session s = HibernateUtil.getSession(ImgEntity.class);
        ImgEntity entity = DBUtil.getDataByID(id,ImgEntity.class,s);
        return entity;
    }
    public List<ImgEntity> getListById (String tableS,String idTables,String status) {
        Session s = HibernateUtil.getSession(ImgEntity.class);
        List<ImgEntity> ls = new ArrayList<>();
        ls = DBUtil.getListByCustomQuery("select * from img where table_ like '"+tableS+"' and idtable =" +idTables + " and status like '"+ status+"'",ImgEntity.class,s);
        return  ls;
    }
}
