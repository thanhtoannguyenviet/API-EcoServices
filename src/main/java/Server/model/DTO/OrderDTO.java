package Server.model.DTO;

import Server.model.DB.ClientEntity;
import Server.model.DB.CompanyServiceEntity;
import Server.model.DB.OrderEntity;

public class OrderDTO {
    private OrderEntity orderEntity;
    private CompanyServiceEntity companyServiceEntity;
    private ClientEntity clientEntity;

    public OrderDTO(){}

    public OrderDTO(OrderEntity orderEntity, CompanyServiceEntity companyServiceEntity, ClientEntity clientEntity) {
        this.orderEntity = orderEntity;
        this.companyServiceEntity = companyServiceEntity;
        this.clientEntity = clientEntity;
    }

    public OrderEntity getOrderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }

    public CompanyServiceEntity getCompanyServiceEntity() {
        return companyServiceEntity;
    }

    public void setCompanyServiceEntity(CompanyServiceEntity companyServiceEntity) {
        this.companyServiceEntity = companyServiceEntity;
    }

    public ClientEntity getClientEntity() {
        return clientEntity;
    }

    public void setClientEntity(ClientEntity clientEntity) {
        this.clientEntity = clientEntity;
    }
}
