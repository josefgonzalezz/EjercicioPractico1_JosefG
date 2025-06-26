/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package farmacia.com.controller;

import farmacia.com.domain.Farmacia;
import farmacia.com.service.FarmaciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/farmacia")
public class FarmaciaController {

    @Autowired
    private FarmaciaService farmaciaService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var medicamentos = farmaciaService.getMedicamentos(false);
        model.addAttribute("medicamentos", medicamentos);
        model.addAttribute("totalMedicamentos", medicamentos.size());
        model.addAttribute("farmacia", new Farmacia());
        return "/farmacia/listado";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("farmacia", new Farmacia());
        return "/farmacia/modifica";
    }

    @PostMapping("/guardar")
    public String guardar(Farmacia farmacia,
                          @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            farmaciaService.save(farmacia);
        }
        farmaciaService.save(farmacia);
        return "redirect:/farmacia/listado";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Long id) {
        Farmacia farmacia = new Farmacia();
        farmacia.setId(id);
        farmaciaService.delete(farmacia);
        return "redirect:/farmacia/listado";
    }

    @GetMapping("/modifica/{id}")
    public String modificar(@PathVariable("id") Long id, Model model) {
        if (id == null) {
            return "redirect:/farmacia/listado";
        }
        Farmacia farmacia = farmaciaService.getMedicamento(id);
        if (farmacia == null) {
            return "redirect:/farmacia/listado";
        }
        model.addAttribute("farmacia", farmacia);
        return "/farmacia/modifica";
    }

}
