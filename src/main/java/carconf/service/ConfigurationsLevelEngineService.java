package carconf.service;

import carconf.entity.ConfigurationsLevelEngine;

import java.util.List;

public interface ConfigurationsLevelEngineService {
    List<ConfigurationsLevelEngine> getConfigurations();
    List<ConfigurationsLevelEngine> getConfigurationsByLevelId(int levelId);
}
