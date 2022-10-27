package com.sunconit.share.learnlambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@NoArgsConstructor
public class AcquisitionPointDTO {

  private String name;

  private String cjdId;

  private double longitude;

  private double latitude;

  public void trans(){
    double[] doubles = GpsCoordinateUtils.calBD09toWGS84(latitude, longitude);
    this.latitude = doubles[0];
    this.longitude = doubles[1];
  }

  public AcquisitionPointDTO(String name, String cjdId, double longitude, double latitude) {
    this.name = name;
    this.cjdId = cjdId;
    double[] doubles = GpsCoordinateUtils.calBD09toWGS84(latitude, longitude);
    this.latitude = doubles[0];
    this.longitude = doubles[1];
  }

  {
    this.cjdId = "test";
  }
}
