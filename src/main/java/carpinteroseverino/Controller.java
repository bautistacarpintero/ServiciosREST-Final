package carpinteroseverino;

import carpinteroseverino.model.Cow;
import carpinteroseverino.model.CowBCS;
import carpinteroseverino.model.Herd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@RestController
public class Controller {

    @Autowired
    CowRepository cowRepository;

    @Autowired
    HerdRepository herdRepository;

    @Autowired
    BCSRepository bcsRepository;

    @RequestMapping("/")
    public String index() {
        return "Congratulations from BlogController.java";
    }

    @RequestMapping(value = "/cow", method = RequestMethod.POST)
    public ResponseEntity<Cow> createCow(@RequestBody Cow cow){
        Cow newCow = cow;
        cowRepository.save(newCow);
        return new ResponseEntity<Cow>(newCow, HttpStatus.OK);
    }

    @RequestMapping(value = "/herd", method = RequestMethod.POST)
    public ResponseEntity<Herd> createHerd(@RequestBody Herd herd){
        Herd newHerd = herd;
        herdRepository.save(newHerd);
        return new ResponseEntity<Herd>(newHerd, HttpStatus.OK);

    }

    @RequestMapping(value = "/bindCowHerd", method = RequestMethod.PUT)
    public ResponseEntity<String> bindCowToHerd(@RequestBody Map<String, Integer> body){
        int herdId = body.get("HerdId");
        int cowId = body.get("CowId");

        Herd herd = herdRepository.findOne(herdId);
        Cow cow = cowRepository.findOne(cowId);

        if (herd != null && cow != null){
            herd.addCow(cow);
            cow.setHerd(herd);
            cowRepository.save(cow);
        }

        return ResponseEntity.ok("todo cool");
    }

    @RequestMapping(value = "/cow/{id}/bcs", method = RequestMethod.POST)
    public ResponseEntity<CowBCS> addBCS(@PathVariable("id") int id, @Param("bcs") int bcs){
        CowBCS cowBCS = new CowBCS(id, new Date(),bcs);
        bcsRepository.save(cowBCS);

        return new ResponseEntity<CowBCS>(cowBCS, HttpStatus.OK);
    }


//    @GetMapping("/test")
//    public void initHerd(){
//        herdRepository.save(new Herd());
//    }

}


