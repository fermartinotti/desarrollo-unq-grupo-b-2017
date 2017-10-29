package morfiya.utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DateFormatter {
	
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");


	public static LocalDate formatLocalDate(String fechaVigenciaDesde){
		
		LocalDate fechaVigenciaD = LocalDate.parse(fechaVigenciaDesde, formatter);
		
		return fechaVigenciaD;
	}
	
	public static ArrayList<LocalTime> formatLocalTime( ArrayList<String> horariosDeEntrega){
		//LocalDateTime time = LocalDate.now().atTime(6, 0);
		ArrayList<LocalTime> horariosRet = new ArrayList<LocalTime>();
		for(String horario : horariosDeEntrega){
			horariosRet.add(LocalTime.parse(horario));
		}
		
		return horariosRet;
	}


	public DateFormatter() {
		super();
	}
	
	public static void main (String [ ] args) {
		 
		//LocalTime todayAt6 = LocalTime.of(22, 0);
		LocalTime todayAt6 = LocalTime.parse("22:20");
		
		System.out.println(todayAt6);

}
	
	
}
