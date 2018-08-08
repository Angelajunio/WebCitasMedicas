/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.util.List;
import modelos.Horario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import servicios.HorarioService;
import servicios.ServiceException;
import validator.HorarioValidator;

/**
 *
 * @author User
 */
@Controller
 @RequestMapping("/horario")
public class HorarioController {
    @Autowired //Inyección de dependencias
    private HorarioService service;
      @Autowired
    private HorarioValidator validator;
    @RequestMapping(value="/create", method= RequestMethod.GET)
    public String create(Model model){ //Los metodos en Spring Web MVC retornan un String
        try{
            Horario horario = new Horario();
            model.addAttribute("horario", horario);
            return "horario/create"; //Carpeta y nombre de la vista
        }
        catch(Exception ex){
            model.addAttribute("message", ex.getMessage());
            return "error";
        }
    }
    
    @RequestMapping(value="/list", method= RequestMethod.GET)
    public String list(Model model){ //Los metodos en Spring Web MVC retornan un String
        try{
            List<Horario> horarios = service.list();
            model.addAttribute("horarios", horarios);
            return "horario/list"; //Carpeta y nombre de la vista
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
            Horario horario = service.retrieve(pk);
            model.addAttribute("horario", horario);
            return "horario/retrieve"; //Carpeta y nombre de la vista
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
            Horario horario = service.retrieve(pk);
            model.addAttribute("horario", horario);
            return "horario/update";
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
            Horario horario = service.retrieve(pk);
            model.addAttribute("horario", horario);
            return "horario/delete";
        }
        catch(ServiceException ex){
            model.addAttribute("message", ex.getMessage());
            return "error";
        }
    }
    
    @RequestMapping(value="/create", method= RequestMethod.POST)
    public String create(Model model, @ModelAttribute("horario") Horario horario, BindingResult errors){
        try{
            validator.validate(horario, errors);
            if(errors.hasErrors()){
            model.addAttribute("horario", horario);
            return"horario/create";
            }else{
            
            service.create(horario);
            return "redirect:list.htm";
        }}
        catch(ServiceException ex){
            model.addAttribute("message", ex.getMessage());
            return "error";
        }
    }
    
    @RequestMapping(value="/update", method= RequestMethod.POST)
    public String update(Model model, @ModelAttribute("horario") Horario horario){
        try{
            service.update(horario);
            return "redirect:list.htm";
        }
        catch(ServiceException ex){
            model.addAttribute("message", ex.getMessage());
            return "error";
        }
    }
    
    @RequestMapping(value="/delete", method= RequestMethod.POST)
    public String delete(Model model, @ModelAttribute("horario") Horario horario){
        try{
            service.delete(horario.getHorarioid());
            return "redirect:list.htm";
        }
        catch(ServiceException ex){
            model.addAttribute("message", ex.getMessage());
            return "error";
        }
    }
}
