package ru.otus.architect.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HealthCheck {
    private String status;
    private UUID svcUuid;
    private String svcName;
}
