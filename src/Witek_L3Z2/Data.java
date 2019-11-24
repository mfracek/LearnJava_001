package Witek_L3Z2;

/**
 * @author Witek
 *
 */
public class Data {
	
	int day;
	int month;
	int year;
	
	Data(int d, int m, int y){  //konstruktor
		day = d;
		month = m;
		year = y;
	}
	
	boolean CzyPrzestepny(){		//Metoda która sprawdza czy dany rok jest przestêpny.
		return CzyPrzestepnyPodany(year);
	}
	
	boolean CzyPrzestepnyPodany(int rok){		//Metoda która sprawdza czy dany PODANY rok jest przestêpny.
		if(rok%100==0 && rok%4==0){
			return true;
		}
		else{
			if(rok%4==0){
				return true;
			}
			else{
				return false;
			}
		}
	}
	
	boolean CzyPoprawna(){			//Metoda sprawdza czy podana data jest poprawna.
		boolean retVal = false;
		
		if(month > 0 && month <= 12 && year > 0) {
	    	if(day > 0 && day <= IleDniWMiesiacu()) {
				retVal = true;
			}
			else{
		    	retVal = false;
			}
		} else {
			retVal = false;
		}
		return retVal;
	}
	
	/**
	 * 
	 * @return number of days in the month of the object
	 */
	int IleDniWMiesiacu(){		//Metoda wypisuje ile dni ma dany miesiac.
	  return IleDniWMiesiacuYM(year, month);
	}

	/**
	 * 
	 * @return number of days in the month of the given year and month
	 */
	int IleDniWMiesiacuYM(int iYear, int iMonth) {		//Metoda wypisuje ile dni ma dany miesi¹c.
		int retVal = 0;
	  if (iMonth >= 1 && iMonth <=12) {
		switch (iMonth) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			retVal = 31;
			break;
		case 2:
			if(CzyPrzestepnyPodany(iYear)){
				retVal = 29;
			} else {
				retVal = 28;
			}
			break;
		default:
			retVal = 30;
		}
	  } else {
		  retVal = -1;
	  }
	  return retVal;
	}	
	
	/** KtoryToDzien
	 * 
	 * @return The day number of the year
	 */
	int KtoryToDzien(){			//Metoda wypisuje ltórym dniem w roku jest podany dzieñ.
		int suma = day;
		for(int i=1; i < month; i++){
		  suma = suma + IleDniWMiesiacuYM(year, i);
		}
		return suma;
	}

	int RoznicaDni(Data p){		//Metoda liczy ró¿nicê pomiêdzy dwoma dniami.
		int roznica=0;
		int rokP=p.year;		//Zmienna bêd¹ca porównywanym rokiem.
		int rokBase=this.year;	//Zmienna bêd¹ca podstawowym rokiem.
		if(rokBase>rokP){
			if(p.CzyPrzestepny()){
				roznica=366-p.KtoryToDzien();
				rokP=rokP+1;
			}
			else{
				roznica=365-p.KtoryToDzien();
			}
			for(int i=0; rokBase>rokP+i; i++){
				if(p.CzyPrzestepny()){
					roznica=roznica+366;
				}
				else{
					roznica=roznica+365;
				}
			}
			roznica=roznica+KtoryToDzien();
		}
		else{
			if(rokBase==rokP){
				roznica=Math.abs(p.KtoryToDzien()-KtoryToDzien());
			}
			else{
				if(CzyPrzestepny()){
					roznica=366-KtoryToDzien();
					rokBase=rokBase+1;
				}
				else{
					roznica=365-KtoryToDzien();
					rokBase=rokBase+1;
				}
				for(int i=0; rokP>rokBase+i; i++){
					if(CzyPrzestepny()){
						roznica=roznica+366;
					}
					else{
						roznica=roznica+365;
					}
				}
				roznica=roznica+p.KtoryToDzien();
			}
		}
		return roznica;
	}

	int[] DataZaKDni(int k){	//Metoda liczy jaki dzieñ bêdzie za K dni.
		
		int rok=this.year;
		int dzien=this.day;
		int miesiac=this.month;
		int[]data={dzien, miesiac, rok};
		
		for(int i=0; i<k; i++){
			data[0]=data[0]+1;					//data[1] to miesiac
			if(data[0] > IleDniWMiesiacuYM(data[2], data[1])){			//data[2] to rok
				data[0]=1;
				data[1]=data[1]+1;
				if(data[1]>12){
					data[1]=1;
					data[2]=data[2]+1;
				}
			}
		}

		return data;
	}

	/**
	 * DataKDniTemu
	 * @param 
	 * @return
	 */
	int[] DataKDniTemu(int k){	//Metoda liczy jaki dzien byl K dni temu.
		int rok=this.year;
		int dzien=this.day;
		int miesiac=this.month;
		int[]data={dzien, miesiac, rok};
		
		for(int i=0; i<k; i++){
			                                        //data[0] to dzien
				data[0]=data[0]-1;					//data[1] to miesiac
				if(data[0]<1){						//data[2] to rok
					data[1]=data[1]-1;
					if(data[1]>=1){
						data[0]=IleDniWMiesiacuYM(data[2], data[1]);
					}
					else{
						data[2]=data[2]-1;
						data[1]=12;
						data[0]=31;
					}
				}
		}
		return data;
	}
}