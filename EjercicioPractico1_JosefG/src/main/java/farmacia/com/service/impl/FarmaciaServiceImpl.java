/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package farmacia.com.service.impl;

import farmacia.com.dao.FarmaciaDao;
import farmacia.com.domain.Farmacia;
import farmacia.com.service.FarmaciaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FarmaciaServiceImpl implements FarmaciaService {

    @Autowired
    private FarmaciaDao farmaciaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Farmacia> getMedicamentos(boolean activos) {
        return farmaciaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Farmacia getMedicamento(Long id) {
        return farmaciaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void save(Farmacia farmacia) {
        farmaciaDao.save(farmacia);
    }

    @Override
    @Transactional
    public void delete(Farmacia farmacia) {
        farmaciaDao.delete(farmacia);
    }
}
