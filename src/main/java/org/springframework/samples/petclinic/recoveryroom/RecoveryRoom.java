package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.samples.petclinic.model.NamedEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "recovery_rooms")
public class RecoveryRoom extends NamedEntity{

	@Min(value = 0)
	@NotNull
	double size;
	
	@NotNull
    boolean secure;
    
    @ManyToOne(optional = false)
    @NotNull
    RecoveryRoomType roomType;
}
