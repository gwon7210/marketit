package com.test.marketit.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private Boolean isCompleted;

    @CreationTimestamp
    private Timestamp registerDate;

    @OneToMany(mappedBy = "orders")
    private List<OrderProducts> orderProducts;

    public Orders(String userName, Boolean isCompleted) {
        this.userName = userName;
        this.isCompleted = isCompleted;
    }

    public Orders updateIsCompleted(Boolean isCompleted) {
        this.isCompleted = isCompleted;
        return this;
    }

}
