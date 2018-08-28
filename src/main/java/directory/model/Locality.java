package directory.model;

import javax.persistence.*;

@Entity
@Table(name = "localities")
public class Locality {

    @Id
    @Column(name = "locality_id")
    private int id;

    @Column(name = "locality_name")
    private String name;

    @Column(name = "locality_code")
    private String code;

    @Column(name = "territory_id")
    private int territoryId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getTerritoryId() {
        return territoryId;
    }

    public void setTerritoryId(int territoryId) {
        this.territoryId = territoryId;
    }

    @Override
    public String toString() {
        return "Locality{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", territoryId=" + territoryId +
                '}';
    }
}
