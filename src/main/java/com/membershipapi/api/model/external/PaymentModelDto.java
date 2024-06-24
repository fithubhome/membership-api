package com.membershipapi.api.model.external;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
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

    private UUID profileID;
    private UUID selectedMembershipId;
//    private String personName;
//    private String cardNr;
//    private String cvc;
//    private YearMonth cardExpirationDate;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatusEnum status;
    private Double price;
//    private LocalDate startDate = LocalDate.now();
//    private LocalDate endDate = LocalDate.now().plusDays(30);

    public enum PaymentStatusEnum {
        PENDING,
        PAID;
    }
}
