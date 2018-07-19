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
import modelos.Cita;
import modelos.Medico;
import modelos.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import servicios.CitaService;
import servicios.MedicoService;
import servicios.PacienteService;
import servicios.ServiceException;

/**
 *
 * @author User
 */
@Controller
@RequestMapping("/cita")
public class CitaController {
    @Autowired
    private PacienteService srvPaciente;

    @Autowired
    private MedicoService srvMedico;

    @Autowired
    private CitaService srvCita;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        try {
            List<Cita> citas = srvCita.list();
            model.addAttribute("citas", citas);
            return "cita/list";
        } catch (ServiceException ex) {
            model.addAttribute("message", ex.getMessage());
            return "error";
        }
    }

    @ModelAttribute("listMedico")
    public List<Medico> ListMedico() throws ServiceException {
        return srvMedico.list();
    }

    @ModelAttribute("listPaciente")
    public List<Paciente> ListPaciente() throws ServiceException {
        return srvPaciente.list();
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model) {
        try {
            Cita cita = new Cita();
            model.addAttribute("cita", cita);
            return "cita/create";
        } catch (Exception ex) {
            model.addAttribute("message", ex.getMessage());
            return "error";
        }
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Model model, @ModelAttribute("cita") Cita cita) {
        try {
            Calendar fecha = Calendar.getInstance();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            fecha.setTime(format.parse(cita.getStrFecha()));
            cita.setFecha(fecha.getTime());

            Paciente paciente = srvPaciente.retrieve(cita.getIdpaciente());
            Medico medico = srvMedico.retrieve(cita.getIdmedico());

            cita.setPacienteid(paciente);
            cita.setMedicoid(medico);

          
            cita.setObservacion("-");
            cita.setRealizada(false);

            srvCita.create(cita);
            return "redirect:list.htm";

        } catch (ParseException | ServiceException ex) {
            model.addAttribute("message", ex.getMessage());
            return "error";
        }
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(Model model, @PathVariable int id) {
        try {
            Cita cita = srvCita.retrieve(id);
//            terapia.setIdmedico(terapia.getMedicoId().getMedicoId());
//            terapia.setIdpaciente(terapia.getPacienteId().getPacienteId());
//            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//            String strFecha = format.format(terapia.getFecha());
//            terapia.setStrFecha(strFecha);
            
            model.addAttribute("cita",cita);
            return "cita/update";
        } catch (ServiceException ex) {
            model.addAttribute("message", ex.getMessage());
            return "error";
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Model model, @ModelAttribute("cita") Cita cita) {
        try {
            Calendar fecha = Calendar.getInstance();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            fecha.setTime(format.parse(cita.getStrFecha()));
            cita.setFecha(fecha.getTime());

            Paciente paciente = srvPaciente.retrieve(cita.getIdpaciente());
            Medico medico = srvMedico.retrieve(cita.getIdmedico());

            cita.setPacienteid(paciente);
            cita.setMedicoid(medico);
            
            srvCita.update(cita);
            return "redirect:list.htm";

        } catch (ParseException | ServiceException ex) {
            model.addAttribute("message", ex.getMessage());
            return "error";
        }
    }
}
