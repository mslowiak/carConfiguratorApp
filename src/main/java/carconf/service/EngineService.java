package carconf.service;

import carconf.entity.Engine;

import java.util.List;

public interface EngineService {
    List<Engine> getEngines();
    List<Engine> getEngineByEngineId(int engineId);
}
