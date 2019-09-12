package VirtualPetsAmok;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class PetShelter {

	HashMap<String, VirtualPet> petsInTheShelter;
	
	public PetShelter() {
		petsInTheShelter = new HashMap<>();
	}
	
//	public HashMap<String, VirtualPet> getPetsInTheShelter() {
//		return petsInTheShelter;
//	}
	public Collection<VirtualPet> getPetsInTheShelter() {
		return petsInTheShelter.values();
	}

	public void takeInPet(VirtualPet pet) {
		petsInTheShelter.put(pet.getPetName(), pet); 
	}

	public void removePet(VirtualPet pet) {
		petsInTheShelter.remove (pet);
		
	}


	public Collection<String> retrievePetsAndStatus() {
		
		ArrayList <String> statuses = new ArrayList<>();
		int i = 0;
		while (i < statuses.size())
		{
			statuses.add(i, petsInTheShelter.getValue().toString());
		}
		return null;
	}

}