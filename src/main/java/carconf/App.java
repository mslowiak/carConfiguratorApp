package carconf;

import carconf.entity.Model;
import carconf.service.impl.ModelServiceImpl;

import java.util.List;

public class App {
    public static void main(String[] args) {
        ModelServiceImpl modelService = new ModelServiceImpl();
        List<Model> allModels = modelService.getAllModels();
        for(Model m : allModels){
            System.out.println(m);
        }
    }
}
