package com.kk.spring_data_jpa_tut.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@AttributeOverrides({
        @AttributeOverride(name= "guardianName",column = @Column(name = "guardian_Name")),
        @AttributeOverride(name="guardianEmail",column=@Column(name="guardian_Email")),
        @AttributeOverride(name="guardianMobile",column = @Column(name="guardian_Mobile"))
})
public class Guardian {
    private String guardianName;
    private String  guardianEmail;
    private String guardianMobile;
}
