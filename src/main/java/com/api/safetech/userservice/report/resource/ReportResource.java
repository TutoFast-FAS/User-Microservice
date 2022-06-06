package com.api.safetech.userservice.report.resource;

import com.api.safetech.userservice.user.resource.UserResource;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReportResource {
    private Long id;
    private String applianceType;
    private String applianceModel;
    private String applianceBrand;
    private String applianceDiagnostic;
    private String reparationDetails;
    private UserResource user;
}
