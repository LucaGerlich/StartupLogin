package com.company;

import java.io.*;
import java.util.*;

public class safe{
    Calendar cal = Calendar.getInstance();
    String tempName;
    String tempPw;
    String tempEmail;
    int YesNo;

    public void setSpeichernText(String name, String pw, String email) {
        try {
            FileWriter fw = new FileWriter("text.txt");
            fw.write("Name: ");
            fw.write(name);
            fw.write("\nPasswort: ");
            fw.write(pw);
            fw.write("\nEmail: ");
            fw.write(email);
            fw.write("\n");
            fw.write("\nErstellt: ");
            fw.write("\nDatum: " + cal.get( Calendar.DAY_OF_MONTH ) +
                    "." + (cal.get( Calendar.MONTH ) + 1 ) +
                    "." + cal.get( Calendar.YEAR ) );
            fw.write("\nUhrzeit: " + cal.get( Calendar.HOUR_OF_DAY ) + ":" +
                    cal.get( Calendar.MINUTE ) + ":" +
                    cal.get( Calendar.SECOND ) );
            fw.close();
            System.out.println("\n" + 
                                "Name: " + name +
                                "\nEmail: " + email + 
                                "\npw: " + pw);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("\ngespeichert...\n");
    }

    public void login(String name, String pw, String email) {
        Scanner logininput  = new Scanner(System.in);
            System.out.println("Name oder Email:");
            tempName = logininput.next();
            System.out.println("Passwort: ");
            tempPw = logininput.next();

        try {
            if(tempName.equals(name ) || tempName.equals(email) && tempPw.equals(pw) ) {
                System.out.println("login erfolgreich");
                System.out.println("\n");
            }else {
                System.out.println("login fehlgeschlagen");
                System.out.println("\n");
            }
        } catch (Exception e) {
            System.out.println(e);
			logininput.close();
        }
    }

    public void deleteAdresse(String name, String pw, String email) {
        Scanner deleteinput  = new Scanner(System.in);
        System.out.println("Sind sie sich sicher?\n" +
                    "1: JA \n" +
                    "2: NEIN\n");        
        YesNo = deleteinput.nextInt();
        
        switch(YesNo){
            case 1:
              try {
                  //todo: Strings überschreiben so das sie nicht mehr verfügbar sind!
                FileWriter fw = new FileWriter("text.txt");
                fw.write("Name: ");
                fw.write("\nPasswort: ");
                fw.write("\nEmail: ");
                fw.write("\n");
                fw.write("\nGelöscht: ");
                fw.write("\nDatum: " + cal.get( Calendar.DAY_OF_MONTH ) +
                        "." + (cal.get( Calendar.MONTH ) + 1 ) +
                        "." + cal.get( Calendar.YEAR ) );
                fw.write("\nUhrzeit: " + cal.get( Calendar.HOUR_OF_DAY ) + ":" +
                        cal.get( Calendar.MINUTE ) + ":" +
                        cal.get( Calendar.SECOND ) );
                fw.close();
            System.out.println("Account wurde gelöscht");
            } catch (Exception e) {
                System.out.println(e);
                deleteinput.close();
            }
        }        
    }

    public void encrypt(String name, String pw, String email){
        try {
            FileWriter fwe = new FileWriter("encrypt.txt");
            fwe.write("\n");
            fwe.write("\nErstellt: ");
            fwe.write("\nDatum: " + cal.get(Calendar.DAY_OF_MONTH) +
                    "." + (cal.get(Calendar.MONTH) + 1) +
                    "." + cal.get(Calendar.YEAR));
            fwe.write("\nUhrzeit: " + cal.get(Calendar.HOUR_OF_DAY) + ":" +
                    cal.get(Calendar.MINUTE) + ":" +
                    cal.get(Calendar.SECOND));
            fwe.close();
            } catch (Exception p) {
            System.out.println(p);
        }
        System.out.println("Verschlüsselt...\n");
    }

    public void decrypt(String name, String pw, String email){
        try {
            FileWriter fwe = new FileWriter("decrypt.txt");
            fwe.write("\n");
            fwe.write("\nErstellt: ");
            fwe.write("\nDatum: " + cal.get(Calendar.DAY_OF_MONTH) +
                    "." + (cal.get(Calendar.MONTH) + 1) +
                    "." + cal.get(Calendar.YEAR));
            fwe.write("\nUhrzeit: " + cal.get(Calendar.HOUR_OF_DAY) + ":" +
                    cal.get(Calendar.MINUTE) + ":" +
                    cal.get(Calendar.SECOND));
            fwe.close();
            } catch (Exception p) {
            System.out.println(p);
        }
        System.out.println("Entschlüsselt...\n");
    }

    public void ServerStop() {
        System.exit(0);
	}
}
