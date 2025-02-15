package prog2.cerveceria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controlador {

    @Autowired
    private CervezasDAO cervezasDAO;

    @GetMapping("/")
    public String mostrarInicio(Model model) {
        model.addAttribute("colores", cervezasDAO.getColores());
        return "index";
    }

    @PostMapping("/consulta")
    public String mostrarRespuesta(Model model, @RequestParam(value = "color", required = true) String color) {
        model.addAttribute("colorElegido", color);
        System.out.println("Cervezas recuperadas: " + cervezasDAO.getCervezasByColor(color));

        model.addAttribute("cervezas", cervezasDAO.getCervezasByColor(color));
        return "resultado";
    }
}
