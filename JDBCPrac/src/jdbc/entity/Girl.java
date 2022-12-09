package jdbc.entity;

import java.sql.Blob;
import java.sql.Date;

public class Girl {
    private int id;
    private String name;
    private String sex;
    private Date borndate;
    private String phone;
    private Blob photo;
    private int boyfriend_id;

    public Girl(){}

    public Girl(int id, String name, String sex, Date borndate, String phone, int boyfriend_id) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.borndate = borndate;
        this.phone = phone;
        this.photo = null;
        this.boyfriend_id = boyfriend_id;
    }

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBorndate() {
        return borndate;
    }

    public void setBorndate(Date borndate) {
        this.borndate = borndate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Blob getPhoto() {
        return photo;
    }

    public void setPhoto(Blob photo) {
        this.photo = photo;
    }

    public int getBoyfriend_id() {
        return boyfriend_id;
    }

    public void setBoyfriend_id(int boyfriend_id) {
        this.boyfriend_id = boyfriend_id;
    }
}
