/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import modelos.Cita;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
/**
 *
 * @author User
 */
public class CitaValidator implements Validator {
    @Override
    public boolean supports(Class<?> type){
    return Cita.class.isAssignableFrom(type);    
    }

    @Override
    public void validate(Object o, Errors errors) {
        Cita cita= (Cita) o;
        
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,
                "strFecha",
                "required.strFecha",
                "Debe registrar una fecha ");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,
                "hora",
                "required.hora",
                "Debe registrar la hora");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,
                "observacion",
                "required.observacion",
                "Debe registrar una observacion");
         ValidationUtils.rejectIfEmptyOrWhitespace(errors,
                "dia",
                "required.dia",
                "Debe registrar el dia");
         if(cita.getHora().length() >5){
            errors.rejectValue("hora","required.hora",
                    "La hora deb ser ingresada ejm. 09:13");
        }
        if(cita.getDia().length() >10){
            errors.rejectValue("dia","required.dia",
                    "El dia no debe tener más de 10 caracteres");
        }
         if(cita.getObservacion().length() >50){
            errors.rejectValue("observacion","required.observacion",
                    "La observacion no debe tener más de 50 caracteres");
        }
        try{
        Calendar hoy= Calendar.getInstance();
        Calendar fecha=Calendar.getInstance();
        SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
        fecha.setTime(format.parse(cita.getStrFecha()));
        if(fecha.after(hoy)){
            errors.rejectValue("strFecha","required.strFecha",
                    "La fecha no puede ser posterior al dia de hoy");
        }
        
    }catch(ParseException ex){
        errors.rejectValue("strFecha","required.strFecha",
                "La fecha de nacimiento no es valida");
        System.out.println(ex);
                System.out.println("La fecha está mal");
    }
        
        //Date hoy = new Date();
        //if(paciente.getFechaNacimiento().after(hoy) ){
          //  errors.rejectValue("fechaNacimiento","required.fechaNacimiento",
            //        "La fecha de nacimiento no puede ser posterior al dia de hoy");
        //}
        
    }
    }
