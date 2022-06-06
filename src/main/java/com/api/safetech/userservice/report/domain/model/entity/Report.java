package com.api.safetech.userservice.report.domain.model.entity;

import com.api.safetech.userservice.shared.domain.model.AuditModel;
import com.api.safetech.userservice.user.domain.model.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
@Entity
@Table(name = "report")
public class Report extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private String applianceType;

    @NotNull
    @NotBlank
    private String applianceModel;

    @NotNull
    @NotBlank
    private String applianceBrand;

    @NotNull
    @NotBlank
    private String applianceDiagnostic;

    @NotNull
    @NotBlank
    private String reparationDetails;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "report_user_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User user;

}