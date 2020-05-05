package carpinteroseverino;

import carpinteroseverino.model.Cow;
import carpinteroseverino.model.CowBCS;
import carpinteroseverino.model.Herd;
import carpinteroseverino.repositories.BCSRepository;
import carpinteroseverino.repositories.CowRepository;
import carpinteroseverino.repositories.HerdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
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
        return "Congratulations from Controller.java";
    }

    @RequestMapping(value = "/cow", method = RequestMethod.POST)
    public ResponseEntity<Cow> createCow(@RequestBody Cow cow) {
        Cow newCow = cow;
        cowRepository.save(newCow);
        return new ResponseEntity<Cow>(newCow, HttpStatus.OK);
    }

    @RequestMapping(value = "/cow/{id}", method = RequestMethod.GET)
    public ResponseEntity<Cow> getCow(@PathVariable("id") int id) {

        try {
            Cow cow = cowRepository.findOne(id);
            return new ResponseEntity<Cow>(cow, HttpStatus.OK);

        } catch (NullPointerException e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(value = "/cows", method = RequestMethod.GET)
    public ResponseEntity<List<Cow>> getCows() {
        return ResponseEntity.ok(cowRepository.findAll());
    }

    @RequestMapping(value = "/herd", method = RequestMethod.POST)
    public ResponseEntity<Herd> createHerd(@RequestBody Herd herd) {
        Herd newHerd = herd;
        herdRepository.save(newHerd);
        return new ResponseEntity<Herd>(newHerd, HttpStatus.OK);

    }

    @RequestMapping(value = "/herd/{id}", method = RequestMethod.GET)
    public ResponseEntity<Herd> getHerd(@PathVariable("id") int id) {
        try {
            Herd herd = herdRepository.findOne(id);
            return new ResponseEntity<Herd>(herd, HttpStatus.OK);

        } catch (NullPointerException e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(value = "/herds", method = RequestMethod.GET)
    public ResponseEntity<List<Herd>> getHerds() {
        return ResponseEntity.ok(herdRepository.findAll());
    }

    @RequestMapping(value = "/bindCowHerd", method = RequestMethod.PUT)
    public ResponseEntity<String> bindCowToHerd(@RequestBody Map<String, Integer> body) {
        int herdId = body.get("HerdId");
        int cowId = body.get("CowId");

        Herd herd = herdRepository.findOne(herdId);
        Cow cow = cowRepository.findOne(cowId);

        if (herd == null && cow == null)
            return new ResponseEntity<String>("Head and cow not found!", HttpStatus.NOT_FOUND);

        if (herd == null)
            return new ResponseEntity<String>("Head not found!", HttpStatus.NOT_FOUND);

        if (cow == null)
            return new ResponseEntity<String>("Cow not found!", HttpStatus.NOT_FOUND);

        if (herd != null && cow != null) {
            herd.addCow(cow);
            cow.setHerd(herd);
            cowRepository.save(cow);
        }

        return ResponseEntity.ok("Herd " + herdId + " and cow " + cowId + " was successfully bound!");
    }

    @RequestMapping(value = "/cow/{id}/bcs", method = RequestMethod.POST)
    public ResponseEntity<CowBCS> addBCS(@PathVariable("id") int id, @RequestBody Map<String, Integer> body) {

        try {
            int bcs = body.get("bcs");
            Cow cow = cowRepository.findOne(id);
            CowBCS cowBCS = new CowBCS(cow, new Date(), bcs);
            bcsRepository.save(cowBCS);
            return new ResponseEntity<CowBCS>(cowBCS, HttpStatus.OK);

        } catch (NullPointerException e) {

            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }


    @RequestMapping(value = "/cow/{id}/bcs", method = RequestMethod.GET)
    public ResponseEntity<List<CowBCS>> getBCS(@PathVariable("id") int id) {

        try {
            Cow cow = cowRepository.findOne(id);
            return new ResponseEntity<List<CowBCS>>(cow.getBcs(), HttpStatus.OK);

        } catch (NullPointerException e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

//    @GetMapping("/test")
//    public void initHerd(){
//        herdRepository.save(new Herd());
//    }

}


