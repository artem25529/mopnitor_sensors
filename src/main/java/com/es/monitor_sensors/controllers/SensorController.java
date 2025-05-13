package com.es.monitor_sensors.controllers;

import com.es.monitor_sensors.dtos.SensorsListDto;
import com.es.monitor_sensors.models.Sensor;
import com.es.monitor_sensors.services.SensorService;
import com.es.monitor_sensors.services.TypeService;
import com.es.monitor_sensors.services.UnitService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/sensors")
public class SensorController extends BaseController {
    @Autowired
    private SensorService sensorService;

    @Autowired
    private UnitService unitService;

    @Autowired
    private TypeService typeService;

    @ModelAttribute
    public void setCommonAttributes(final Model model) {
        model.addAttribute("units", unitService.getAll());
        model.addAttribute("types", typeService.getAll());
    }

    @GetMapping
    public String sensors(final Model model) {
        model.addAttribute("sensorsListDto", new SensorsListDto(sensorService.getAll()));
        return "pages/sensors-list";
    }

    @GetMapping("/{id}")
    public String sensor(@PathVariable final Long id, final Model model) {
        model.addAttribute("sensor", sensorService.getById(id));
        return "pages/sensor-details";
    }

    @GetMapping("/new")
    @PreAuthorize("hasAuthority('Administrator')")
    public String newSensorForm(final Model model) {
        model.addAttribute("sensor", new Sensor());
        return "pages/new-sensor";
    }

    @PostMapping
    public String create(@Valid @ModelAttribute final Sensor sensor,
                             final BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "pages/new-sensor";
        }

        final Long id = sensorService.saveOrUpdate(sensor);

        redirectAttributes.addFlashAttribute("success", true);
        redirectAttributes.addFlashAttribute("msg", "Sensor with id: " + id +
                " was created successfully!");

        return REDIRECT_PREFIX + "/sensors";
    }

    @PatchMapping
    public String updateAll(@Valid @ModelAttribute final SensorsListDto sensorsListDto,
                         final BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "pages/sensors-list";
        }

        final List<Sensor> updatedSensors = sensorService.saveOrUpdateAll(sensorsListDto.getSensors());

        if (!updatedSensors.isEmpty()) {
            redirectAttributes.addFlashAttribute("msg", "Sensor(s) updated successfully!");
            redirectAttributes.addFlashAttribute("success", true);
        }
        return REDIRECT_PREFIX + "/sensors";
    }

    @PatchMapping("/{id}")
    public String update(@Valid @ModelAttribute final Sensor sensor,
                            final BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "pages/sensor-details";
        }

        sensorService.saveOrUpdate(sensor);

        redirectAttributes.addFlashAttribute("msg", "Sensor(s) updated successfully!");
        redirectAttributes.addFlashAttribute("success", true);
        return REDIRECT_PREFIX + "/sensors?success";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable final Long id) {
        sensorService.deleteById(id);
        return REDIRECT_PREFIX + "/sensors";
    }
}
