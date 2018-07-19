/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelos.Especialidad;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author User
 */
@Service
public class EspecialidadService {
     @PersistenceContext
    private EntityManager em;
    @Transactional(rollbackFor={ServiceException.class})
    public void create(Especialidad especialidad) throws ServiceException{
        em.persist(especialidad);
    }
    
     @Transactional(rollbackFor={ServiceException.class})
    public Especialidad retrieve(int id) throws ServiceException{
        return em.find(Especialidad.class,id);
    }
    @Transactional(rollbackFor = {ServiceException.class})
    public void update(Especialidad especialidad) throws ServiceException{
        em.merge(especialidad);
    }
     @Transactional(rollbackFor = {ServiceException.class})
     public void delete(int id) throws ServiceException{
         em.remove(this.retrieve(id));
     }
    
    //.............................
      @Transactional(rollbackFor = {ServiceException.class})
     public List<Especialidad> list() throws ServiceException{
        return em.createNamedQuery("Especialidad.findAll").getResultList();
    }
}
