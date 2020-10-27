package Server.model.DB;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Rate", schema = "dbo", catalog = "JobService")
public class RateEntity {
    private long idRate;
    private Long idCompany;
    private Integer ratenum;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRate", nullable = false)
    public long getIdRate() {
        return idRate;
    }

    public void setIdRate(long idRate) {
        this.idRate = idRate;
    }

    @Basic
    @Column(name = "idCompany", nullable = true)
    public Long getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Long idCompany) {
        this.idCompany = idCompany;
    }

    @Basic
    @Column(name = "ratenum", nullable = true)
    public Integer getRatenum() {
        return ratenum;
    }

    public void setRatenum(Integer ratenum) {
        this.ratenum = ratenum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RateEntity that = (RateEntity) o;
        return idRate == that.idRate &&
                Objects.equals(idCompany, that.idCompany) &&
                Objects.equals(ratenum, that.ratenum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRate, idCompany, ratenum);
    }
}
