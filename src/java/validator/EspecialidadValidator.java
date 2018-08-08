/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;
import modelos.Especialidad;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
/**
 *
 * @author User
 */
public class EspecialidadValidator implements Validator{

    @Override
    public boolean supports(Class<?> type) {
        return Especialidad.class.isAssignableFrom(type);
    }
    
    //En Object viene el modelo a ser validado
    @Override //Implementa validaciones
    public void validate(Object o, Errors errors) {
        Especialidad especialidad= (Especialidad) o;
        
      

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, 
                "nombre", 
                "required.nombre", 
                "Debe registrar un nombre");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, 
                "descripcion", 
                "required.descripcion", 
                "Debe registrar una descripcion");
        
       
       if(especialidad.getNombre().length() > 30){
            errors.rejectValue("nombre", "required.nombre",
                    "El nombre no puede tener más de 30 caracteres");
        }
       if (especialidad.getDescripcion().length() > 30) {
            errors.rejectValue("descripcion", "required.descripcion", 
                    "La descripcion debe tener 30 caracteres");
        }

       
    }
}
