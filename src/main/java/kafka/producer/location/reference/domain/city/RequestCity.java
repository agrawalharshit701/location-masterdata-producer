package kafka.producer.location.reference.domain.city;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class RequestCity {
  private List<Bda> bdas;
  private String name;
  private String locationId;
  private String status;
  private String bdaType;
  private Country country;
  private String geoType;
  private List<Parent> parents;
  private String validTo;
  private String hsudName;
  private String latitude;
  private boolean portFlag;
  private String timeZone;
  private String longitude;
  private String validFrom;
  private String restricted;
  private String description;
  private String dialingCode;
  private List<BdaLocation> bdaLocations;
  private boolean isMaerskCity;
  private String olsonTimezone;
  private List<AlternateCode> alternateCodes;
  private List<AlternateName> alternateNames;
  private List<String> subCityParents;
  private Integer utcOffsetMinutes;
  private String workaroundReason;
  private String daylightSavingEnd;
  private String daylightSavingTime;
  private String daylightSavingStart;
  private Boolean postalCodeMandatory;
  private String dialingCodeDescription;
  private Boolean stateProvinceMandatory;
  private Integer daylightSavingShiftMinutes;

  // Getters and setters (omitted for brevity)
}
