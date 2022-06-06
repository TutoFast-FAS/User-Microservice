package com.api.safetech.userservice.report.mapping;

import com.api.safetech.userservice.report.domain.model.entity.Report;
import com.api.safetech.userservice.report.resource.CreateReportResource;
import com.api.safetech.userservice.report.resource.ReportResource;
import com.api.safetech.userservice.report.resource.UpdateReportResource;
import com.api.safetech.userservice.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class ReportMapper implements Serializable {

    @Autowired
    private EnhancedModelMapper mapper;

    //Object Mapping
    public ReportResource toResource(Report model){
        return mapper.map(model,ReportResource.class);
    }

    public List<ReportResource> toResource(List<Report>model){
        return mapper.mapList(model, ReportResource.class);
    }

    public Report toModel(CreateReportResource resource){
        return mapper.map(resource, Report.class);
    }

    public Report toModel(UpdateReportResource resource){
        return mapper.map(resource, Report.class);
    }


}