package carpinteroseverino;

import carpinteroseverino.model.Cow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    CowRepository repository;

    @RequestMapping("/")
    public String index() {
        return "Congratulations from BlogController.java";
    }


    @GetMapping("/init")
    public String init(){
        initCows();
        return "";
    }

    private void initCows(){
        repository.save(new Cow());
    }

}


