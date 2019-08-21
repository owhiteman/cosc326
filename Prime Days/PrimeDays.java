public class PrimeDays{

    public static void main(String[]args){

	int totalDays = 0;
	int sizeOfMonth = 0;
	int month = 0;

	for(String m : args){
	    sizeOfMonth = Integer.parseInt(args[month]);
	    month++;
	    if(isPrime(month)){
		for(int j = 1; j <= sizeOfMonth; j++){
		    totalDays++;
		    if(isPrime(j) && isPrime(totalDays)){
			System.out.println(totalDays + ": " + month + " " + j);
		    }
		}
	    }else{
		totalDays += sizeOfMonth;
	    }
	}

    }
			        

    public static boolean isPrime(int x){
	if(x > 2 && x % 2 == 0 || x == 1) return false;
	else if(x > 1){
	    int max = (int)Math.sqrt(x) + 1;
	    for(int i = 3; i < max; i += 2){
		if(x % i == 0){
		    return false;
		}
	    }
	}
	return true;
    }

}
