/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package detalles;

/**
 *
 * @author User
 */
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertirDate_a_String {

    public static String convertirFecha(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        String stringFecha = sdf.format(date);
        return stringFecha;
    }
}
