package nym.nym.user.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nym.nym.estate.adapter.out.persistence.EstateEntity;
import nym.nym.global.common.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Builder
@Getter
public class UserEntity extends BaseEntity {
    @Id
    @Column(name = "user_id",unique = true,nullable = false)
    private Long userId;

    @Column(name = "user_nick_name",nullable = false)
    private String userNickName;

    //토지랑 일대다 양방향
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<EstateEntity> estates=new ArrayList<>();
}
