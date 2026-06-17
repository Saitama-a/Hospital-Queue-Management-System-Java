package gms;

import java.io.*;
import java.util.ArrayList;

public class FileManager {

private static final String ADMIN_FILE =
        "admins.txt";

private static final String PATIENT_FILE =
        "patients.txt";

// =========================
// ADMINS
// =========================

public static void saveAdmins(
        ArrayList<Admin> admins) {

    try (PrintWriter pw =
                 new PrintWriter(ADMIN_FILE)) {

        for (Admin a : admins) {

            pw.println(a.toString());
        }

    } catch (Exception e) {

        e.printStackTrace();
    }
}

public static ArrayList<Admin> loadAdmins() {

    ArrayList<Admin> admins =
            new ArrayList<>();

    File file =
            new File(ADMIN_FILE);

    if (!file.exists()) {

        admins.add(
                new Admin(
                        "admin",
                        "admin123"));

        saveAdmins(admins);

        return admins;
    }

    try (BufferedReader br =
                 new BufferedReader(
                         new FileReader(file))) {

        String line;

        while ((line =
                br.readLine()) != null) {

            String[] p =
                    line.split(",");

            if (p.length == 2) {

                admins.add(
                        new Admin(
                                p[0],
                                p[1]));
            }
        }

    } catch (Exception e) {

        e.printStackTrace();
    }

    return admins;
}

// =========================
// PATIENTS
// =========================

public static void savePatients(
        ArrayList<Patient> patients) {

    try (PrintWriter pw =
                 new PrintWriter(
                         PATIENT_FILE)) {

        for (Patient p : patients) {

            pw.println(
                    p.getToken() + ","
                            + p.getName() + ","
                            + p.getDisease() + ","
                            + p.getStatus());
        }

    } catch (Exception e) {

        e.printStackTrace();
    }
}

public static ArrayList<Patient> loadPatients() {

    ArrayList<Patient> patients =
            new ArrayList<>();

    File file =
            new File(PATIENT_FILE);

    if (!file.exists()) {
        return patients;
    }

    try (BufferedReader br =
                 new BufferedReader(
                         new FileReader(file))) {

        String line;

        while ((line =
                br.readLine()) != null) {

            String[] p =
                    line.split(",");

            if (p.length == 4) {

                patients.add(
                        new Patient(
                                Integer.parseInt(p[0]),
                                p[1],
                                p[2],
                                p[3]));
            }
        }

    } catch (Exception e) {

        e.printStackTrace();
    }

    return patients;
}
}
