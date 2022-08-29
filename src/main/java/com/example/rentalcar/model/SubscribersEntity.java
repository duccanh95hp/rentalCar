package com.example.rentalcar.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.sql.Date;

@Entity
@Table(name = "subscribers", schema = "dbo", catalog = "carrental")
public class SubscribersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Email
    @Column(name = "subscribersemail")
    private String subscribersemail;




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubscribersemail() {
        return subscribersemail;
    }

    public void setSubscribersemail(String subscribersemail) {
        this.subscribersemail = subscribersemail;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubscribersEntity that = (SubscribersEntity) o;

        if (id != that.id) return false;
        if (subscribersemail != null ? !subscribersemail.equals(that.subscribersemail) : that.subscribersemail != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (subscribersemail != null ? subscribersemail.hashCode() : 0);

        return result;
    }


}
