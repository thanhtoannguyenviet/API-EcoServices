package Server.controller;

import Server.Comom.MESSAGES;
import Server.DAO.CompanyServiceDAO;
import Server.model.DB.CompanyServiceEntity;
import Server.model.DTO.Criteria;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/CompanyService")
public class CompanyServiceController {
    CompanyServiceDAO companyServiceDAO = new CompanyServiceDAO();
    @RequestMapping(value = "/Post/",
            method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> PostCompanySerivec(@RequestBody CompanyServiceEntity entity){
        CompanyServiceEntity companyServiceEntity = companyServiceDAO.save(entity);
        return  new ResponseEntity(companyServiceEntity, HttpStatus.OK);
    }
    @RequestMapping(value = "/Delete/{id}",
            method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> DeleteCompanySerivec(@PathVariable("id") Long id){
        if(companyServiceDAO.getByID(id) != null){
            companyServiceDAO.delete(id);
            return new ResponseEntity<>(MESSAGES.DELETEDCOMPLETED,HttpStatus.OK);
        }
        return  new ResponseEntity(MESSAGES.NOTFOUND, HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/UpdateStatus/{id}/{status}",
            method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> DeleteCompanySerivec(@PathVariable("id") Long id,@PathVariable("status") String status){
        CompanyServiceEntity companyServiceEntity = companyServiceDAO.getByID(id);
        if(companyServiceEntity != null){
            companyServiceEntity.setStatus(status);
            companyServiceDAO.save(companyServiceEntity);
            return new ResponseEntity<>(MESSAGES.UPDATECOMPLETED,HttpStatus.OK);
        }
        return  new ResponseEntity(MESSAGES.NOTFOUND, HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/GetAll{item}/{page}",
            method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> GetAllCompanySerivec(@PathVariable("page") int page,@PathVariable("page") int item){
        Criteria criteria = new Criteria();
        criteria.setClazz(CompanyServiceEntity.class);
        criteria.setCurrentPage(page);
        criteria.setItemPerPage(item);
        List<CompanyServiceEntity> ls =companyServiceDAO.loadDataPagination(criteria);
        if(ls!=null){
            return new ResponseEntity<>(ls,HttpStatus.OK);
        }
        return  new ResponseEntity(MESSAGES.NOTFOUND, HttpStatus.NOT_FOUND);
    }
}
