package toy.five.triprecord.domain.user.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import toy.five.triprecord.domain.user.dto.request.UserPatchRequest;
import toy.five.triprecord.domain.user.dto.request.UserUpdateReqeust;
import toy.five.triprecord.global.common.BaseTimeEntity;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(updatable = false)
    private String email;

    @Column
    private String password;

    @Column
    private String name;
    
    

    
    private void setUpdatePassword(String password) {
        this.password = password;
    }

    private void setUpdateName(String name) {
        this.name = name;
    }

    private void setPatchPassword(String password) {
        if (!StringUtils.isBlank(password)) {
            this.password = password;
        }
    }

    private void setPatchName(String name) {
        if (!StringUtils.isBlank(name)) {
            this.name = name;
        }
    }

    public void setUpdateColumns(UserUpdateReqeust userUpdateReqeust) {
        setUpdatePassword(userUpdateReqeust.getPassword());
        setUpdateName(userUpdateReqeust.getName());
    }

    public void setPatchColumns(UserPatchRequest userPatchRequest) {
        setPatchPassword(userPatchRequest.getPassword());
        setPatchName(userPatchRequest.getName());
    }




}
