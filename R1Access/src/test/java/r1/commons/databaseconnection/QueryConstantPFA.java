package r1.commons.databaseconnection;

import r1.commons.BasePage;

public class QueryConstantPFA extends BasePage{
	
	public String PFA_419028_SQL10()
	{
		return "select * from registrations where sex='M'";
	}

	public String PFA_419029_SQL11()
	{
		return "select v.encounterid,r.sex, (DATEDIFF(DAY, r.DOB, r.AdmitDate) / 365) as age from vwRegistrationProcessUnscreened v inner join registrations r on  v.encounterid=r.encounterid\r\n" + 
				"where r.sex='F' and (DATEDIFF(DAY, r.DOB, r.AdmitDate) / 365) >'54'";
		
	}
	
	public String PFA_419030_SQL12()
	{
		return "select v.encounterid,r.sex, (DATEDIFF(DAY, r.DOB, r.AdmitDate) / 365) as age from vwRegistrationProcessUnscreened v inner join registrations r on  v.encounterid=r.encounterid\r\n" + 
				"where r.sex='F' and (DATEDIFF(DAY, r.DOB, r.AdmitDate) / 365) <'54'";
	}
	
	
	

}
