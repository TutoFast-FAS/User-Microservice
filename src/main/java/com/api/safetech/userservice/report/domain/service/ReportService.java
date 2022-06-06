package com.api.safetech.userservice.report.domain.service;

import com.api.safetech.userservice.report.domain.model.entity.Report;

import java.util.List;

public interface ReportService {
    List<Report> getAll();
    Report getById(Long reportId);
    List<Report> getByUserId(Long userId);
    Report create(Report report, Long userId);
    Report update(Long reportId, Report report);
    Report delete(Long reportId);
}