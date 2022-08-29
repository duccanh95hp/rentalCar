package com.example.rentalcar.dto;



public class CarInfo {
    private long id;

    private String name;

    private String carnumber;

    private Integer priceperday;

    private String description;

    private Long companyId;

    private Integer seatcapacity;

    private String fuletype;

    private Integer modelyear;

    private String thumbnail;

    private Integer status;

    private String carCompany;

    public CarInfo(long id, String name, String carnumber, Integer priceperday, String description, Long companyId, Integer seatcapacity, String fuletype, Integer modelyear, String thumbnail, Integer status, String carCompany) {
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
        this.carCompany = carCompany;
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

    public String getCarCompany() {
        return carCompany;
    }

    public void setCarCompany(String carCompany) {
        this.carCompany = carCompany;
    }
}
