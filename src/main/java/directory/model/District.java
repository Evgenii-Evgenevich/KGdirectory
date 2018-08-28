package directory.model;

import javax.persistence.*;

@Entity
@Table(name = "districts")
public class District {

    @Id
    @Column(name = "district_id")
    private int id;

    @Column(name = "district_name")
    private String name;

    @Column(name = "district_code")
    private String code;

    @Column(name = "region_id")
    private int regionId;

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

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    @Override
    public String toString() {
        return "District{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", regionId=" + regionId +
                '}';
    }
}
