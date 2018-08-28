package directory.model;

import javax.persistence.*;

@Entity
@Table(name = "territories")
public class Territory {

    @Id
    @Column(name = "territory_id")
    private int id;

    @Column(name = "territory_name")
    private String name;

    @Column(name = "territory_code")
    private String code;

    @Column(name = "district_id")
    private int districtId;

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

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    @Override
    public String toString() {
        return "Territory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", districtId=" + districtId +
                '}';
    }
}
