package com.es.monitor_sensors.controllers;

import com.es.monitor_sensors.dtos.SensorsListDto;
import com.es.monitor_sensors.services.SensorService;
import com.es.monitor_sensors.services.TypeService;
import com.es.monitor_sensors.services.UnitService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.SmartValidator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequestMapping("/sensors")
public class SensorController extends BaseController {
    @Autowired
    private SmartValidator smartValidator;

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
        log.debug("logging");
        model.addAttribute("sensorsListDto", new SensorsListDto(sensorService.getAll()));
        return "pages/sensors-list";
    }

    @PatchMapping
    public String update(@Valid @ModelAttribute final SensorsListDto sensorsListDto,
                         final BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "pages/sensors-list";
        }

        sensorService.saveOrUpdateAll(sensorsListDto.getSensors());
        redirectAttributes.addFlashAttribute("msg", "Sensor(s) updated successfully!");
        return REDIRECT_PREFIX + "/sensors?success";
    }
}
