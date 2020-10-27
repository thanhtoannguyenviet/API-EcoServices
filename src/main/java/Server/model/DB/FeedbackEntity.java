package Server.model.DB;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Feedback", schema = "dbo", catalog = "JobService")
public class FeedbackEntity {
    private long idFeedback;
    private Long idCustomer;
    private String detail;
    private Long rate;
    private Long idCos;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFeedback", nullable = false)
    public long getIdFeedback() {
        return idFeedback;
    }

    public void setIdFeedback(long idFeedback) {
        this.idFeedback = idFeedback;
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
    @Column(name = "detail", nullable = true, length = -1)
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Basic
    @Column(name = "rate", nullable = true)
    public Long getRate() {
        return rate;
    }


    public void setIdCos(Long idCos) {
        this.idCos = idCos;
    }

    @Basic
    @Column(name = "idCos", nullable = true)
    public Long getIdCos() {
        return idCos;
    }

    public void setRate(Long rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeedbackEntity that = (FeedbackEntity) o;
        return idFeedback == that.idFeedback &&
                Objects.equals(idCustomer, that.idCustomer) &&
                Objects.equals(detail, that.detail) &&
                Objects.equals(rate, that.rate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFeedback, idCustomer, detail, rate);
    }
}
