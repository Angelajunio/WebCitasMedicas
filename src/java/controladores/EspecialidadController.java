/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.util.List;
import modelos.Especialidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import servicios.EspecialidadService;
import servicios.ServiceException;

/**
 *
 * @author User
 */
@Controller
 @RequestMapping("/especialidad")
public class EspecialidadController {
    @Autowired //Inyección de dependencias
    private EspecialidadService service;
    
    @RequestMapping(value="/create", method= RequestMethod.GET)
    public String create(Model model){ //Los metodos en Spring Web MVC retornan un String
        try{
            Especialidad especialidad = new Especialidad();
            model.addAttribute("especialidad", especialidad);
            return "especialidad/create"; //Carpeta y nombre de la vista
        }
        catch(Exception ex){
            model.addAttribute("message", ex.getMessage());
            return "error";
        }
    }
    
    @RequestMapping(value="/list", method= RequestMethod.GET)
    public String list(Model model){ //Los metodos en Spring Web MVC retornan un String
        try{
            List<Especialidad> especialidades = service.list();
            model.addAttribute("especialidades", especialidades);
            return "especialidad/list"; //Carpeta y nombre de la vista
        }
        catch(ServiceException ex){
            model.addAttribute("message", ex.getMessage());
            return "error";
        }
    }
    
    @RequestMapping(value="/retrieve/{id}", method= RequestMethod.GET) //medico/retrieve/123.htm
    public String retrieve(Model model, @PathVariable String id){ //Los metodos en Spring Web MVC retornan un String
        try{
            int pk = Integer.parseInt(id);
            Especialidad especialidad = service.retrieve(pk);
            model.addAttribute("especialidad", especialidad);
            return "especialidad/retrieve"; //Carpeta y nombre de la vista
        }
        catch(ServiceException ex){
            model.addAttribute("message", ex.getMessage());
            return "error";
        }
    }

    @RequestMapping(value="/update/{id}", method= RequestMethod.GET)
    public String update(Model model, @PathVariable String id){
        try{
            int pk = Integer.parseInt(id);
            Especialidad especialidad = service.retrieve(pk);
            model.addAttribute("especialidad", especialidad);
            return "especialidad/update";
        }
        catch(ServiceException ex){
            model.addAttribute("message", ex.getMessage());
            return "error";
        }
    }
    
    @RequestMapping(value="/delete/{id}", method= RequestMethod.GET)
    public String delete(Model model, @PathVariable String id){
        try{
            int pk = Integer.parseInt(id);
            Especialidad especialidad = service.retrieve(pk);
            model.addAttribute("especialidad", especialidad);
            return "especialidad/delete";
        }
        catch(ServiceException ex){
            model.addAttribute("message", ex.getMessage());
            return "error";
        }
    }
    
    @RequestMapping(value="/create", method= RequestMethod.POST)
    public String create(Model model, @ModelAttribute("especialidad") Especialidad especialidad){
        try{
            service.create(especialidad);
            return "redirect:list.htm";
        }
        catch(ServiceException ex){
            model.addAttribute("message", ex.getMessage());
            return "error";
        }
    }
    
    @RequestMapping(value="/update", method= RequestMethod.POST)
    public String update(Model model, @ModelAttribute("especialidad") Especialidad especialidad){
        try{
            service.update(especialidad);
            return "redirect:list.htm";
        }
        catch(ServiceException ex){
            model.addAttribute("message", ex.getMessage());
            return "error";
        }
    }
    
    @RequestMapping(value="/delete", method= RequestMethod.POST)
    public String delete(Model model, @ModelAttribute("especialidad") Especialidad especialidad){
        try{
            service.delete(especialidad.getEspecialidadid());
            return "redirect:list.htm";
        }
        catch(ServiceException ex){
            model.addAttribute("message", ex.getMessage());
            return "error";
        }
    }
}
