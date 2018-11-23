
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Apo
 */
public class RingingCentre {
    private Map<Bird, List<String>> observationPlaces;
    
    public RingingCentre() {
        observationPlaces = new HashMap<Bird, List<String>>();
    }
    
    public void observe(Bird bird, String place) {
        if(!observationPlaces.containsKey(bird)) {
            observationPlaces.put(bird, new ArrayList<String>());
        }
        
        List<String> places = observationPlaces.get(bird);
        places.add(place);
    }
    
    public void observations(Bird bird) {
        List<String> places = observationPlaces.get(bird);
        System.out.print(bird);
        
        if(places != null) {
            System.out.println(" observations: " + places.size());
        
            for(String i : places) {
                System.out.println(i);
            }
        }
        
        else {
            System.out.println(" observations: 0");
        }
        
        
    }
}
