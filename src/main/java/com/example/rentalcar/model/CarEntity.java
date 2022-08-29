package com.example.rentalcar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import groovy.transform.EqualsAndHashCode;
import groovy.transform.ToString;

import javax.persistence.*;

@Entity
@Table(name = "car", schema = "dbo", catalog = "carrental")
public class CarEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "carnumber")
    private String carnumber;
    @Basic
    @Column(name = "priceperday")
    private Integer priceperday;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "company_id")
    private Long companyId;
    @Basic
    @Column(name = "seatcapacity")
    private Integer seatcapacity;
    @Basic
    @Column(name = "fuletype")
    private String fuletype;
    @Basic
    @Column(name = "modelyear")
    private Integer modelyear;
    @Basic
    @Column(name = "thumbnail")
    private String thumbnail;
    @Basic
    @Column(name = "status")
    private Integer status;

    public CarEntity() {
    }

    public CarEntity(long id, String name, String carnumber, Integer priceperday, String description, Long companyId, Integer seatcapacity, String fuletype, Integer modelyear, String thumbnail, Integer status) {
        this.id = id;
        this.name = name;
        this.carnumber = carnumber;
        this.priceperday = priceperday;
        this.description = description;
        this.companyId = companyId;
        this.seatcapacity = seatcapacity;
        this.fuletype = fuletype;
        this.modelyear = modelyear;
        this.thumbnail = thumbnail;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCarnumber() {
        return carnumber;
    }

    public void setCarnumber(String carnumber) {
        this.carnumber = carnumber;
    }

    public Integer getPriceperday() {
        return priceperday;
    }

    public void setPriceperday(Integer priceperday) {
        this.priceperday = priceperday;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Integer getSeatcapacity() {
        return seatcapacity;
    }

    public void setSeatcapacity(Integer seatcapacity) {
        this.seatcapacity = seatcapacity;
    }

    public String getFuletype() {
        return fuletype;
    }

    public void setFuletype(String fuletype) {
        this.fuletype = fuletype;
    }

    public Integer getModelyear() {
        return modelyear;
    }

    public void setModelyear(Integer modelyear) {
        this.modelyear = modelyear;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarEntity carEntity = (CarEntity) o;

        if (id != carEntity.id) return false;
        if (name != null ? !name.equals(carEntity.name) : carEntity.name != null) return false;
        if (carnumber != null ? !carnumber.equals(carEntity.carnumber) : carEntity.carnumber != null) return false;
        if (priceperday != null ? !priceperday.equals(carEntity.priceperday) : carEntity.priceperday != null)
            return false;
        if (description != null ? !description.equals(carEntity.description) : carEntity.description != null)
            return false;
        if (companyId != null ? !companyId.equals(carEntity.companyId) : carEntity.companyId != null) return false;
        if (seatcapacity != null ? !seatcapacity.equals(carEntity.seatcapacity) : carEntity.seatcapacity != null)
            return false;
        if (fuletype != null ? !fuletype.equals(carEntity.fuletype) : carEntity.fuletype != null) return false;
        if (modelyear != null ? !modelyear.equals(carEntity.modelyear) : carEntity.modelyear != null) return false;
        if (thumbnail != null ? !thumbnail.equals(carEntity.thumbnail) : carEntity.thumbnail != null) return false;
        if (status != null ? !status.equals(carEntity.status) : carEntity.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (carnumber != null ? carnumber.hashCode() : 0);
        result = 31 * result + (priceperday != null ? priceperday.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (companyId != null ? companyId.hashCode() : 0);
        result = 31 * result + (seatcapacity != null ? seatcapacity.hashCode() : 0);
        result = 31 * result + (fuletype != null ? fuletype.hashCode() : 0);
        result = 31 * result + (modelyear != null ? modelyear.hashCode() : 0);
        result = 31 * result + (thumbnail != null ? thumbnail.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }


}
