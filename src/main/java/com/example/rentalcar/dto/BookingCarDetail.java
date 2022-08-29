package com.example.rentalcar.dto;


import java.util.Date;

public class BookingCarDetail {
    private long id;

    private String name;

    private String carnumber;

    private Integer priceperday;

    private String description;

    private Integer seatcapacity;

    private String fuletype;

    private Integer modelyear;

    private String thumbnail;

    private Long carId;

    private Date fromDate;
    private Date toDate;
    private String note;
    private String invoice;
    private Integer status;

    public BookingCarDetail(long id, String name, String carnumber, Integer priceperday, String description, Integer seatcapacity, String fuletype, Integer modelyear, String thumbnail, Long carId, Date fromDate, Date toDate, String note, String invoice, Integer status) {
        this.id = id;
        this.name = name;
        this.carnumber = carnumber;
        this.priceperday = priceperday;
        this.description = description;
        this.seatcapacity = seatcapacity;
        this.fuletype = fuletype;
        this.modelyear = modelyear;
        this.thumbnail = thumbnail;
        this.carId = carId;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.note = note;
        this.invoice = invoice;
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

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
