/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package AplicacionBarcos;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author USUARIO
 */
public interface InterfaceReservaciones extends CrudRepository<Reservaciones,Integer>{
    
    public List <Reservaciones> findAllByStatus (String status);
    
    public List <Reservaciones> findAllByStartDateAfterAndStartDateBefore (Date dateOne, Date dateTwo);
    
    // select clientid, count (*) as "total" from reservacion group by clientId order by total
    @Query ("SELECT c.client, COUNT(c.client) from Reservaciones AS c group by c.client order by COUNT(c.client)DESC")
    public List<Object []> countTotalReservationsByClient();
    
}
