package model.pimpekStatistic;

public interface PimpekStatistics {

    void incrementEnergyPoints(int toAdd);
    void incrementCloningPoints();
    int getEnergyPoints();
    int getCloningPoints();
    boolean isLive();
    void registerDeath();
}
