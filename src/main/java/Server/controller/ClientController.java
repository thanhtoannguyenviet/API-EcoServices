package Server.controller;

import Server.Comom.MESSAGES;
import Server.DAO.ClientDAO;
import Server.DAO.ImgDAO;
import Server.DAO.RoleDAO;
import Server.model.DB.ClientEntity;
import Server.model.DB.ImgEntity;
import Server.model.DB.RoleEntity;
import Server.model.DTO.ClientDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/Client")
public class ClientController {
    ClientDAO clientDAO = new ClientDAO();
    @RequestMapping(value = "/Post/",
            method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> PostClient(@RequestBody ClientEntity entity){
        ClientEntity clientEntity = clientDAO.save(entity);
        return  new ResponseEntity(clientEntity, HttpStatus.OK);
    }
    @RequestMapping(value = "/Put/",
            method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> PutCient(@RequestBody ClientEntity entity){
        ClientEntity clientEntity = clientDAO.save(entity);
        return  new ResponseEntity(clientEntity, HttpStatus.OK);
    }
    @RequestMapping(value = "/Delete/{id}",
            method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<?> deleteClient( @PathVariable("id") Long id) {
        if (clientDAO.getByID(id) != null) {
            clientDAO.delete(id);
            return new ResponseEntity<>(MESSAGES.DELETEDCOMPLETED, HttpStatus.OK);
        } else return new ResponseEntity<>(MESSAGES.NOTFOUND, HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/GetDetail/{id}",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> getClient( @PathVariable("id") Long id) {
        ClientDTO clientDTO =  getClientDTO(id);
        if (clientDTO != null)
            return new ResponseEntity<>(clientDTO, HttpStatus.OK);
        return new ResponseEntity<>(MESSAGES.NOTFOUND, HttpStatus.NOT_FOUND);
    }
    @RequestMapping(value = "/GetListClientByRole/{id}",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> getListClientByRle( @PathVariable("id") int id) {
        List<ClientDTO> lsClientDTO = new ArrayList<>();
        List<ClientEntity> lsClientEntity = clientDAO.getListByID(id);
        if (lsClientEntity != null && !lsClientEntity.isEmpty()){
            for(ClientEntity item : lsClientEntity){
                ClientDTO clientDTO =  getClientDTO(item);
                lsClientDTO.add(clientDTO);
            }
            return new ResponseEntity<>(lsClientDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(MESSAGES.NOTFOUND, HttpStatus.NOT_FOUND);
    }
    @RequestMapping(value = "/Search/q={searchString}",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> getListClientByFullname( @PathVariable("searchString") String searchString) {
        List<ClientDTO> lsClientDTO = new ArrayList<>();
        List<ClientEntity> lsClientEntity = clientDAO.getListByFullname(searchString);
        if (lsClientEntity != null && !lsClientEntity.isEmpty()){
            for(ClientEntity item : lsClientEntity){
                ClientDTO clientDTO =  getClientDTO(item);
                lsClientDTO.add(clientDTO);
            }
            return new ResponseEntity<>(lsClientDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(MESSAGES.NOTFOUND, HttpStatus.NOT_FOUND);
    }
    @RequestMapping(value = "/ForgotPassword/secret_key={secret_key}",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> forgotPassword( @PathVariable("secret_key") String secretKey,@RequestBody ClientEntity entity) {
        ClientEntity clientEntity = clientDAO.getClientBySecretKey(secretKey);
        if (clientEntity != null){
            clientEntity.setPassword(entity.getPassword());
            clientDAO.save(clientEntity);
            return new ResponseEntity<>(clientEntity, HttpStatus.OK);
        }
        return new ResponseEntity<>(MESSAGES.NOTFOUND, HttpStatus.NOT_FOUND);
    }

    private ClientDTO getClientDTO(Long id){
        ClientEntity clientEntity = clientDAO.getByID(id);
        if(clientEntity!=null){
            RoleDAO roleDAO = new RoleDAO();
            RoleEntity roleEntity = roleDAO.getByID(clientEntity.getRole());
            ImgDAO imgDAO = new ImgDAO();
            List<ImgEntity> lsImg = imgDAO.getListById("client",id+"","true");
            ImgEntity imgEntity = new ImgEntity();
            if(lsImg!=null &&  lsImg.size()>0){
                imgEntity = lsImg.get(0);
            }
            ClientDTO clientDTO = new ClientDTO(roleEntity,clientEntity,imgEntity);
            return clientDTO;
        }
        return null;
    }
    private ClientDTO getClientDTO(ClientEntity clientEntity){
            RoleDAO roleDAO = new RoleDAO();
            RoleEntity roleEntity = roleDAO.getByID(clientEntity.getRole());
        ImgDAO imgDAO = new ImgDAO();
        List<ImgEntity> lsImg = imgDAO.getListById("client",clientEntity.getIdClient()+"","true");

        ImgEntity imgEntity = new ImgEntity();
        if(lsImg!=null &&  lsImg.size()>0){
            imgEntity = lsImg.get(0);
        }
            ClientDTO clientDTO = new ClientDTO(roleEntity,clientEntity,imgEntity);
            return clientDTO;
    }
}
