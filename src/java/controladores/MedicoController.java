/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.text.ParseException;
import java.util.List;
import modelos.Especialidad;
import modelos.Horario;
import modelos.Medico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import servicios.EspecialidadService;
import servicios.HorarioService;
import servicios.MedicoService;
import servicios.ServiceException;
import validator.MedicoValidator;
import validator.PacienteValidator;





/**
 *
 * @author User
 */

@Controller
@RequestMapping("/medico")
public class MedicoController {
    @Autowired//Inyeccion de dependencias
 private MedicoService srvMedico;
    @Autowired//Inyeccion de dependencias
 private EspecialidadService srvEspecialidad;
    @Autowired//Inyeccion de dependencias
 private HorarioService srvHorario;
    @Autowired
    private MedicoValidator validator;
    
@RequestMapping(value="/list", method=RequestMethod.GET)
public String list(Model model){ //los metodos en Spring web mvc retoornan un String
    try{
       List<Medico> medicos = srvMedico.list();
       model.addAttribute("medicos", medicos);
        return "medico/list"; //nombre de la vista 
    }
    catch(ServiceException ex){
        model.addAttribute("message", ex.getMessage());
        return "error";
    }
}

@RequestMapping(value="/create", method=RequestMethod.GET)
public String create(Model model){ //los metodos en Spring web mvc retoornan un String
    try{
       Medico medico = new Medico();
       model.addAttribute("medico", medico);
        return "medico/create"; //nombre de la vista 
    }
    catch(Exception ex){
        model.addAttribute("message", ex.getMessage());
        return "error";
    }
}
@RequestMapping(value="/update/(id)", method=RequestMethod.GET)//datos formatiaos
public String update(Model model, @PathVariable int id){ //los metodos en Spring web mvc retoornan un String
    try{
        Medico medico = srvMedico.retrieve(id);
        //terapia.setIdmedico(terapia.getMedicoId().getMedicoId());
        //terapia.setIdpaciente(terapia.getPacienteId().getPacienteId());
        //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //String strFecha = format.format(terapia.getFecha());
        //terapia.setStrFecha(strFecha);
        model.addAttribute("medico", medico);
        return "medico/update"; //nombre de la vista 
    }
    catch(ServiceException ex){
        model.addAttribute("message", ex.getMessage());
        return "error";
    }
}

@RequestMapping(value="/create", method=RequestMethod.POST)
public String create(Model model, @ModelAttribute("medico") Medico medico, 
        BindingResult errors) { //los metodos en Spring web mvc retoornan un String
    try{
       
       Especialidad especialidad = srvEspecialidad.retrieve(medico.getIdespecialidad());
       Horario horario = srvHorario.retrieve(medico.getIdhorario());
       medico.setEspecialidadid(especialidad);
       medico.setHorarioid(horario);
    
       validator.validate(medico, errors);
            if(errors.hasErrors()){
            model.addAttribute("medico", medico);
            return"medico/create";
            }else{
                    srvMedico.create(medico);
       
        return "redirect:list.htm"; //nombre de la vista 
    }}
    catch(ServiceException ex){
        model.addAttribute("message", ex.getMessage());
        return "error";
    }
}

@RequestMapping(value="/update", method=RequestMethod.POST)
public String update(Model model, @ModelAttribute("medico") Medico medico){ //los metodos en Spring web mvc retoornan un String
    try{
       
        
         Especialidad especialidad = srvEspecialidad.retrieve(medico.getIdespecialidad());
       Horario horario = srvHorario.retrieve(medico.getIdhorario());
       medico.setEspecialidadid(especialidad);
       medico.setHorarioid(horario);
        
        srvMedico.update(medico);
        return "redirect: list.htm"; //nombre de la vista 
    }
    catch(ServiceException ex){
        model.addAttribute("message", ex.getMessage());
        return "error";
    }
}

@RequestMapping(value="/retrieve/{id}", method=RequestMethod.GET)
    public String retrieve(Model model, @PathVariable String id){
        try{
            int pk = Integer.parseInt(id);
            Medico medico = srvMedico.retrieve(pk);
            model.addAttribute("medico",medico);
            return "medico/retrieve";  
        }catch(Exception ex){
         model.addAttribute("message", ex.getMessage());
            return "error";
        }
    }
    
    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    public String delete(Model model, @PathVariable String id){
        try{
            int pk = Integer.parseInt(id);
            Medico medico=srvMedico.retrieve(pk);
            model.addAttribute("medico",medico);
            return "medico/delete";  
        }catch(Exception ex){
         model.addAttribute("message", ex.getMessage());
            return "error";
        }
    }
    @RequestMapping(value="/delete", method=RequestMethod.POST)
    public String delete(Model model, @ModelAttribute("medico") Medico medico){
        try{
            srvMedico.delete(medico.getMedicoid());
            return "redirect: list.htm";   
        }catch(Exception ex){
         model.addAttribute("message", ex.getMessage());
            return "error";
        }
    }

@ModelAttribute("listEspecialidad")
public List<Especialidad>listEspecialidad() throws ServiceException{
    return srvEspecialidad.list();
}
@ModelAttribute("listHorario")
public List<Horario>listHorario() throws ServiceException{
    return srvHorario.list();
}

    
}
