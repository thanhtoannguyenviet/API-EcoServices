package Server.model.DTO;

import Server.model.DB.DetailOderEntity;
import Server.model.DB.OrderEntity;

public class DetailOrderDTO {
    DetailOderEntity detailOrderEntity;
    OrderEntity orderEntity;

    public DetailOrderDTO(){}
    public DetailOrderDTO(DetailOderEntity detailOrderEntity, OrderEntity orderEntity) {
        this.detailOrderEntity = detailOrderEntity;
        this.orderEntity = orderEntity;
    }

    public DetailOderEntity getDetailOrderEntity() {
        return detailOrderEntity;
    }

    public void setDetailOrderEntity(DetailOderEntity detailOrderEntity) {
        this.detailOrderEntity = detailOrderEntity;
    }

    public OrderEntity getOrderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }
}
