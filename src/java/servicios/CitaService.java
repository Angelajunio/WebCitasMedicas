/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelos.Cita;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author User
 */
@Service
public class CitaService {
      @PersistenceContext
    private EntityManager em;
    @Transactional(rollbackFor={ServiceException.class})
    public void create(Cita cita) throws ServiceException{
        em.persist(cita);
    }
    
     @Transactional(rollbackFor={ServiceException.class})
    public Cita retrieve(int id) throws ServiceException{
        return em.find(Cita.class,id);
    }
    @Transactional(rollbackFor = {ServiceException.class})
    public void update(Cita cita) throws ServiceException{
        em.merge(cita);
    }
     @Transactional(rollbackFor = {ServiceException.class})
     public void delete(int id) throws ServiceException{
         em.remove(this.retrieve(id));
     }
    
    //.............................
      @Transactional(rollbackFor = {ServiceException.class})
     public List<Cita> list() throws ServiceException{
        return em.createNamedQuery("Cita.findAll").getResultList();
    }
}
