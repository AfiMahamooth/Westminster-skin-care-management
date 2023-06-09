import java.io.*;
import java.util.Collections;
import java.util.Scanner;
public class WestminsterSkinConsultationManager extends Consultation implements SkinConsultationManager {

    public static void main(String[] args) {
        WestminsterSkinConsultationManager obj = new WestminsterSkinConsultationManager();
        //Reading from the date file
        try{
            obj.readData();
        } catch (IOException ignored){

        }
        boolean user_consent = true;
        //Console Menu
        while (user_consent) {
            try {
                System.out.println();
                System.out.println("Welcome to the Consultation System !");
                System.out.println();
                System.out.println("Please enter the relevant number depending on your requirement");
                System.out.println("1: Add a New Doctor");
                System.out.println("2: Delete a Doctor ");
                System.out.println("3: Print the list of doctors");
                System.out.println("4: Save the details in a File");
                System.out.println("5: Show Consultations");
                System.out.println("6: Cancel a Consultation");
                System.out.println("7: Open the Graphical User Interface");
                System.out.println("8: Exit the System");
                System.out.println();
                Scanner s2 = new Scanner(System.in);
                System.out.print("Enter the choice: ");
                int selectedOption = s2.nextInt();
                switch (selectedOption) {
                    case 1 -> obj.addNewDoctor();
                    case 2 -> obj.deleteDoctor();
                    case 3 -> obj.printDoctors();
                    case 4 -> obj.saveFile();
                    case 5 -> consoleShowConsultations();
                    case 6 -> cancelConsultations();
                    case 7 -> new GUI();
                    case 8 -> user_consent = false;
                    default -> System.out.println("Invalid Choice, Please try again");
                }
            } catch (Exception ignored) {
            }
        }
    }

    //Method to add a new doctor to the system
    @Override
    public void addNewDoctor() {
        boolean userConsent = true;
        while (userConsent) {
            if (doctorList.size() >= 10) {
                System.out.println("The doctor list if full.");
                break;
            } else {
                Doctor doctor = new Doctor();
                Scanner s1 = new Scanner(System.in);
                System.out.println("Please enter the Doctor's First Name: ");
                String firstName = s1.nextLine();
                doctor.setName(firstName);
                System.out.println("Please enter Doctor's Last Name: ");
                String Lastname = s1.nextLine();
                doctor.setSurname(Lastname);
                System.out.println("Please enter Doctor's Birth Date (dd/MM/yyyy): ");
                String DOB = s1.nextLine();
                doctor.setDateOfBirth(DOB);
                System.out.println("Please enter Doctor's Mobile Number: ");
                int mobileNumber = s1.nextInt();
                doctor.setMobileNumber(mobileNumber);
                System.out.println("Please enter Doctor's Specialisation: ");
                s1.nextLine();
                String spec = s1.nextLine();
                doctor.setSpecialisation(spec);
                System.out.println("Please enter Doctor's Medical Licence Number: ");
                int MLN = s1.nextInt();
                doctor.setMedicalLicenceNumber(MLN);
                System.out.println("Please confirm below details to add the user: ");
                System.out.println("First Name: " + firstName);
                System.out.println("Surname: " + Lastname);
                System.out.println("Date of Birth: " + DOB);
                System.out.println("Mobile Number: " + mobileNumber);
                System.out.println("Specialisation: " + spec);
                System.out.println("Medical License Number: " + MLN);
                System.out.println();
                System.out.println("Please enter Y to confirm and N to re-enter the details");
                s1.nextLine();
                String confirmation = s1.nextLine();
                if (confirmation.equalsIgnoreCase("Y")) {
                    doctorList.add(doctor);
                    System.out.println("Doctor has been added to the System");
                } else if (confirmation.equalsIgnoreCase("N")) {
                    continue;
                }
                Scanner s3 = new Scanner(System.in);
                System.out.print("Do you want to add another Doctor ? ( Yes / No ): ");
                String userInput = s3.nextLine();
                if (userInput.equalsIgnoreCase("No")) {
                    userConsent = false;
                } else {
                    System.out.println("Invalid Choice");
                    break;
                }
            }
        }
    }

