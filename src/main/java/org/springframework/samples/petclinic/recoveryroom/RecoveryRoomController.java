package org.springframework.samples.petclinic.recoveryroom;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RecoveryRoomController {

	private RecoveryRoomService recoveryRoomService;

	@Autowired
	public RecoveryRoomController(RecoveryRoomService recoveryRoomService) {
		this.recoveryRoomService = recoveryRoomService;
	}
	
	@ModelAttribute("types")
	public Collection<RecoveryRoomType> populateRoomTypes() {
		return this.recoveryRoomService.getAllRecoveryRoomTypes();
	}

	@InitBinder("recoveryRoom")
	public void initPetBinder(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@GetMapping(value = "/recoveryroom/create")
	public String initCreationForm(ModelMap model) {
		RecoveryRoom room = new RecoveryRoom();
		model.put("recoveryRoom", room);
		return "recoveryroom/createOrUpdateRecoveryRoomForm";
	}

	@PostMapping(value = "/recoveryroom/create")
	public String processCreationForm(@Valid RecoveryRoom room, BindingResult result, ModelMap model) {		
		if (result.hasErrors()) {
			model.put("recoveryRoom", room);
			return "recoveryroom/createOrUpdateRecoveryRoomForm";
		}
		else {
			this.recoveryRoomService.save(room);
			return "welcome";
		}
	}

}
