/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package farmacia.com.service;

/**
 *
 * @author josef
 */

import farmacia.com.domain.Farmacia;
import java.util.List;

public interface FarmaciaService {

    List<Farmacia> getMedicamentos(boolean activo);

    Farmacia getMedicamento(Long id);

    void save(Farmacia farmacia);

    void delete(Farmacia farmacia);
}
