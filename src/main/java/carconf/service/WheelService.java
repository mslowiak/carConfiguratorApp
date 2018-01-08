package carconf.service;

import carconf.entity.Wheel;

import java.util.List;

public interface WheelService {
    List<Wheel> getWheels();
    List<Wheel> getWheelsByLevelId(int levelId);
    List<Wheel> getWheelByWheelId(int wheelId);
}
