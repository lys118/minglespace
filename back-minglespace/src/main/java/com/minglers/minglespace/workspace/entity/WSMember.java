package com.minglers.minglespace.workspace.entity;

import com.minglers.minglespace.auth.entity.User;
import com.minglers.minglespace.workspace.role.WSMemberRole;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "wsmember", uniqueConstraints = { @UniqueConstraint(columnNames = {"workspace_id", "user_id"}) })
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Builder
public class WSMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @ColumnDefault("'LEADER'")
    @Column(name = "role", nullable = false)
    private WSMemberRole role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workspace_id")
    private WorkSpace workSpace;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}

