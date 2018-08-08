/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import modelos.Paciente;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author User
 */
public class PacienteValidator implements Validator {
    @Override
    public boolean supports(Class<?> type){
    return Paciente.class.isAssignableFrom(type);    
    }

    @Override
    public void validate(Object o, Errors errors) {
        Paciente paciente= (Paciente) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,
                "cedula",
                "required.cedula",
                "Debe registrar una cedula");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,
                "nombres",
                "required.nombres",
                "Debe registrar un nombre");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,
                "apellidos",
                "required.apellidos",
                "Debe registrar un apellido");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,
                "strFecha",
                "required.strFecha",
                "Debe registrar una fecha de nacimiento");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,
                "telefono",
                "required.telefono",
                "Debe registrar el numero de telefono");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,
                "observaciones",
                "required.observaciones",
                "Debe registrar una observaciones");
        
        if(paciente.getCedula().length() >10){
            errors.rejectValue("cedula","required.cedula",
                    "La cedula no puede tener mas de 10 numeros");
        }
        if(paciente.getNombres().length() >30){
            errors.rejectValue("nombres","required.nombres",
                    "El nombre no puede tener más de 30 caracteres");
        }
         if(paciente.getApellidos().length() >30){
            errors.rejectValue("apellidos","required.apellidos",
                    "El apellido no puede tener más de 30 caracteres");
        }
         if(paciente.getTelefono().length() >10){
            errors.rejectValue("telefono","required.telefono",
                    "El telefono no debe tener más de 10 caracteres");
        }
         if(paciente.getObservaciones().length() >50){
            errors.rejectValue("observaciones","required.observaciones",
                    "La observacion no debe tener más de 50 caracteres");
        }
        try{
        Calendar hoy= Calendar.getInstance();
        Calendar fecha=Calendar.getInstance();
        SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
        fecha.setTime(format.parse(paciente.getStrFecha()));
        if(fecha.after(hoy)){
            errors.rejectValue("strFecha","required.strFecha",
                    "La fecha de nacimiento no puede ser posterior al dia de hoy");
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
        
        if(paciente.getEstatura()==null){
            errors.rejectValue("estatura","required.estatura",
                    "La estatura no puede ser nulo");
        }else if (paciente.getEstatura() < 70 || paciente.getEstatura() > 230) {
            errors.rejectValue("estatura", "required.estatura", "Verifique el valor de la estatura");
        }
        if(paciente.getPeso()==null){
            errors.rejectValue("peso","required.peso",
                    "El peso no puede ser nulo");
        } else if(paciente.getPeso()< 30 
                || paciente.getPeso() > 330){
            errors.rejectValue("peso","required.peso",
                    "Verifique el valor del  peso");
        }
        
    }
    
}
