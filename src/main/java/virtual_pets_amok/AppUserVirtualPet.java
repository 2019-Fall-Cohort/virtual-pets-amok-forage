package virtual_pets_amok;

import java.util.Scanner;

public class AppUserVirtualPet {

	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);
		PetShelter userPetShelter = new PetShelter();

		System.out.println("Welcome to the Virtual Pet Shelter!");
		System.out.println("Please populate your virtual pet shelter.");
		System.out.println("Add at least one pet to your shelter.");
		System.out.print("Give your pet a three-letter name:\n> ");
		
		String petName = userInput.nextLine();

		VirtualPet userPet = new VirtualPet(petName);

		userPetShelter.takeInPet(userPet);

		boolean userIsAddingPetsToShelter = true;

		while (userIsAddingPetsToShelter == true) {
			System.out.print("Add another pet? y/n\n> ");
			String response = userInput.nextLine();

			if (response.equalsIgnoreCase("n")) {
				userIsAddingPetsToShelter = false;
			} else { // add a pet to shelter
				System.out.print("Give the next pet a three-letter name:\n> ");
				String additionalPetName = userInput.nextLine();

				VirtualPet additionalPet = new VirtualPet(additionalPetName);

				userPetShelter.takeInPet(additionalPet);

			}

		}

		System.out.print("What would you like to do today?\n> ");

		boolean userAnswer = true;

		while (userAnswer) {
			printMenu();
			String response = userInput.nextLine().toUpperCase();
			if (response.isEmpty()) {
				continue;
			}
			switch (response.charAt(0)) {

				case 'S':// shows all pets in shelter
					System.out.println(userPetShelter.petsAndStatusHeader());
					System.out.println(userPetShelter.printAllPetsAndStatsInTheShelter());
					break;
				case 'F': //Feed all pets.
					System.out.print("How much would you like to feed the pets? Type a modest integer:\n> ");
					int amountToFeed = userInput.nextInt();
					userPetShelter.feedAllPets(amountToFeed);
					userPetShelter.tickAllPets();
					break;
				case 'P': //Play with single pet.
					System.out.println("These are the pets in the shelter.");
					System.out.println(userPetShelter.showAllPetNames());
					System.out.print("Which pet do you want to play with?\n> ");
					String selectPetForPlay = userInput.nextLine();
					userPetShelter.playWithOnePet(selectPetForPlay);
					userPetShelter.tickAllPets();
					break;
				case 'G'://Give med to single pet.
					System.out.println("These are the pets in the shelter.");
					System.out.println(userPetShelter.showAllPetNames());
					System.out.print("Which pet do you want to Give Meds?\n> ");
					String selectPetForMeds = userInput.nextLine();
					userPetShelter.medicateOnePet(selectPetForMeds);
					userPetShelter.tickAllPets();
					break;
				case 'T': //Take single pet out of shelter.");
					System.out.print("Which pet do you want to take out of the shelter?\n> ");
					String selectedPetForAdoption = userInput.nextLine();
					VirtualPet petToRemove = userPetShelter.getPetFromPetName(selectedPetForAdoption);
					userPetShelter.removePet(petToRemove);
					userPetShelter.tickAllPets();
					break;
				case 'Q': 
					userAnswer = false;
					break;
				default:
					System.out.println("default");
					break;
			}

		} 

		System.out.println("Thank you for using the Virtual Pet Shelter today!");

	} 

	public static void printMenu() {
		System.out.println("Please enter the letter for the task " + "you would like to perform:");
		System.out.println("[S]how all pets in the shelter.");
		System.out.println("[F]eed all pets.");
		System.out.println("[P]lay with single pet.");
		System.out.println("[G]ive meds to single pet.");
		System.out.println("[T]ake single pet out of shelter.");
		System.out.println("[Q]uit");
		System.out.println();
		System.out.print(">  ");
	}
}

