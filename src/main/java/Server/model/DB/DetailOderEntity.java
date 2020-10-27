package Server.model.DB;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "DetailOder", schema = "dbo", catalog = "JobService")
public class DetailOderEntity {
    private long idDetailOder;
    private Long idOrder;
    private Long price;
    private String weekly;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDetailOder", nullable = false)
    public long getIdDetailOder() {
        return idDetailOder;
    }

    public void setIdDetailOder(long idDetailOder) {
        this.idDetailOder = idDetailOder;
    }

    @Basic
    @Column(name = "idOrder", nullable = true)
    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }

    @Basic
    @Column(name = "price", nullable = true)
    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Basic
    @Column(name = "weekly", nullable = true, length = 50)
    public String getWeekly() {
        return weekly;
    }

    public void setWeekly(String weekly) {
        this.weekly = weekly;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetailOderEntity that = (DetailOderEntity) o;
        return idDetailOder == that.idDetailOder &&
                Objects.equals(idOrder, that.idOrder) &&
                Objects.equals(price, that.price) &&
                Objects.equals(weekly, that.weekly);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDetailOder, idOrder, price, weekly);
    }
}
