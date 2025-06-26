/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package farmacia.com.dao;

/**
 *
 * @author josef
 */
import farmacia.com.domain.Farmacia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmaciaDao extends JpaRepository<Farmacia, Long> {

}
