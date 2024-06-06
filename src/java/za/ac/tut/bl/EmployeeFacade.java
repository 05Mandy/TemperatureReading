/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.bl;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import za.ac.tut.entitites.Employee;

/**
 *
 * @author mandy
 */
@Stateless
public class EmployeeFacade extends AbstractFacade<Employee> implements EmployeeFacadeLocal {

    @PersistenceContext(unitName = "SickTestEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmployeeFacade() {
        super(Employee.class);
    }

    @Override
    public List<Employee> getHighestTemparature() {

        Query query = em.createQuery("SELECT e FROM Employee e JOIN e.temp t WHERE t > 38");
        List<Employee> emp = query.getResultList();

        return emp;
    }

    @Override
    public List<Employee> getAcceptableTemparature() {

        Query query = em.createQuery("SELECT e FROM Employee e JOIN e.temp t WHERE t <= 38");
        List<Employee> emp = query.getResultList();

        return emp;
    }

    @Override
    public List<Employee> getEmployeesWithHighTenpOccurence() {
   
        Query query = em.createQuery("SELECT e FROM Employee e JOIN e.temp t  WHERE t > 38 GROUP BY e HAVING COUNT(t) > 2");
        List<Employee> emp = query.getResultList();
        
        return emp;
    }

}
