/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;
import modelos.Medico;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
/**
 *
 * @author User
 */
public class MedicoValidator implements Validator{

    @Override
    public boolean supports(Class<?> type) {
        return Medico.class.isAssignableFrom(type);
    }
    
    //En Object viene el modelo a ser validado
    @Override //Implementa validaciones
    public void validate(Object o, Errors errors) {
        Medico medico= (Medico) o;
        
      

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, 
                "nombres", 
                "required.nombres", 
                "Debe registrar un nombre");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, 
                "apellidos", 
                "required.apellidos", 
                "Debe registrar un apellidos");
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, 
                "correo", 
                "required.correo", 
                "Debe registrar un corro");
        
       
       if(medico.getNombres().length() > 30){
            errors.rejectValue("nombre", "required.nombre",
                    "El nombre no puede tener más de 30 caracteres");
        }
       if(medico.getApellidos().length() > 30){
            errors.rejectValue("apellido", "required.nombre",
                    "El apellido no puede tener más de 30 caracteres");
        }
       if (medico.getCorreo().length() > 30) {
            errors.rejectValue("correo", "required.descripcion", 
                    "El medico debe tener 30 caracteres");
        }

       
    }
}

