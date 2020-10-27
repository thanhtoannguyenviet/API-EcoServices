package Server.controller;

import Server.Comom.MESSAGES;
import Server.DAO.ClientDAO;
import Server.DAO.CompanyServiceDAO;
import Server.DAO.OrderDAO;
import Server.model.DB.ClientEntity;
import Server.model.DB.CompanyServiceEntity;
import Server.model.DB.OrderEntity;
import Server.model.DTO.OrderDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/Order")
public class OrderController {
    OrderDAO orderDAO = new OrderDAO();
    @RequestMapping(value = "/Post/",
            method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> PostClient(@RequestBody OrderEntity entity){
        OrderEntity orderEntity = orderDAO.save(entity);
        return  new ResponseEntity(orderEntity, HttpStatus.OK);
    }
    @RequestMapping(value = "/Put/",
            method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> PutCient(@RequestBody OrderEntity entity){
        OrderEntity orderEntity = orderDAO.save(entity);
        return  new ResponseEntity(orderEntity, HttpStatus.OK);
    }
    @RequestMapping(value = "/Delete/{id}",
            method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<?> deleteClient( @PathVariable("id") Long id) {
        if (orderDAO.getByID(id) != null) {
            orderDAO.delete(id);
            return new ResponseEntity<>(MESSAGES.DELETEDCOMPLETED, HttpStatus.OK);
        } else return new ResponseEntity<>(MESSAGES.NOTFOUND, HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/GetDetail/{id}",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> getClient( @PathVariable("id") Long id) {
        OrderDTO orderDTO =  getOrderDTO(id);
        if (orderDTO != null)
            return new ResponseEntity<>(orderDTO, HttpStatus.OK);
        return new ResponseEntity<>(MESSAGES.NOTFOUND, HttpStatus.NOT_FOUND);
    }
    @RequestMapping(value = "/GetListClientByIdCs/{id}",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> getListClientByRle( @PathVariable("id") int id) {
        List<OrderDTO> lsOrderDTO = new ArrayList<>();
        List<OrderEntity> lsOrderEntity = orderDAO.getListByCS(id);
        if (lsOrderEntity != null && !lsOrderEntity.isEmpty()){
            for(OrderEntity item : lsOrderEntity){
                OrderDTO clientDTO =  getOrderDTO(item);
                lsOrderDTO.add(clientDTO);
            }
            return new ResponseEntity<>(lsOrderDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(MESSAGES.NOTFOUND, HttpStatus.NOT_FOUND);
    }

    public OrderDTO getOrderDTO(Long id){
        OrderDAO orderDAO = new OrderDAO();
        CompanyServiceDAO companyServiceDAO = new CompanyServiceDAO();
        ClientDAO clientDAO = new ClientDAO();
        OrderEntity orderEntity = orderDAO.getByID(id);
        CompanyServiceEntity companyServiceEntity = companyServiceDAO.getByID(orderEntity.getIdCs());
        ClientEntity clientEntity =clientDAO.getByID(orderEntity.getIdCustomer());
        OrderDTO orderDTO = new OrderDTO(orderEntity,companyServiceEntity,clientEntity);
        return orderDTO;
    }
    public OrderDTO getOrderDTO(OrderEntity orderEntity){
        CompanyServiceDAO companyServiceDAO = new CompanyServiceDAO();
        ClientDAO clientDAO = new ClientDAO();
        CompanyServiceEntity companyServiceEntity = companyServiceDAO.getByID(orderEntity.getIdCs());
        ClientEntity clientEntity =clientDAO.getByID(orderEntity.getIdCustomer());
        OrderDTO orderDTO = new OrderDTO(orderEntity,companyServiceEntity,clientEntity);
        return orderDTO;
    }
}
