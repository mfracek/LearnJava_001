package Witek_L3Z2;
import java.util.Scanner;

public class KalendarzL3Z2 {

	public static void main(String[] args) {
		Scanner skan = new Scanner(System.in);
		System.out.println("Podaj date.");
		System.out.println("Dzien:");
		int day1=skan.nextInt();
		System.out.println("Miesiac:");
		int month1=skan.nextInt();
		System.out.println("Rok:");
		int year1=skan.nextInt();
		
		System.out.println("Podaj date porownawcza.");
		System.out.println("Dzien:");
		int day2=skan.nextInt();
		System.out.println("Miesiac:");
		int month2=skan.nextInt();
		System.out.println("Rok:");
		int year2=skan.nextInt();
		
		
		System.out.println("Podaj dla jakiego odstepu czasu chcesz liczyc date w przod i w tyl.");
		int k=skan.nextInt();				//parametr mówi¹cy ile dni up³ynie w przód lub w ty³ od tej daty.
		
		Data d1 = new Data(day1, month1, year1);
		Data d2 = new Data(day2, month2, year2);
		
		if(d1.CzyPoprawna()){
			System.out.println("Poprawna data.");
		}
		else{
			System.out.println("Bledna data.");
		}
		
		if(d1.CzyPoprawna()){	
			System.out.println("Data: " + day1 + "." + month1+ "." + year1 + "r.");
			
			if(d1.CzyPrzestepny()){
				System.out.println("Rok " + year1 +  " jest przestepny.");
			}
			else{
				System.out.println("Rok " + year1 + " NIE jest przestepny.");
			}
			
			System.out.println("Liczba dni w miesiacu: " + d1.IleDniWMiesiacu());
			System.out.println("Jest to " + d1.KtoryToDzien() + ". dzien w roku.");
			if(d2.CzyPoprawna()){
				System.out.println("Roznica dni: " + d1.RoznicaDni(d2));
			}
			else{
				System.out.println("Niepoprawna druga data.");
			}
			
			System.out.println("Za " + k + " dni bedzie " + d1.DataZaKDni(k)[0] + "." +
					d1.DataZaKDni(k)[1] + "." + d1.DataZaKDni(k)[2] + "r.");
			
			System.out.println( k + " dni temu byl " + d1.DataKDniTemu(k)[0] + "." + 
				d1.DataKDniTemu(k)[1] + "." + d1.DataKDniTemu(k)[2] + "r.");
						
		}
	}
}