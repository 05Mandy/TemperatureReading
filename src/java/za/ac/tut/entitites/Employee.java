/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.entitites;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author mandy
 */
@Entity
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Long id;
    private String name;
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable
    private List<Double> temp;
    private String outcome;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date time;

    public Employee() {
    }

    public Employee(Long id, String name, List<Double> temp, String outcome, Date time) {
        this.id = id;
        this.name = name;
        this.temp = temp;
        this.outcome = outcome;
        this.time = time;
    }

    public String getOutcome() {
        if (temp != null && !temp.isEmpty()) 
        {
            for (Double temperature : temp)
            {
                if(temperature > 38)
                {
                   outcome = "High";
                }else{
                    outcome = "Acceptable";
                }
            }
            
        } 
        else {
            outcome = "No temperature recorded";
        }

        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Double> getTemp() {
        return temp;
    }

    public void setTemp(List<Double> temp) {
        this.temp = temp;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.ac.tut.entitites.Employee[ id=" + id + " ]";
    }

}
