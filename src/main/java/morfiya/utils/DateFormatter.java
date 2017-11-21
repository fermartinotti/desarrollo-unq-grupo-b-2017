package morfiya.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatter {
	
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");


	public static LocalDate formatLocalDate(String fechaVigenciaDesde){
		
		LocalDate fechaVigenciaD = LocalDate.parse(fechaVigenciaDesde.subSequence(0, 10), formatter);
		
		return fechaVigenciaD;
	}
	
//	public static ArrayList<LocalTime> formatLocalTime( ArrayList<String> horariosDeEntrega){
//		ArrayList<LocalTime> horariosRet = new ArrayList<LocalTime>();
//		for(String horario : horariosDeEntrega){
//			horariosRet.add(LocalTime.parse(horario));
//		}
//		
//		return horariosRet;
//	}

	public DateFormatter() {
		super();
	}	
}
