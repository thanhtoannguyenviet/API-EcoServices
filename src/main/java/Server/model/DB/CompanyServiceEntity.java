package Server.model.DB;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Company_Service", schema = "dbo", catalog = "JobService")
public class CompanyServiceEntity {
    private long idCs;
    private Long idCompany;
    private Long idService;
    private Long price;
    private String unit;
    private String description;
    private String status;
    private String nameCos;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCS", nullable = false)
    public long getIdCs() {
        return idCs;
    }

    public void setIdCs(long idCs) {
        this.idCs = idCs;
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
    @Column(name = "idService", nullable = true)
    public Long getIdService() {
        return idService;
    }

    public void setIdService(Long idService) {
        this.idService = idService;
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
    @Column(name = "unit", nullable = true, length = 50)
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Basic
    @Column(name = "description", nullable = true, length = -1)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "status", nullable = true,length = 10)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "nameCos", nullable = true, length = 50)
    public String getNameCos() {
        return nameCos;
    }

    public void setNameCos(String nameCos) {
        this.nameCos = nameCos;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyServiceEntity that = (CompanyServiceEntity) o;
        return idCs == that.idCs &&
                Objects.equals(idCompany, that.idCompany) &&
                Objects.equals(idService, that.idService) &&
                Objects.equals(price, that.price) &&
                Objects.equals(unit, that.unit) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCs, idCompany, idService, price, unit, description);
    }
}