    //Method to delete a doctor from the system
    @Override
    public void deleteDoctor() {
        System.out.println("Please enter the Doctor's Medical License Number: ");
        Scanner s4 = new Scanner(System.in);
        int MLN = s4.nextInt();
        for (int a = 0; a <= doctorList.size(); a++) {
            if (doctorList.get(a).getMedicalLicenceNumber() == MLN) {
                String nameOfRemoval = doctorList.get(a).getName();
                System.out.println("Do you want to delete doctor " + nameOfRemoval + " from the List ? (Y/N)");
                s4.nextLine();
                String confirmation = s4.nextLine();
                if (confirmation.equalsIgnoreCase("y")) {
                    System.out.println("Below doctor is removed from the list: ");
                    System.out.println("Doctor's Name: " + doctorList.get(a).getName());
                    System.out.println("Doctor's Last Name: " + doctorList.get(a).getSurname());
                    System.out.println("Doctor's Date of Birth: " + doctorList.get(a).getDateOfBirth());
                    System.out.println("Doctor's Mobile Number: " + doctorList.get(a).getMobileNumber());
                    System.out.println("Doctor's Specialisation: " + doctorList.get(a).getSpecialisation());
                    System.out.println("Doctor's Medical License Number: " + doctorList.get(a).getMedicalLicenceNumber());
                    doctorList.remove(a);
                    System.out.println();
                    System.out.println("Total Number of Doctors in the Centre: " + doctorList.size());
                    break;
                } else if (confirmation.equalsIgnoreCase("n")) {
                    break;
                } else {
                    System.out.println("Please enter a valid input");
                }
            } else {
                System.out.println("Unable to find a doctor with the mentioned Medical License Number in the List");
                break;
            }
        }
    }

    //Method to print the list of doctors
    @Override
    public void printDoctors() {
        System.out.println();
        if (doctorList.isEmpty()) {
            System.out.println("The Doctor List is Empty");
            System.out.println();
        } else {
            Collections.sort(doctorList);
            System.out.println("Here's the List of Doctors: ");
            System.out.println();
            for (int b = 0; b <= doctorList.size() - 1; b++) {
                System.out.println("Doctor No: " + (b + 1));
                System.out.println("Doctor's Name: " + doctorList.get(b).getName());
                System.out.println("Doctor's Last Name: " + doctorList.get(b).getSurname());
                System.out.println("Doctor's Date of Birth: " + doctorList.get(b).getDateOfBirth());
                System.out.println("Doctor's Mobile Number: " + doctorList.get(b).getMobileNumber());
                System.out.println("Doctor's Specialisation: " + doctorList.get(b).getSpecialisation());
                System.out.println("Doctor's Medical License Number: " + doctorList.get(b).getMedicalLicenceNumber());
                System.out.println();
            }
        }
    }

    //Method to save the system data to a File
    @Override
    public void saveFile() {

            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("systemData.txt"))) {
                for (Doctor doctor : doctorList) {
                    out.writeObject(doctor);
                    System.out.println("Doctor data saved to the file");
                }
                for (Consultation consultation: consultations){
                    out.writeObject(consultation);
                    System.out.println("Consultation data saved to the file");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

    }

    //Method to get data from the file to the system
    void readData() throws IOException{

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("systemData.txt"))) {
            doctorList.add((Doctor) in.readObject());
            consultations.add((Consultation) in.readObject());
        } catch (EOFException ignored){

        } catch (IOException | ClassNotFoundException e ) {
            e.printStackTrace();
        }

    }

    //Method to cancel consultations
    static void cancelConsultations(){

        if(consultations.isEmpty()){
            System.out.println("No Consultations Booked");
        }else{
            Scanner s1 = new Scanner(System.in);
            System.out.println("Please enter the Patient ID: ");
            int patientID = s1.nextInt();

            for (int x=0;x<consultations.size();x++){

                if(consultations.get(x).getPatientId()==patientID){
                    System.out.println("Patient "+consultations.get(x).getName()+"'s Consultation Cancelled");
                    consultations.remove(x);
                }else{
                    System.out.println("Couldn't Find a Consultation with the Mentioned Details");
                }
            }
        }

    }

    //Method to show consultations in the console
    static void consoleShowConsultations(){
        if(consultations.isEmpty()){
            System.out.println("No Consultations");
        }else{
            for (Consultation consultation : consultations) {
                System.out.print("Doctors Name: ");
                System.out.println(consultation.getDoctor().getName() + " " + consultation.getDoctor().getSurname());
                System.out.print("Patient's Name: ");
                System.out.println(consultation.getName() + " " + consultation.getSurname());
                System.out.println("Patient's Date of Birth: ");
                System.out.println(consultation.getDateOfBirth());
                System.out.println("Patient's Mobile Number: ");
                System.out.println(consultation.getMobileNumber());
                System.out.println("Patient ID: ");
                System.out.println(consultation.getPatientId());
                System.out.println("Scheduled Date and Time: ");
                System.out.println(consultation.getConsulationDateandTime());
                System.out.println("Cost: ");
                System.out.println(consultation.getCost());
                System.out.println("Text Notes: ");
                System.out.println(consultation.getNotes());
                System.out.println();
            }

        }

    }

}