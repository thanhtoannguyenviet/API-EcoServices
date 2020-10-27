package Server.model.DTO;

import Server.model.DB.ClientEntity;
import Server.model.DB.CompanyServiceEntity;
import Server.model.DB.ImgEntity;
import Server.model.DB.ServiceEntity;

public class ServiceDTO {
    private ServiceEntity serviceEntity;
    private ClientEntity clientEntity;
    private CompanyServiceEntity companyServiceEntity;
    private ImgEntity imgEntity;
    public ServiceEntity getServiceEntity() {
        return serviceEntity;
    }

    public void setServiceEntity(ServiceEntity serviceEntity) {
        this.serviceEntity = serviceEntity;
    }

    public ClientEntity getClientEntity() {
        return clientEntity;
    }

    public void setClientEntity(ClientEntity clientEntity) {
        this.clientEntity = clientEntity;
    }

    public CompanyServiceEntity getCompanyServiceEntity() {
        return companyServiceEntity;
    }

    public void setCompanyServiceEntity(CompanyServiceEntity companyServiceEntity) {
        this.companyServiceEntity = companyServiceEntity;
    }


    public ImgEntity getImgEntity() {
        return imgEntity;
    }

    public void setImgEntity(ImgEntity imgEntity) {
        this.imgEntity = imgEntity;
    }

    public ServiceDTO(ServiceEntity serviceEntity, ClientEntity clientEntity, CompanyServiceEntity companyServiceEntity, ImgEntity imgEntity) {
        this.serviceEntity = serviceEntity;
        this.clientEntity = clientEntity;
        this.companyServiceEntity = companyServiceEntity;
        this.imgEntity = imgEntity;
    }

    public ServiceDTO(){}
}
