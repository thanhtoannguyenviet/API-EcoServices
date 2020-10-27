package Server.model.DTO;

import Server.model.DB.ClientEntity;
import Server.model.DB.ImgEntity;
import Server.model.DB.RoleEntity;

public class ClientDTO {
    private RoleEntity roleEntity;
    private ClientEntity clientEntity;
    private ImgEntity imgEntity;

    public ImgEntity getImgEntity() {
        return imgEntity;
    }

    public void setImgEntity(ImgEntity imgEntity) {
        this.imgEntity = imgEntity;
    }

    public RoleEntity getRoleEntity() {
        return roleEntity;
    }

    public void setRoleEntity(RoleEntity roleEntity) {
        this.roleEntity = roleEntity;
    }

    public ClientEntity getClientEntity() {
        return clientEntity;
    }

    public void setClientEntity(ClientEntity clientEntity) {
        this.clientEntity = clientEntity;
    }
    public ClientDTO(){}

    public ClientDTO(RoleEntity roleEntity, ClientEntity clientEntity,ImgEntity imgEntity) {
        this.roleEntity = roleEntity;
        this.clientEntity = clientEntity;
        this.imgEntity = imgEntity;
    }
}
