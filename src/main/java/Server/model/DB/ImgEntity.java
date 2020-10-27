package Server.model.DB;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Img", schema = "dbo", catalog = "JobService")
public class ImgEntity {
    private long idImg;
    private String link;
    private Long idtable;
    private String table;
    private String status;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idImg", nullable = false)
    public long getIdImg() {
        return idImg;
    }

    public void setIdImg(long idImg) {
        this.idImg = idImg;
    }

    @Basic
    @Column(name = "link", nullable = true, length = -1)
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Basic
    @Column(name = "idtable", nullable = true)
    public Long getIdtable() {
        return idtable;
    }

    public void setIdtable(Long idtable) {
        this.idtable = idtable;
    }

    @Basic
    @Column(name = "table_", nullable = true, length = 10)
    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    @Basic
    @Column(name = "status", nullable = true, length = 10)
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
        ImgEntity imgEntity = (ImgEntity) o;
        return idImg == imgEntity.idImg &&
                Objects.equals(link, imgEntity.link) &&
                Objects.equals(idtable, imgEntity.idtable) &&
                Objects.equals(table, imgEntity.table) &&
                Objects.equals(status, imgEntity.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idImg, link, idtable, table, status);
    }
}
