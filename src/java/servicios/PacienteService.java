/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelos.Paciente;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author User
 */
@Service
public class PacienteService {
    @PersistenceContext
    private EntityManager em;
    @Transactional(rollbackFor={javax.xml.rpc.ServiceException.class})
    public void create(Paciente paciente) throws javax.xml.rpc.ServiceException{
        em.persist(paciente);
    }
    
     @Transactional(rollbackFor={javax.xml.rpc.ServiceException.class})
    public Paciente retrieve(int id) throws javax.xml.rpc.ServiceException{
        return em.find(Paciente.class,id);
    }
    @Transactional(rollbackFor = {javax.xml.rpc.ServiceException.class})
    public void update(Paciente paciente) throws javax.xml.rpc.ServiceException{
        em.persist(paciente);
    }
     @Transactional(rollbackFor = {javax.xml.rpc.ServiceException.class})
     public void delete(int id) throws javax.xml.rpc.ServiceException{
         em.remove(this.retrieve(id));
     }
    
    //.............................
      @Transactional(rollbackFor = {javax.xml.rpc.ServiceException.class})
     public List<Paciente> list() throws javax.xml.rpc.ServiceException{
        return em.createNamedQuery("Paciente.findAll").getResultList();
    }
}
