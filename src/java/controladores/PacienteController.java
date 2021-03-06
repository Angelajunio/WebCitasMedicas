/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import modelos.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import servicios.PacienteService;
import servicios.ServiceException;
import validator.PacienteValidator;

/**
 *
 * @author User
 */
@Controller
 @RequestMapping("/paciente")
public class PacienteController {
     
    @Autowired
    private PacienteService service;
      @Autowired
    private PacienteValidator validator;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model) {
        try {
            Paciente paciente = new Paciente();
            model.addAttribute("paciente", paciente);
            return "paciente/create";
        } catch (Exception ex) {
            model.addAttribute("message", ex.getMessage());
            return "error";
        }
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        try {
            List<Paciente> pacientes = service.list();
            model.addAttribute("pacientes", pacientes);
            return "paciente/list";
        } catch (Exception ex) {
            model.addAttribute("message", ex.getMessage());
            return "error";
        }
    }

    @RequestMapping(value = "/retrieve/{id}", method = RequestMethod.GET)
    public String retrieve(Model model, @PathVariable String id) {
        try {
            int pk = Integer.parseInt(id);
            Paciente paciente = service.retrieve(pk);
            model.addAttribute("paciente", paciente);
            return "paciente/retrieve";
        } catch (ServiceException ex) {
            model.addAttribute("message", ex.getMessage());
            return "error";
        }
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(Model model, @PathVariable String id) {
        try {
            int pk = Integer.parseInt(id);
            Paciente paciente = service.retrieve(pk);
            model.addAttribute("paciente", paciente);
            return "paciente/update";
        } catch (ServiceException ex) {
            model.addAttribute("message", ex.getMessage());
            return "error";
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(Model model, @PathVariable String id) {
        try {
            int pk = Integer.parseInt(id);
            Paciente paciente = service.retrieve(pk);
            model.addAttribute("paciente", paciente);
            return "paciente/delete";
        } catch (ServiceException ex) {
            model.addAttribute("message", ex.getMessage());
            return "error";
        }
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Model model, @ModelAttribute("paciente") Paciente paciente,
    BindingResult errors) {
        try {
            //Calendar fechaNac = Calendar.getInstance();
            //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            //fechaNac.setTime(format.parse(paciente.getStrFecha()));
            //paciente.setFechanacimiento(fechaNac.getTime());
            validator.validate(paciente, errors);
            if(errors.hasErrors()){
            model.addAttribute("paciente", paciente);
            return"paciente/create";
            }else{
                Calendar fechaNac = Calendar.getInstance();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                fechaNac.setTime(format.parse(paciente.getStrFecha()));
                paciente.setFechanacimiento(fechaNac.getTime());
                service.create(paciente);
                return "redirect:list.htm";
            }
        } catch (ParseException | ServiceException ex) {
            model.addAttribute("message", ex.getMessage());
            return "error";
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(Model model, @ModelAttribute("paciente") Paciente paciente) {
        try {
            service.delete(paciente.getPacienteid());
            return "redirect:list.htm";
        } catch (Exception ex) {
            model.addAttribute("message", ex.getMessage());
            return "error";
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Model model, @ModelAttribute("paciente") Paciente paciente) {
        try {
            Calendar fechaNac = Calendar.getInstance();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            fechaNac.setTime(format.parse(paciente.getStrFecha()));
            paciente.setFechanacimiento(fechaNac.getTime());
            service.update(paciente);
            return "redirect:list.htm";
        } catch (Exception ex) {
            model.addAttribute("message", ex.getMessage());
            return "error";
        }
    }

}
