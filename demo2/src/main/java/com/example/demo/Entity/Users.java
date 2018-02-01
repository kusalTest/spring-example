package com.example.demo.Entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by dushman on 7/17/17.
 */
/*@NamedQueries({

        @NamedQuery(name = "findLastSerialNum",query = "SELECT S  FROM SerialNumber S order by S.issueDate desc"),

        @NamedQuery(name = "getAllSerialNum",query = "SELECT I  FROM SerialNumber I "),

        @NamedQuery(name = "findOldSerialNumByDate",query = "SELECT S  FROM SerialNumber S order by S.issueDate desc"),

        //@NamedQuery(name = "getCustomerBycreatedUser", query = "SELECT C FROM Customer C WHERE C.lifeCycleInfo" +
        //  ".createdUser = :createdUser AND C.state= 0"),
})*/

@Entity
/*@Table(schema = "serialNumber")*/
public class Users implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

  /*  @Column(nullable = false)
    private String name;
*/
   /* @Column(nullable = false)
    private String username;
*/
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String type;


    @Column(nullable = true)
    private Date regDate;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    /*public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
*/
   /* public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
*/

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
