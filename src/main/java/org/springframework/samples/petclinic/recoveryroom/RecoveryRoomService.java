package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RecoveryRoomService {
	
	private RecoveryRoomRepository recoveryRoomRepository;
	
	@Autowired
	public RecoveryRoomService(RecoveryRoomRepository recoveryRoomRepository) {
		this.recoveryRoomRepository = recoveryRoomRepository;
	}
	
	@Transactional(readOnly = true)
    public List<RecoveryRoom> getAll(){
        return recoveryRoomRepository.findAll();
    }

	@Transactional(readOnly = true)
    public List<RecoveryRoomType> getAllRecoveryRoomTypes(){
        return recoveryRoomRepository.findAllRecoveryRoomTypes();
    }

	@Transactional(readOnly = true)
    public RecoveryRoomType getRecoveryRoomType(String typeName) {
        return recoveryRoomRepository.getRecoveryRoomType(typeName);
    }

	@Transactional(readOnly = true)
    public List<RecoveryRoom> getRecoveryRoomsBiggerThan(double size) {
        return recoveryRoomRepository.findBySizeMoreThan(size);
    }

	@Transactional
    public RecoveryRoom save(RecoveryRoom p) {
        return recoveryRoomRepository.save(p);       
    }

    
}
