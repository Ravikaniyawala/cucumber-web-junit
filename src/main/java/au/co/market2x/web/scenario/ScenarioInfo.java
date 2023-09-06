package au.co.market2x.web.scenario;

public class ScenarioInfo {

    private static String scenarioName;

    public static String getScenarioName() {
        return scenarioName.trim();
    }

    public static void setScenarioName(String scenarioName)
    {
        ScenarioInfo.scenarioName = scenarioName.trim();
    }


}
