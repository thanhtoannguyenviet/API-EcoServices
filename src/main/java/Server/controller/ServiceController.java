package Server.controller;

import Server.Comom.MESSAGES;
import Server.DAO.ServiceDAO;
import Server.model.DB.CompanyServiceEntity;
import Server.model.DB.ServiceEntity;
import Server.model.DTO.Criteria;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Service")
public class ServiceController {
    ServiceDAO serviceDAO = new ServiceDAO();
    @RequestMapping(value = "/Post/",
            method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> PostCompanySerivec(@RequestBody ServiceEntity entity){
        ServiceEntity serviceEntity = serviceDAO.save(entity);
        return  new ResponseEntity(serviceEntity, HttpStatus.OK);
    }
    @RequestMapping(value = "/Delete/{id}",
            method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> DeleteCompanySerivec(@PathVariable("id") Long id){
        if(serviceDAO.getByID(id) != null){
            serviceDAO.delete(id);
            return new ResponseEntity<>(MESSAGES.DELETEDCOMPLETED,HttpStatus.OK);
        }
        return  new ResponseEntity(MESSAGES.NOTFOUND, HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/UpdateStatus/{id}/{status}",
            method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> UpdateStatus(@PathVariable("id") Long id,@PathVariable("status") int status){
        ServiceEntity serviceEntity = serviceDAO.getByID(id);
        if(serviceEntity != null){
            serviceEntity.setActived(status);
            serviceDAO.save(serviceEntity);
            return new ResponseEntity<>(MESSAGES.UPDATECOMPLETED,HttpStatus.OK);
        }
        return  new ResponseEntity(MESSAGES.NOTFOUND, HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "Admin/GetAll{item}/{page}",
            method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> GetAllCompanySerivec(@PathVariable("page") int page,@PathVariable("item") int item){
        Criteria criteria = new Criteria();
        criteria.setClazz(ServiceEntity.class);
        criteria.setCurrentPage(page);
        criteria.setItemPerPage(item);
        List<ServiceEntity> ls =serviceDAO.loadDataPagination(criteria);
        if(ls!=null){
            return new ResponseEntity<>(ls,HttpStatus.OK);
        }
        return  new ResponseEntity(MESSAGES.NOTFOUND, HttpStatus.NOT_FOUND);
    }
    @RequestMapping(value = "Client/GetAll{item}/{page}",
            method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> GetAllService(@PathVariable("page") int page,@PathVariable("item") int item){
        Criteria criteria = new Criteria();
        criteria.setClazz(ServiceEntity.class);
        criteria.setCurrentPage(page);
        criteria.setItemPerPage(item);
        List<ServiceEntity> ls =serviceDAO.loadDataPaginationHasCondition(criteria);
        if(ls!=null){
            return new ResponseEntity<>(ls,HttpStatus.OK);
        }
        return  new ResponseEntity(MESSAGES.NOTFOUND, HttpStatus.NOT_FOUND);
    }
}
