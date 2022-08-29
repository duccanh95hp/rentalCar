package com.example.rentalcar.dto;
import java.util.Date;
public class BookingCarUserDetail {
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

    private Date created;
    private String note;
    private String invoice;
    private Integer status;

    private String nameU;
    private String addressU;
    private String emailU;
    private String telephoneU;
    private Integer cmtU;
    private Integer passportU;
    private String avatarU;
    public BookingCarUserDetail(long id, String name, String carnumber, Integer priceperday, String description, Integer seatcapacity, String fuletype, Integer modelyear, String thumbnail, Long carId, Date fromDate, Date toDate, String note, String invoice, Integer status, String nameU, String addressU, String emailU, String telephoneU, Integer cmtU, Integer passportU, String avatarU,Date created) {
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
        this.nameU = nameU;
        this.addressU = addressU;
        this.emailU = emailU;
        this.telephoneU = telephoneU;
        this.cmtU = cmtU;
        this.passportU = passportU;
        this.avatarU = avatarU;
        this.created = created;
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

    public String getNameU() {
        return nameU;
    }

    public void setNameU(String nameU) {
        this.nameU = nameU;
    }

    public String getAddressU() {
        return addressU;
    }

    public void setAddressU(String addressU) {
        this.addressU = addressU;
    }

    public String getEmailU() {
        return emailU;
    }

    public void setEmailU(String emailU) {
        this.emailU = emailU;
    }

    public String getTelephoneU() {
        return telephoneU;
    }

    public void setTelephoneU(String telephoneU) {
        this.telephoneU = telephoneU;
    }

    public Integer getCmtU() {
        return cmtU;
    }

    public void setCmtU(Integer cmtU) {
        this.cmtU = cmtU;
    }

    public Integer getPassportU() {
        return passportU;
    }

    public void setPassportU(Integer passportU) {
        this.passportU = passportU;
    }

    public String getAvatarU() {
        return avatarU;
    }

    public void setAvatarU(String avatarU) {
        this.avatarU = avatarU;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
