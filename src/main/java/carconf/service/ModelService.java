package carconf.service;

import carconf.entity.Model;

import java.util.List;

public interface ModelService {
    List<Model> getAllModels();
    List<Model> getModelById(int ID);
}
