import java.util.Map;
import java.util.HashMap;

public class DialingCodes {
    
    private Map<Integer, String> dialingCodesMap;

    public DialingCodes() {
        dialingCodesMap = new HashMap<>();
    }

    /**
     * Returns the current map of dialing codes to countries
     * @return Map of Integer (dialing code) to String (country)
     */
    public Map<Integer, String> getCodes() {
        return dialingCodesMap;
    }

    /**
     * Sets or updates a dialing code with the corresponding country
     * If the dialing code already exists, it updates the country
     * @param code the dialing code
     * @param country the country name
     */
    public void setDialingCode(Integer code, String country) {
        dialingCodesMap.put(code, country);
    }

    /**
     * Retrieves the country name for a given dialing code
     * @param code the dialing code to look up
     * @return the country name, or null if the code doesn't exist
     */
    public String getCountry(Integer code) {
        return dialingCodesMap.get(code);
    }

    /**
     * Adds a new dialing code entry only if neither the code nor the country
     * already exist in the map. Does nothing if either already exists.
     * @param code the dialing code
     * @param country the country name
     */
    public void addNewDialingCode(Integer code, String country) {
        if (dialingCodesMap.containsKey(code)) {
            return; // Do nothing if code already exists
        }
        if (dialingCodesMap.containsValue(country)) {
            return; // Do nothing if country already exists
        }
        dialingCodesMap.put(code, country);
    }

    /**
     * Finds the dialing code for a given country
     * @param country the country name to search for
     * @return the dialing code for the country, or null if not found
     */
    public Integer findDialingCode(String country) {
        for (Map.Entry<Integer, String> entry : dialingCodesMap.entrySet()) {
            if (entry.getValue().equals(country)) {
                return entry.getKey();
            }
        }
        return null; // Country not found
    }

    /**
     * Updates the dialing code for an existing country
     * Does nothing if the country is not currently in the map
     * @param code the new dialing code
     * @param country the country whose code should be updated
     */
    public void updateCountryDialingCode(Integer code, String country) {
        Integer existingCode = findDialingCode(country);
        if (existingCode == null) {
            return; // Do nothing if country is not in the map
        }
        // Remove the old entry
        dialingCodesMap.remove(existingCode);
        dialingCodesMap.put(code, country);
    }
}