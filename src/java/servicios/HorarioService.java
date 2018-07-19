/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelos.Horario;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author User
 */
@Service
public class HorarioService {
     @PersistenceContext
    private EntityManager em;
    @Transactional(rollbackFor={ServiceException.class})
    public void create(Horario horario) throws ServiceException{
        em.persist(horario);
    }
    
     @Transactional(rollbackFor={ServiceException.class})
    public Horario retrieve(int id) throws ServiceException{
        return em.find(Horario.class,id);
    }
    @Transactional(rollbackFor = {ServiceException.class})
    public void update(Horario horario) throws ServiceException{
        em.merge(horario);
    }
     @Transactional(rollbackFor = {ServiceException.class})
     public void delete(int id) throws ServiceException{
         em.remove(this.retrieve(id));
     }
    
    //.............................
      @Transactional(rollbackFor = {ServiceException.class})
     public List<Horario> list() throws ServiceException{
        return em.createNamedQuery("Horario.findAll").getResultList();
    }
}
