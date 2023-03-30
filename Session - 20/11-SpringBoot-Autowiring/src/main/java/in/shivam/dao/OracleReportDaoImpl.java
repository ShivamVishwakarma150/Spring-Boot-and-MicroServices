package in.shivam.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class OracleReportDaoImpl implements ReportDao {
	
	
	public OracleReportDaoImpl() {
		System.out.println("OracleReportDaoImpl :: Constructor");
	}
	
	@Override
	public String findData() {
		System.out.println("fetching report from Oracle db");
		return "Report Data";
	}

}
