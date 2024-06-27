package com.membershipapi.api.model.external;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

public class PaymentModelDto {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @JdbcTypeCode(Types.VARCHAR)
    private UUID databaseID;

    @JdbcTypeCode(Types.VARCHAR)
    private UUID profileID;

    @JdbcTypeCode(Types.VARCHAR)
    private UUID selectedMembershipId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatusEnum status;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private LocalDate startDate = LocalDate.now();

    @Column(nullable = false)
    private LocalDate endDate = LocalDate.now().plusDays(30);

    @Column(nullable = false)
    private String membershipName;

    public enum PaymentStatusEnum {
        PENDING,
        PAID;
    }
}
