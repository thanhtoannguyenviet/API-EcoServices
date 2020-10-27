package Server.model.DB;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Order_", schema = "dbo", catalog = "JobService")
public class OrderEntity {
    private long idOrder;
    private Long idCustomer;
    private Long idCs;
    private String idTradeCode;
    private String typeTradeCode;
    private String status;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idOrder", nullable = false)
    public long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(long idOrder) {
        this.idOrder = idOrder;
    }

    @Basic
    @Column(name = "idCustomer", nullable = true)
    public Long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }

    @Basic
    @Column(name = "idCS", nullable = true)
    public Long getIdCs() {
        return idCs;
    }

    public void setIdCs(Long idCs) {
        this.idCs = idCs;
    }

    @Basic
    @Column(name = "idTradeCode", nullable = true, length = 200)
    public String getIdTradeCode() {
        return idTradeCode;
    }

    public void setIdTradeCode(String idTradeCode) {
        this.idTradeCode = idTradeCode;
    }

    @Basic
    @Column(name = "typeTradeCode", nullable = true, length = 50)
    public String getTypeTradeCode() {
        return typeTradeCode;
    }

    public void setTypeTradeCode(String typeTradeCode) {
        this.typeTradeCode = typeTradeCode;
    }

    @Basic
    @Column(name = "status", nullable = true,length = 10)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderEntity that = (OrderEntity) o;
        return idOrder == that.idOrder &&
                Objects.equals(idCustomer, that.idCustomer) &&
                Objects.equals(idCs, that.idCs) &&
                Objects.equals(idTradeCode, that.idTradeCode) &&
                Objects.equals(typeTradeCode, that.typeTradeCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOrder, idCustomer, idCs, idTradeCode, typeTradeCode);
    }
}
