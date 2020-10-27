package Server.model.DB;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Service_", schema = "dbo", catalog = "JobService")
public class ServiceEntity {
    private long idService;
    private String nameservice;
    private String description;
    private Integer actived;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idService", nullable = false)
    public long getIdService() {
        return idService;
    }

    public void setIdService(long idService) {
        this.idService = idService;
    }

    @Basic
    @Column(name = "nameservice", nullable = true, length = 50)
    public String getNameservice() {
        return nameservice;
    }

    public void setNameservice(String nameservice) {
        this.nameservice = nameservice;
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
    @Column(name = "actived", nullable = true)
    public Integer getActived() {
        return actived;
    }

    public void setActived(Integer actived) {
        this.actived = actived;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceEntity that = (ServiceEntity) o;
        return idService == that.idService &&
                Objects.equals(nameservice, that.nameservice) &&
                Objects.equals(description, that.description) &&
                Objects.equals(actived, that.actived);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idService, nameservice, description, actived);
    }
}
