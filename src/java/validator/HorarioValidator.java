/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import modelos.Horario;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author User
 */
public class HorarioValidator implements Validator{

    @Override
    public boolean supports(Class<?> type) {
        return Horario.class.isAssignableFrom(type);
    }
    
    //En Object viene el modelo a ser validado
    @Override //Implementa validaciones
    public void validate(Object o, Errors errors) {
        Horario horario= (Horario) o;
        
      

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, 
                "dias", 
                "required.dias", 
                "Debe registrar el dia");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, 
                "horainicial", 
                "required.descripcion", 
                "Debe registrar una descripcion");
        
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, 
                "horafinal", 
                "required.horafinal", 
                "Debe registrar la hora");
       if(horario.getDias().length() > 10){
            errors.rejectValue("dias", "required.dias",
                    "El dia debe tener 10 caracteres");
        }
       if(horario.getHorafinal().length() > 10){
            errors.rejectValue("horafinal", "required.horafinal",
                    "la hora de tener el formato 09:30");
        }
      

       
    }
}
